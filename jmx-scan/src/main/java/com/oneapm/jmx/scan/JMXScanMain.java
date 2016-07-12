/**
 * Project Name:jmx-scan
 * File Name:JMXScanMain.java
 * Package Name:com.oneapm.jmx.scan
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.scan;

import java.io.IOException;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * ClassName:JMXScanMain <br/>
 * Function: <br/>
 * Date: <br/>
 * 
 * @author hadoop
 * @version
 * @since JDK 1.8
 * @see
 */
public class JMXScanMain {
    
    /**
     * main: <br/>
     * 
     * @author hadoop
     * @param args
     * @throws MalformedObjectNameException
     * @throws IOException
     * @throws ReflectionException
     * @throws IntrospectionException
     * @throws InstanceNotFoundException
     * @throws MBeanException
     * @throws AttributeNotFoundException
     * @throws InterruptedException
     * @since JDK 1.8
     */
    public static void main(String[] args) throws MalformedObjectNameException, IOException, InstanceNotFoundException, IntrospectionException, ReflectionException, AttributeNotFoundException, MBeanException, InterruptedException {
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
        System.out.println("##############");
        for (String s : conn.getDomains()) {
            System.out.println(s);
        }
        //
        System.out.println("##############");
        for (ObjectName on : conn.queryNames(ObjectName.WILDCARD,
                                             null)) {
            System.out.println(on.getCanonicalName() +
                               "\t\t" +
                               on.getCanonicalKeyPropertyListString() +
                               "\t\t" +
                               on.getDomain() +
                               "\t\t" +
                               on.getKeyPropertyListString() +
                               "\t\t" +
                               on.toString());
        }
        System.out.println("#############");
        //
        ObjectName name = new ObjectName("com.oneapm.jmx.common",
                                         "type",
                                         "MonitorImpl");
        MBeanInfo info = conn.getMBeanInfo(name);
        System.out.println(info.getClassName() +
                           "\t\t" +
                           info.getDescription());
        for (MBeanAttributeInfo attr : info.getAttributes()) {
            System.out.print(attr.getDescription() +
                             "\t\t" +
                             attr.getName() +
                             "\t\t" +
                             attr.getType() +
                             "\t\t");
            Object o = conn.getAttribute(name,
                                         attr.getName());
            if (o instanceof CompositeDataSupport) {
                CompositeDataSupport c = (CompositeDataSupport) o;
                for (Object v : c.values()) {
                    System.out.print(v +
                                     "\t\t");
                }
                System.out.println();
            } else {
                System.out.println(o);
            }
        }
        System.out.println("#############");
        //
        name = new ObjectName("com.oneapm.jmx.common",
                              "type",
                              "Node");
        info = conn.getMBeanInfo(name);
        System.out.println(info.getClassName() +
                           "\t\t" +
                           info.getDescription());
        for (MBeanAttributeInfo attr : info.getAttributes()) {
            System.out.print(attr.getDescription() +
                             "\t\t" +
                             attr.getName() +
                             "\t\t" +
                             attr.getType() +
                             "\t\t");
            Object o = conn.getAttribute(name,
                                         attr.getName());
            if (o instanceof CompositeDataSupport) {
                CompositeDataSupport c = (CompositeDataSupport) o;
                for (Object v : c.values()) {
                    System.out.print(v +
                                     "\t\t");
                }
                System.out.println();
            } else {
                System.out.println(o);
            }
        }
        System.out.println("#############");
        //
        Thread.sleep(3000);
        connector.close();
    }
    
}
