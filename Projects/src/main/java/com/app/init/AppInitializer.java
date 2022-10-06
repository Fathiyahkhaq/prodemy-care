package com.app.init;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	@Nullable
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {
				AppContext.class,
				SecurityConfig.class
		};
	}

	@Override
	@Nullable
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
				WebMVCConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {
				"/"
		};
	}
}
