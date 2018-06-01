package chenaurj.DnDToolsBack.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("chenaurj.DnDToolsBack.config");
		container.addListener(new ContextLoaderListener(context));
		container.addFilter("cors", "chenaurj.DnDToolsBack.util.CorsFilter").addMappingForUrlPatterns(null, false, "/*");
		
		
		ServletRegistration.Dynamic dispatcher = container.addServlet("dndServlet", new DispatcherServlet(context));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
