/**
 * Project Name:jmx-server
 * File Name:JMXServerMain.java
 * Package Name:com.oneapm.jmx.server
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.server;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import com.oneapm.jmx.common.MonitorImpl;
import com.oneapm.jmx.common.Point;

/**
 * ClassName:JMXServerMain <br/>
 * Function: <br/>
 * Date: <br/>
 * 
 * @author hadoop
 * @version
 * @since JDK 1.8
 * @see
 */
public class JMXServerMain {
    
    /**
     * main: <br/>
     * -Dcom.sun.management.jmxremote.port=9999 <br>
     * -Dcom.sun.management.jmxremote.authenticate=false <br>
     * -Dcom.sun.management.jmxremote.ssl=false <br>
     * 
     * @author hadoop
     * @param args
     * @throws InterruptedException
     * @throws NotCompliantMBeanException
     * @throws MBeanRegistrationException
     * @throws InstanceAlreadyExistsException
     * @throws MalformedObjectNameException
     * @since JDK 1.8
     */
    public static void main(String[] args) throws InterruptedException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException {
        //
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        //
        ObjectName name = new ObjectName("com.oneapm.jmx.common",
                                         "type",
                                         "MonitorImpl");
        //
        Point p = new Point(10,
                            100);
        MonitorImpl mxbean = new MonitorImpl("old content",
                                             1,
                                             p);
        //
        server.registerMBean(mxbean,
                             name);
        //
        System.out.println("Waiting...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
