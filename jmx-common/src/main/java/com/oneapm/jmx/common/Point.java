/**
 * Project Name:jmx-common
 * File Name:InnerStruff.java
 * Package Name:com.oneapm.jmx.common
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.common;

import java.beans.ConstructorProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * ClassName:InnerStruff <br/>
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
public class Point {
    
    private Integer x;
    
    private Integer y;
    
    /**
     * Creates a new instance of Point.
     * 
     * @param x
     * @param y
     */
    @ConstructorProperties(value = {"x", "y"})
    public Point(Integer x,
                 Integer y) {
        this.x = x;
        this.y = y;
    }
    
}
