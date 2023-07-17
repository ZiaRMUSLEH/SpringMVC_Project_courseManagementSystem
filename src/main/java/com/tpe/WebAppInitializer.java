package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    //db and hibernate related setting
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootContextConfig.class
        };
    }


    //Spring MVC Config -class with Bean definition
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                WebMvcConfig.class
        };
    }


    //which URL will be for the servlet
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};

    }
}