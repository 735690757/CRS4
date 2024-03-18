package edu.KarryCode.MapReduceForCVLike;

import edu.KarryCode.MapReduceForCVLike.S0.Step0Pretreatment;
import edu.KarryCode.MapReduceForCVLike.S1.JobMain1;
import edu.KarryCode.MapReduceForCVLike.S2.JobMain2;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/13 上午 9:22
 * @PackageName edu.KarryCode.MapReduceForCVLike
 * @ClassName JobMain
 * @Description TODO 核心任务拉起类
 * @Version 1.0
 */
@Component
public class JobMain {
    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }
    @Autowired
    Step0Pretreatment step0Pretreatment;
    @Autowired
    JobMain1 jobMain1;
    @Autowired
    JobMain2 jobMain2;

    /**
     * 拉起方法
     */
    public void MapReduceStater(){
        File folderToDelete1 = new File("CV_Like_S1_output");
        File folderToDelete2 = new File("CV_Like_S2_output");
        if (folderToDelete1.exists() && folderToDelete1.isDirectory()) {
            deleteFolder(folderToDelete1);
        }
        if (folderToDelete2.exists() && folderToDelete2.isDirectory()) {
            deleteFolder(folderToDelete2);
        }
        try {
            step0Pretreatment.getCustomerVehicle();
            String[] args = new String[12];
            Configuration configuration = new Configuration();
            int run1 = ToolRunner.run(configuration, jobMain1, args);
            int run2 = ToolRunner.run(configuration, jobMain2, args);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\IDEACode\\Car_Rental_System_4.0\\MRTime\\MapReduceTime.txt"))) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            writer.write(simpleDateFormat.format(date));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
