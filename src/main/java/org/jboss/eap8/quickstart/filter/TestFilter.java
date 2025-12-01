package org.jboss.eap8.quickstart.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*") // Apply to all URLs
public class TestFilter implements Filter{

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic, if any
		System.out.println("init...");

    }
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 if (response instanceof HttpServletResponse) {
	         HttpServletResponse httpResponse = (HttpServletResponse) response;

             // Define your CSP directives here
             String cspPolicy = "default-src 'self'; script-src 'self' 'unsafe-eval' 'unsafe-hashes' " +
		     		"'sha256-SYHyaozoSdm2c2bJZemJ6x/1BFwoQ4thJgUsDMn4KxY=' " +
		     		"'sha256-UxDklegfZm5njwrpiSR0SI6vKj2DTtvT1F9E2c0vJlo=' " +
		     		"'sha256-5qdkxZJ551hnn3CFjnT7nynl9TKnwnOxkZ5MnYe3LWs=' " +
		     		"'sha256-B/SgrPfzZkepRd0QSPiOTxcVIKoF99NAX5kClfoaN7Q=' " +
		     		"'sha256-1TU/Z8VYIyOATHhlXNZrUU40DUsPlbH5p6+m7Sdh9sg='" +
				"; " +
                                //"script-src 'self'; " + // Adjust as needed
                                "style-src 'self'; ";
                               
             System.out.println("setting csp...");
             httpResponse.setHeader("Content-Security-Policy", cspPolicy);
         }
         chain.doFilter(request, response);
		
	}

}
