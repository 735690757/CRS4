package edu.KarryCode.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/25 下午 9:08
 * @PackageName edu.KarryCode.common
 * @ClassName EmailSendOperateTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
@Slf4j
class EmailSendOperateTest {
    @Autowired
    EmailSendOperate emailSendOperate;
    @Test
    public void test(){
        emailSendOperate.SendEmail(
                "735690757carry@gmail.com",
                "欢迎使用汽车租赁系统",
                "ohhhhh！感谢你注册使用汽车租赁系统4——后台版，风里雨里等着你，我在CRS4等着你。\n" +
                        "个人博客：https://735690757.github.io/\n" +
                        "网易云音乐歌手页：https://music.163.com/#/artist?id=30003845\n" +
                        "gitee开源地址:https://gitee.com/karry1107\n"+
                        "github开源地址：https://github.com/735690757\n" +
                        "承蒙厚爱，共同进步，愿所有的美好都得以祝愿！\n\n\n" +
                        "               ——KarryLiu/诗岸梦行舟"
        );
    }
}