package edu.KarryCode;

import edu.KarryCode.domain.po.Admin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/11/3 上午 8:41
 * @PackageName edu.KarryCode
 * @ClassName JWTTest
 * @Description TODO
 * @Version 1.0
 */
//@SpringBootTest
@Slf4j
public class JWTTest {
    @Test
    public void test(){
        Admin build = Admin.builder().id(1).username("admin").password("password").nickname("刘珂瑞").build();
        Map<String, Object> stringAdminHashMap = new HashMap<>();
        stringAdminHashMap.put("user",build);
        String admin = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "admin")
                .setClaims(stringAdminHashMap)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(admin);

    }
    @Test
    public void test2(){
        Claims admin = Jwts.parser()
                .setSigningKey("admin")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImlkIjoxMSwidXNlcm5hbWUiOiJsa3JHb29nbGUiLCJuaWNrbmFtZSI6IuWImOePgueRnum4rem4rSIsInBhc3N3b3JkIjoiMTIzNDU2IiwiZW1haWwiOiI3MzU2OTA3NTdjYXJyeUBnbWFpbC5jb20ifSwiZXhwIjoxNjk5MDE3MzYyfQ.xcz50DkYWqBUN1Ijo5JnFYI8IcRi_uwYyzN-FZghrLw")
                .getBody();
        System.out.println(admin);
    }
}
