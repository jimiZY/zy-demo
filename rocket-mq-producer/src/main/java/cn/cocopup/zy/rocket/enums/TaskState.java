package cn.cocopup.zy.rocket.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @ClassName : TaskState
 * @Author :  WudGaby
 * @Version :  1.0
 * @Date : 2019/9/29 15:36
 * @Desc :   TODO
 */
@Getter
@AllArgsConstructor
public enum TaskState{
    /**  **/
    CANCEL(-1, 0, "取消", "取消"),

    ACCEPT(0, 1, "受理中", "受理中"),

    ACCEPT_AUDIT(20, 1,"待受理", "受理中"),
    ACCEPT_FAILURE(30, 1,"受理不通过", "受理中"),

    ACCEPT_RE_AUDIT(40, 1, "待复核", "受理中"),
    ACCEPT_RE_AUDIT_FAILURE(50, 1, "复核不通过", "受理中"),

    ASSIGN_GROUP(70, 2,"待分配小组", "协查处理中"),
    ASSIGN_STAFF(80, 2,"待分配人员", "协查处理中"),

    WAIT_OUTPUT_RESULT(90, 2,"待提交结果", "协查处理中"),
    RESULT_AUDIT(100, 3, "待结果审核", "结果输出中"),
    RESULT_RE_AUDIT(110, 3, "待结果复核", "结果输出中"),
    RESULT_AUDIT_FAILURE(120, 3, "结果审核不通过", "结果输出中"),

    /*RESULT_PASS(130, 3, "结果已出", "结果输出中"),
    VIEW_RESULT_AUDIT(140, 3, "查看结果待审核", "结果输出中"),
    VIEW_RESULT(150, 3, "允许查看结果", "结果输出中"),
    FINISH_AUDIT(160, 3, "待结案审核", "结果输出中"),*/

    /**
     * tinyint 127 太小, 使用 smallint
     */
    FINISHED(170, 4, "协查任务完成", "已完成"),
    ;

    @EnumValue
    private int state;
    private int pos;
    private String desc;
    private String outDesc;

}
