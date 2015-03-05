package br.com.cf.webFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SisRemFilter implements Filter{
	
	private ServletContext context;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		
		String url = request.getRequestURI(); ///((HttpServletRequest)req).getRequestURL().toString();
		
		System.out.println("passou pelo filtro: "+url);

		if(url.contains("login") || url.contains("css") || url.contains("images") || url.contains("aj4") || (url.contains("js") && !url.contains("jsp"))){
			chain.doFilter(req, res);
		} else {
			if(session.getAttribute("usuarioLogado") == null){
				response.sendRedirect("login.jsp");
			}else {
				chain.doFilter(req, res);
			}
		}
	}

	public void init(FilterConfig chain) throws ServletException {
		context = chain.getServletContext();
	}

}