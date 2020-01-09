package cn.cocopup.zy.cmwebsocket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zy
 * @create 2019-11-15 20:14
 */
@Data
//@Configuration
//@ConfigurationProperties(prefix = "cm")
public class ConfigProperties {

    /**长矛websocket地址**/
    private String address;

    /**长矛获取sin的sk **/
    private String sk;

    /**长矛获取sin的ak **/
    private String ak;

}
