/**
 * Project Name:jmx-common
 * File Name:MonitorMXBean.java
 * Package Name:com.oneapm.jmx.common
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.common;

import javax.management.MXBean;

/**
 * ClassName:MonitorMXBean <br/>
 * Function: <br/>
 * Date: <br/>
 * 
 * @author hadoop
 * @version
 * @since JDK 1.8
 * @see
 */
@MXBean
public interface MonitorMXBean {
    
    public String getContent();
    
    public void setContent(String content);
    
    public Integer getNum();
    
    public void setNum(Integer num);
    
    public Point getP();
    
    public String pullStats();
    
}
