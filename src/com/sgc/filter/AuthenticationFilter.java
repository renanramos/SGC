package com.sgc.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationFilter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		boolean ok = false;
		String uri = request.getRequestURI().replace("/SGC", "");

		// Resources
		// CSS
		if (uri.startsWith("/css/") && uri.endsWith(".css")) {
			ok = true;
		}
		
		if (uri.startsWith("/css-custom/") && uri.endsWith(".css")) {
			ok = true;
		}
		
		if (uri.startsWith("/css/images/") && uri.endsWith(".png")) {
			ok = true;
		}
		// JS
		if (uri.startsWith("/js/") && uri.endsWith(".js")) {
			ok = true;
		}

		// IMG e FONT
		if (uri.startsWith("/images/") && uri.endsWith(".jpg")) {
			ok = true;
		}
		if (uri.startsWith("/images/") && uri.endsWith(".png")) {
			ok = true;
		}
		if (uri.startsWith("/fonts/") && uri.endsWith(".svg")) {
			ok = true;
		}
		if (uri.startsWith("/fonts/") && uri.endsWith(".ttf")) {
			ok = true;
		}
		if (uri.startsWith("/fonts/") && uri.endsWith(".woff")) {
			ok = true;
		}
		if (uri.startsWith("/fonts/") && uri.endsWith(".eot")) {
			ok = true;
		}
			
		// URI Livres de Autentica��o
		if (!ok) {
			if (uri.startsWith("/home/login")) {
				ok = true;
			}
			if (uri.startsWith("/usuario/logout")) {
				ok = true;
			}

		}
		if (request.getSession().getAttribute("usuarioSessao") != null) {
			ok = true;
		}
		
		//Finalizando
		if (!ok) {
            response.sendRedirect("/login");
        }
		
		return ok;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
