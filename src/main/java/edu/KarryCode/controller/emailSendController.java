package edu.KarryCode.controller;

import edu.KarryCode.common.Checksum;
import edu.KarryCode.common.R;
import edu.KarryCode.repositoryRedis.CommonToolsRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/25 下午 6:54
 * @PackageName edu.KarryCode.controller
 * @ClassName emailSendController
 * @Description TODO 邮箱发送接口类
 * @Version 1.0
 */
@RestController
@ResponseBody
@RequestMapping("/email")
public class emailSendController {
    @Autowired
    private CommonToolsRedis commonToolsRedis;

    /**
     * @param request the request
     * @param email   用户邮箱
     * @return 返回验证码
     * @Description 随机生成验证码，发送至用户邮箱
     */
    @PostMapping("/checkCode")
    public R<String> checkCode(HttpServletRequest request, @RequestBody String email) {
        String emailX = URLDecoder.decode(email);
        if (emailX.endsWith("=")) {
            emailX = emailX.substring(0, emailX.length() - 1);
        }
//        System.out.println(emailX);
        try {
            // 创建Properties 类用于记录邮箱的一些属性
            Properties props = new Properties();
            // 表示SMTP发送邮件，必须进行身份验证
            props.put("mail.smtp.auth", "true");
            //此处填写SMTP服务器
            props.put("mail.smtp.host", "smtp.qq.com");
            //端口号，QQ邮箱端口587
            props.put("mail.smtp.port", "587");
            // 此处填写，写信人的账号
            props.put("mail.user", "735690757@qq.com");
            // 此处填写16位STMP口令
            props.put("mail.password", "sxtcprqxetdibfaf");

            int length = 6; // 指定验证码长度
            String randomCode = Checksum.generateRandomCode(length);
            System.out.println("随机生成的验证码: " + randomCode);

            Authenticator authenticator = new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };

            Session mailSession = Session.getInstance(props, authenticator);

            MimeMessage message = new MimeMessage(mailSession);

            InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(form);


            InternetAddress to = new InternetAddress(emailX);
            message.setRecipient(MimeMessage.RecipientType.TO, to);


            message.setSubject("您的验证码如下：");


            message.setContent("验证码：" + randomCode + "，欢迎使用汽车租赁系统4", "text/html;charset=UTF-8");

            Transport.send(message);

            commonToolsRedis.addKeyValueWithExpiration(emailX, randomCode, 5, TimeUnit.MINUTES);

            return R.success("success");
        } catch (AddressException e) {
            System.out.println("1");
            String message = e.getCause().getMessage();
            System.out.println(message);
        } catch (MessagingException e) {
            String message = e.getCause().getMessage();
            System.out.println(message);
            return R.error("不正确的邮箱地址/服务器网络连接失败");
        }
        return R.error("error");
    }
}
