package com.smthasa.myfancypdfinvoices;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smthasa.myfancypdfinvoices.module.ApplicationModule;
import com.smthasa.myfancypdfinvoices.web.MyFancyPdfInvoicesServlet;

public class ApplicationLauncher {

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Injector injector = Guice.createInjector(new ApplicationModule());
        MyFancyPdfInvoicesServlet servlet = injector.getInstance(MyFancyPdfInvoicesServlet.class);

        Context ctx = tomcat.addContext("", null);
        Wrapper wrappedServlet = Tomcat.addServlet(ctx, "myFirstServlet", servlet);
        wrappedServlet.setLoadOnStartup(1);
        wrappedServlet.addMapping("/*");

        tomcat.start();
    }
}