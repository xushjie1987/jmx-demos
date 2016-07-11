/**
 * Project Name:jmx-client
 * File Name:NotificationHandler.java
 * Package Name:com.oneapm.jmx.client
 * Date: 
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.oneapm.jmx.client;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * ClassName:NotificationHandler <br/>
 * Function: <br/>
 * Date: <br/>
 * 
 * @author hadoop
 * @version
 * @since JDK 1.8
 * @see
 */
public class NotificationHandler implements NotificationListener {
    
    /**
     * @see javax.management.NotificationListener#handleNotification(javax.management.Notification,
     *      java.lang.Object)
     */
    @Override
    public void handleNotification(Notification notification,
                                   Object handback) {
        //
        System.out.println("notificated in >>>>>>>>>>>");
        //
        System.out.println(notification.getClass()
                                       .getName());
        System.out.println(notification.getSource());
        System.out.println(notification.getType());
        System.out.println(notification.getMessage());
        System.out.println(notification.getSequenceNumber());
        System.out.println(notification.getUserData());
        System.out.println(notification.getTimeStamp());
        //
        if (notification instanceof AttributeChangeNotification) {
            AttributeChangeNotification attr = (AttributeChangeNotification) notification;
            System.out.println(attr.getAttributeName());
            System.out.println(attr.getAttributeType());
            System.out.println(attr.getOldValue());
            System.out.println(attr.getNewValue());
        }
        //
        System.out.println("notificated out <<<<<<<<<");
    }
    
}
