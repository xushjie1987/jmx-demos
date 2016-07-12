/**
 * Project Name:jmx-common
 * File Name:Node.java
 * Package Name:com.oneapm.jmx.common
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.common;

import lombok.Getter;
import lombok.Setter;

/**
 * ClassName:Node <br/>
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
public class Node implements NodeMXBean {
    
    private OS os;
    
}
