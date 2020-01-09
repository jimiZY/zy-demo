package cn.cocopup.zy.rocket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="TaskAssignView对象", description="VIEW")
public class TaskAssignView implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "案件id")
    private String caseId;

    @ApiModelProperty(value = "任务id")
    private String taskId;

    @ApiModelProperty(value = "分配关联id")
    private String relateId;

    @ApiModelProperty(value = "分配时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "分配类型 : 分配到组,分配到人")
    private String assignType;

    @ApiModelProperty(value = "结果状态")
    private Integer resultState;

    @ApiModelProperty(value = "提交人")
    private String submitter;

    @ApiModelProperty(value = "任务状态")
    private Integer taskState;

    @ApiModelProperty(value = "任务类型(1:初查服务  2:深入研判 3:远程勘验 4:现场勘验  5:司法鉴定)")
    private Integer taskType;


}
