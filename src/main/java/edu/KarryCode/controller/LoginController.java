package edu.KarryCode.controller;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/20 下午 6:46
 * @PackageName edu.KarryCode.controller
 * @ClassName LoginController
 * @Description TODO 登录控制接口类
 * @Version 1.0
 */

import edu.KarryCode.common.JwtUtils;
import edu.KarryCode.common.R;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/")
public class LoginController {
    // * @Author KarryLiu_刘珂瑞 * @Description TODO 默认位置重定向
    @GetMapping("/")
    @ResponseBody
    public void indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8080/CRS/index.html");
    }

    /**
     * @param request  request
     * @param response response
     * @param token    令牌
     * @return R
     * @throws IOException 令牌销毁/过期/消失，产生异常
     * @Description 验证JWT令牌
     */
    @PostMapping("/loginCheck")
    public R getLoginCheck(HttpServletRequest request, HttpServletResponse response, @RequestBody String token) throws IOException {
        if (token == null || token.isEmpty()) {
            response.sendRedirect("http://localhost:8080/CRS/index.html");
        }
        String userToken = token;
        if (userToken.endsWith("=")) {
            userToken = userToken.substring(0, userToken.length() - 1);
        }
        System.out.println(userToken);
        Claims claims = null;
        try {
            claims = JwtUtils.parseJWT(userToken);
        } catch (Exception e) {
            response.sendRedirect("http://localhost:8080/CRS/index.html");
            return R.error("认证过期");
        }
        System.out.println(claims);


        return R.success("success");
    }
}
