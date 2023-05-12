package com.smthasa.myfancypdfinvoices;

import java.io.IOException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import com.smthasa.myfancypdfinvoices.web.MyFancyPdfInvoicesServlet;

public class ApplicationLauncher {

    // Used for development and debugging purposes
    public static final boolean IN_ECLIPSE = false;

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "myFirstServlet", new MyFancyPdfInvoicesServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();

        // Used to allow for @PreDestroy to be called from within eclipse on termination
        if (IN_ECLIPSE) {
            System.out.println("You're using Eclipse; click in this console and " +
                    "press ENTER to call System.exit() and run the shutdown routine.");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }

    }
}
