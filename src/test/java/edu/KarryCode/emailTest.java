package edu.KarryCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/25 下午 5:54
 * @PackageName edu.KarryCode
 * @ClassName emailTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
public class emailTest {
    public static String generateRandomCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // 验证码字符集
        StringBuilder code = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
        }

        return code.toString();
    }
    @Test
    public void test() throws MessagingException {
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
        String randomCode = generateRandomCode(length);
        System.out.println("随机生成的验证码: " + randomCode);

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress("735690757carry@gmail.com");
        message.setRecipient(RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("您的验证码如下：");


        // 设置邮件的内容体
        message.setContent("验证码："+randomCode+"，欢迎使用汽车租赁系统4", "text/html;charset=UTF-8");

        Transport.send(message);
    }
}
