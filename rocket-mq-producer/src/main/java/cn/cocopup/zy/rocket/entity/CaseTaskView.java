package cn.cocopup.zy.rocket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@ApiModel(value="CaseTaskView对象", description="VIEW")
public class CaseTaskView implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "协查ID")
    private String taskId;

    @ApiModelProperty(value = "委托机构ID")
    private String orgId;

    @ApiModelProperty(value = "案件编号")
    private String taskNo;

    @ApiModelProperty(value = "案件ID")
    private String caseId;

    @ApiModelProperty(value = "任务类型(1:初查服务  2:深入研判 3:远程勘验 4:现场勘验  5:司法鉴定)")
    private Integer taskType;

    @ApiModelProperty(value = "委托人ID")
    private String processId;

    @ApiModelProperty(value = "任务添加者id")
    private String userId;

    @ApiModelProperty(value = "任务添加时间")
    private Date taskCreateTime;

    @ApiModelProperty(value = "协查期限")
    private Integer taskDeadline;

    @ApiModelProperty(value = "难度级别")
    private Integer taskDifficulty;

    @ApiModelProperty(value = "失败次数")
    private Integer taskFailedCount;

    @ApiModelProperty(value = "当前处理组")
    private String taskProcessGroup;

    @ApiModelProperty(value = "委托书状态")
    private Integer taskEntrustState;

    @ApiModelProperty(value = "认领时间")
    private Date taskTimeAccept;

    @ApiModelProperty(value = "更新时间")
    private Date taskTimeUpdate;

    @ApiModelProperty(value = "关闭时间")
    private Date taskTimeClose;

    @ApiModelProperty(value = "协查需求")
    private String taskRequirement;

    @ApiModelProperty(value = "任务流程码")
    private Integer taskFlowCode;

    @ApiModelProperty(value = "任务状态")
    private Integer taskState;

    @ApiModelProperty(value = "服务内容(维度)")
    private String serviceContent;

    @ApiModelProperty(value = "未通过原因")
    private String failReason;

    @ApiModelProperty(value = "案件协查标识")
    private String taskProcessState;

    @ApiModelProperty(value = "结果状态")
    private Integer resultState;

    @ApiModelProperty(value = "结论类型.线索失效,数据缺失,暂停处理,结果输出")
    private Integer conclusionType;


}
