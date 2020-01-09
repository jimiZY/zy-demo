package cn.cocopup.zy.cmwebsocket.cm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zy
 * @create 2019-10-17 14:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ack extends Message {

    private int ret = 0;

}
