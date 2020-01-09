package cn.cocopup.zy.rocket.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName : TaskResultState
 * @Author :  WudGaby
 * @Version :  1.0
 * @Date : 2019/10/28 16:38
 * @Desc :   TODO
 */
@Getter
@AllArgsConstructor
public enum TaskResultState {
    /** 任务失败 **/TASK_FAILURE(-1, "任务失败"),
    /** 任务失效 **/TASK_INVALID(-2, "任务失效"),
    /** 未设定 **/UNKNOWN(0, "未设定"),
    /** 任务完成 **/TASK_FINISH(1, "任务完成"),
    ;

    @EnumValue
    private int type;
    private String desc;


}