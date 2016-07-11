/**
 * Project Name:jmx-client
 * File Name:JMXClientMain.java
 * Package Name:com.oneapm.jmx.client
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.client;

import java.io.IOException;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.oneapm.jmx.common.MonitorMXBean;

/**
 * ClassName:JMXClientMain <br/>
 * Function: <br/>
 * Date: <br/>
 * 
 * @author hadoop
 * @version
 * @since JDK 1.8
 * @see
 */
public class JMXClientMain {
    
    /**
     * main: <br/>
     * 
     * @author hadoop
     * @param args
     * @throws IOException
     * @throws MalformedObjectNameException
     * @since JDK 1.8
     */
    public static void main(String[] args) throws IOException, MalformedObjectNameException {
        // service: jmx
        // protocol: rmi
        // host: localhost
        // port: JVM random
        // url: /jndi/rmi://localhost:9999/jmxrmi
        // RMI registry port: 9999
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi://localhost/jndi/rmi://localhost:9999/jmxrmi");
        //
        JMXConnector connector = JMXConnectorFactory.connect(url);
        //
        MBeanServerConnection conn = connector.getMBeanServerConnection();
        //
        ObjectName name = new ObjectName("com.oneapm.jmx.common",
                                         "type",
                                         "MonitorImpl");
        //
        MonitorMXBean proxy = JMX.newMXBeanProxy(conn,
                                                 name,
                                                 MonitorMXBean.class);
        //
        System.out.println(proxy.getContent());
        System.out.println(proxy.getNum());
        System.out.println(proxy.getP());
        System.out.println(proxy.pullStats());
        // modify data
        proxy.setContent("new content");
        proxy.setNum(2);
        System.out.println(proxy.pullStats());
        //
        connector.close();
    }
    
}
