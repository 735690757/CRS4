package edu.KarryCode.controller;

import edu.KarryCode.MapReduceForCVLike.JobMain;
import edu.KarryCode.common.R;
import edu.KarryCode.domain.vo.MRAnsCcvVO;
import edu.KarryCode.service.impl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @Author KarryLiu
 * @Creed may all the beauty be blessed
 * @Date 2023/11/28 下午 9:05
 * @PackageName edu.KarryCode.controller
 * @ClassName MRController
 * @Description TODO MapReduce联想用户共同喜好接口
 * @Version 1.0
 */
@RestController
@RequestMapping("/mr")
public class MRController {
    @Autowired
    JobMain jobMain;
    @Autowired
    private OrdersServiceImpl ordersService;

    /**
     * @return 获取联想结果
     */
    @GetMapping("/getMRAns")
    public R<List<MRAnsCcvVO>> getMRAns(HttpServletRequest request, HttpServletResponse response) {
        List<MRAnsCcvVO> commonPreferences = ordersService.getCommonPreferences();
        if (commonPreferences == null) {
            return R.error("文件读写失败！");
        }
        return R.success(commonPreferences);
    }

    /**
     * @return 获取最近联想时间
     */
    @GetMapping("/getMRTime")
    private R<String> getMRTime() throws IOException {
        String filePath = "MRTime\\MapReduceTime.txt";
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String MRTime = bufferedReader.readLine();
            return R.success(MRTime);
        } catch (FileNotFoundException e) {
            return R.error("时间失败");
        }
    }

    /**
     * @return 启动MapReduce爱好联想
     */
    @GetMapping("/startMR")
    public R<String> startMR() {
        try {
            jobMain.MapReduceStater();
        } catch (Exception e) {
            return R.error("error MR");
        }
        return R.success("success");
    }
}
