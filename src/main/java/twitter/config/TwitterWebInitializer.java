package twitter.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Alternative to web.xml - needs Servlet 3.0+
// creates DispatcherServlet (using getServletCC (WebConfig) for creating Spring app ctx)
// and ContextLoaderListener (using getRootCC -> 2nd app ctx )
public class TwitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}