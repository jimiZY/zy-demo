package cn.cocopup.zy.rocket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author zouyong
 * @since 2019-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TecLeaderView对象", description="VIEW")
public class TecLeaderView implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "任务id")
    private String taskId;

    private Long reTask;

    private String relateId;

    private String assignType;

    private String ym;

    private Integer resultState;

    private Long taskState;

    private Integer taskType;


}
