/**
 * Project Name:jmx-common
 * File Name:NodeMXBean.java
 * Package Name:com.oneapm.jmx.common
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.common;

import javax.management.MXBean;

/**
 * ClassName:NodeMXBean <br/>
 * Function: <br/>
 * Date: <br/>
 * 
 * @author hadoop
 * @version
 * @since JDK 1.8
 * @see
 */
@MXBean
public interface NodeMXBean {
    
    public OS getOs();
    
}
