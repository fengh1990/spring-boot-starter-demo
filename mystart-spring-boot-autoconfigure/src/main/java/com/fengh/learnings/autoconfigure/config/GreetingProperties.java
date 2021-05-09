package com.fengh.learnings.autoconfigure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "mystart.greeting")
@Data
public class GreetingProperties {

    /**
     * GreetingProperties 开关
     */
    private boolean enable;
    /**
     * 需要打招呼的成员列表
     */
    private List<String> names=new ArrayList<String>();

}
