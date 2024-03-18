package edu.KarryCode.MapReduceForCVLike;

import edu.KarryCode.domain.vo.CustomerVehicleVO;
import edu.KarryCode.mapper.OrdersMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author KarryLiu
 * @Creed may all the beauty be blessed
 * @Date 2023/11/28 下午 7:03
 * @PackageName edu.KarryCode.MapReduceForCVLike
 * @ClassName JobMainTest
 * @Description TODO
 * @Version 1.0
 */
@SpringBootTest
//@Testable
class JobMainTest {
    @Autowired
    JobMain jobMain;

    @Test
    public void test(){

        jobMain.MapReduceStater();
//        String filePath = "E:\\IDEACode\\Car_Rental_System_4.0\\CV_Like_S2_output\\part-r-00000";
//
//        try {
//            Path path = Paths.get(filePath);
//            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
//
//            for (String line : lines) {
//                String[] split = line.split("\t");
//                System.out.println(split[0]);
//                System.out.println(split[1].substring(0,split[1].length() - 1));
//            }
//        } catch (IOException e) {
//            System.out.println("文件读异常");
//        }

    }
}