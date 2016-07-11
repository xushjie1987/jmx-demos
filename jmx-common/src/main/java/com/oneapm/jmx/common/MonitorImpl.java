/**
 * Project Name:jmx-common
 * File Name:MonitorImpl.java
 * Package Name:com.oneapm.jmx.common
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName:MonitorImpl <br/>
 * Function: <br/>
 * Date: <br/>
 * 
 * @author hadoop
 * @version
 * @since JDK 1.8
 * @see
 */
@Getter
@Setter
@ToString
public class MonitorImpl implements MonitorMXBean {
    
    private String  content;
    
    private Integer num;
    
    private Point   p;
    
    /**
     * Creates a new instance of MonitorImpl.
     * 
     * @param content
     * @param num
     * @param p
     */
    public MonitorImpl(String content,
                       Integer num,
                       Point p) {
        this.content = content;
        this.num = num;
        this.p = p;
    }
    
    /**
     * @see com.oneapm.jmx.common.MonitorMXBean#pullStats()
     */
    @Override
    public String pullStats() {
        return toString();
    }
    
}
