/**
 * Project Name:jmx-common
 * File Name:MonitorImpl.java
 * Package Name:com.oneapm.jmx.common
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.common;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

import lombok.Getter;
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
@ToString
public class MonitorImpl extends NotificationBroadcasterSupport implements MonitorMXBean {
    
    private String  content;
    
    private Integer num;
    
    private Point   p;
    
    private long    sequenceNumber = 0;
    
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
    
    /**
     * @see com.oneapm.jmx.common.MonitorMXBean#setContent(java.lang.String)
     */
    @Override
    public void setContent(String content) {
        //
        Notification notify = new AttributeChangeNotification(this,
                                                              sequenceNumber++,
                                                              System.currentTimeMillis(),
                                                              "calling setContent, content is changed.",
                                                              "content",
                                                              "java.lang.String",
                                                              this.content,
                                                              content);
        sendNotification(notify);
        //
        this.content = content;
    }
    
    /**
     * @see com.oneapm.jmx.common.MonitorMXBean#setNum(java.lang.Integer)
     */
    @Override
    public void setNum(Integer num) {
        //
        Notification notify = new AttributeChangeNotification(this,
                                                              sequenceNumber++,
                                                              System.currentTimeMillis(),
                                                              "calling setNum, num is changed.",
                                                              "num",
                                                              "java.lang.Integer",
                                                              this.num,
                                                              num);
        sendNotification(notify);
        //
        this.num = num;
    }
    
}
