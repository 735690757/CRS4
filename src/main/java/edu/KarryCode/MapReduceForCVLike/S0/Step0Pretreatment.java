package edu.KarryCode.MapReduceForCVLike.S0;


import edu.KarryCode.domain.vo.CustomerVehicleVO;
import edu.KarryCode.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @Author KarryLiu_刘珂瑞
 * @Creed may all the beauty be blessed
 * @Date 2023/10/12 下午 9:35
 * @PackageName edu.KarryCode.mapReduceTest
 * @ClassName Step0Pretreatment
 * @Description TODO 从数据库中拿数据
 * @Version 1.0
 */
@Component
public class Step0Pretreatment {
    @Autowired
    OrdersMapper iOrderMapper;

    public void getCustomerVehicle() throws IOException {
        FileWriter writer = new FileWriter("./CV_Like_S1_input/SourceData.txt");
        List<CustomerVehicleVO> customerVehicles = iOrderMapper.selectCustomerVehicle();
        for (CustomerVehicleVO customerVehicle : customerVehicles) {
            writer.write(customerVehicle.getVehicleName()+"="+customerVehicle.getCustomerName()+"\n");
        }
        writer.close();
    }
}
