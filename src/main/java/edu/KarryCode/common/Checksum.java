package edu.KarryCode.common;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/25 下午 6:49
 * @PackageName edu.KarryCode.common
 * @ClassName Checksum
 * @Description TODO 通用验证码生成器
 * @Version 1.0
 */
@Component
public class Checksum {
    /**
     * @param length 给予输出的长度
     * @return 随机验证码
     * @Description TODO 给定长度，随机生成指定长度的验证码
     * @Author 刘珂瑞
     */
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
}
