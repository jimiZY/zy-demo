package cn.cocopup.zy.rocket.dto;

import cn.cocopup.zy.rocket.enums.AssignType;
import cn.cocopup.zy.rocket.enums.TaskResultState;
import cn.cocopup.zy.rocket.enums.TaskState;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 得到技术端同比环比数据
 * @author zy
 * @create 2019-10-31 16:47
 */
@Data
@Accessors(chain = true)
public class GetTecRatioDto {

    /**
     * 年月字符串
     */
    private String ym;

    /**
     * 任务结果状态，失败，成功
     */
    private TaskResultState taskResultState;


    /**
     * 分配关联id
     */
    private List<String> relateIds;


    /**
     * 分配类型，user,group
     */
    private AssignType assignType;


    /**
     * 任务状态,总数，完成
     */
    private TaskState taskState;

    /**
     * 提交人
     */
    private String submitter;

    /**
     * 协查中
     */
    private String otherTaskState;


}
