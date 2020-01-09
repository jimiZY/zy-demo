package cn.cocopup.zy.rocket;

import cn.cocopup.zy.rocket.dto.AssHistogramDto;
import cn.cocopup.zy.rocket.dto.GetTecRatioDto;
import cn.cocopup.zy.rocket.mapper.TaskAssignViewMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RocketDemoApplicationTests {

    @Autowired
    TaskAssignViewMapper taskAssignViewMapper;

    @Test
    void contextLoads() {

        List<AssHistogramDto> assHistogram = taskAssignViewMapper.getTecAssHistogram(new GetTecRatioDto());

        System.out.println(assHistogram);
    }

}
