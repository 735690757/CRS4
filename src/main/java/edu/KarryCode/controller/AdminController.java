package edu.KarryCode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.KarryCode.common.EmailSendOperate;
import edu.KarryCode.common.JwtUtils;
import edu.KarryCode.common.R;
import edu.KarryCode.domain.po.Admin;
import edu.KarryCode.repositoryRedis.CommonToolsRedis;
import edu.KarryCode.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/20 下午 7:45
 * @PackageName edu.KarryCode.controller
 * @ClassName AdminController
 * @Description TODO AdminController Admin对外暴露的接口类
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CommonToolsRedis commonToolsRedis;
    @Autowired
    private IAdminService iAdminService;
    @Autowired
    EmailSendOperate emailSendOperate;

    /**
     * @param request 请求对象
     * @param admin   前端返回的表单通过Axios封装成Admin对象
     * @return R
     * @Description 登录控制接口
     */
    @PostMapping("/login")
    public R<Admin> loginAdmin(HttpServletRequest request, @RequestBody Admin admin) {
        System.out.println(admin);
//        System.out.println(password);
        LambdaQueryWrapper<Admin> adminLambdaQueryWrapper = new LambdaQueryWrapper<>();
        adminLambdaQueryWrapper.eq(Admin::getUsername, admin.getUsername());
        Admin adminLog = iAdminService.getOne(adminLambdaQueryWrapper);
        if (adminLog == null) {
            System.out.println("No admin found");
//            return "没找到";
            return R.error("用户不存在");
        }
        if (!admin.getPassword().equals(adminLog.getPassword())) {
            System.out.println("密码不对");
//            return "密码不对";
            return R.error("密码不正确");
        }
        request.getSession().setAttribute("admin", adminLog.getId());
        System.out.println("OK");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("user", adminLog);
        request.getSession().setAttribute("sessionToken", JwtUtils.generateJwt(stringObjectHashMap));
        return R.success(adminLog).add("token", JwtUtils.generateJwt(stringObjectHashMap));
    }

    /**
     * @param request request
     * @return R
     * @Description 注销登录的Admin对象，退出登录接口
     */
    @PostMapping("/logout")
    public R<String> logoutAdmin(HttpServletRequest request) {
        request.getSession().removeAttribute("admin");
        return R.success("退出成功");
    }

    /**
     * @param request       request
     * @param admin         前端封装对象
     * @param userCheckCode 邮箱验证码
     * @return
     * @Description 管理员注册接口
     */
    @PostMapping("/register/{userCheckCode}")
    public R<String> registerAdmin(HttpServletRequest request, @RequestBody Admin admin, @PathVariable String userCheckCode) {
        if (admin == null) {
            return R.error("对象参数失效");
        }
        if (admin.getUsername() == null || admin.getUsername().isEmpty()
                || admin.getEmail() == null || admin.getEmail().isEmpty()
                || admin.getNickname() == null || admin.getNickname().isEmpty()
                || admin.getPassword() == null || admin.getPassword().isEmpty()) {
            return R.error("参数不完整");
        }
        //获取邮箱得到生成验证码
        String emailUserEnter = admin.getEmail();
        String generateECode = commonToolsRedis.redisTemplate.opsForValue().get(emailUserEnter);
        //与用户的进行比对
        try {
            if (!generateECode.equals(userCheckCode)) {
                return R.error("邮箱验证码错误");
            }
        } catch (NullPointerException e) {
            return R.error("验证码已经过期/或邮箱不存在");
        }


        Boolean success = iAdminService.regisAdmin(admin);
        if (success) {
            emailSendOperate.SendEmail(admin.getEmail(),
                    "欢迎使用汽车租赁系统",
                    "ohhhhh！感谢你注册使用汽车租赁系统4——后台版，风里雨里等着你，我在CRS4等着你。\n" +
                            "个人博客：https://735690757.github.io/\n" +
                            "网易云音乐歌手页：https://music.163.com/#/artist?id=30003845\n" +
                            "gitee开源地址:https://gitee.com/karry1107\n" +
                            "github开源地址：https://github.com/735690757\n" +
                            "承蒙厚爱，共同进步，愿所有的美好都得以祝愿！\n\n\n" +
                            "               ——KarryLiu/诗岸梦行舟"
            );
            return R.success("注册成功");
        } else {
            return R.error("用户名已经存在");
        }
    }

    /**
     * @param request request
     * @param admin   管理员封装对象
     * @return R
     * @Description 更新用户数据
     */
    @PostMapping("/update")
    public R<String> updateAdmin(HttpServletRequest request, @RequestBody Admin admin) {
        if (admin == null) {
            return R.error("请求实体不存在！");
        }
        Boolean b = null;
        try {
            b = iAdminService.modifyInformation(admin);
        } catch (Exception e) {
            return R.error("SQLSyntaxErrorException:id丢失");
        }
        if (b) {
            return R.success("修改成功！");
        }
        return R.error("修改失败！");
    }
}
