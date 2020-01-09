package cn.cocopup.zy.rocket.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zy
 * @create 2019-11-07 9:55
 */
@Data
@Accessors(chain = true)
@ApiModel("协查柱状图接收对象")
public class AssHistogramDto {

    /**
     * 年月字符串
     */
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date yearMonth;

    /**
     * 数量
     */
    private Integer count;
}
