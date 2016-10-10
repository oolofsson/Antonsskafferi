package se.miun.dt142g.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author William
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {
	}

    @Override
	public void init(FilterConfig filterConfig) throws 
                ServletException {
        
        }
    @Override
	public void doFilter(ServletRequest request, ServletResponse response,
	FilterChain chain) throws IOException, ServletException {
            		try {

			HttpServletRequest reqt = (HttpServletRequest) request; // skapar en HttpRequest
			HttpServletResponse resp = (HttpServletResponse) response; // skapar en HttpResponse
			HttpSession ses = reqt.getSession(false); // hämtar session om den finns. (false) betyder att det inte skapas en ny session om det inte finns någon.

			String reqURI = reqt.getRequestURI(); // gör en string av URL:en som skrivits in
                        
                        // skickar dig till startsidan om du skriver in /show.xhtml
                        if(reqURI.indexOf("/show.xhtml") >= 0){ // om indexof = -1 har man inte skrivit in "show.xhtml". så denna körs om man skrivit in "/show.xhtml"
                            resp.sendRedirect(reqt.getContextPath());
                        }
                        // gör så att servitriser inte kan komma åt adminsdan "create.xhtml". eftersom deras användarnamn är mindre än 3 tecken.
                        else if(reqURI.indexOf("/create.xhtml")>= 0 && ses.getAttribute("username").toString().length() < 3) {
                            resp.sendRedirect(reqt.getContextPath() + "/javacalendar.jsp"); // skickar dig tillbaka till kalendern. kommer inte åt create.
                        }
                        // gör så man kan logga, in, kolla efter session. om det finns kan man komma åt create.
                        else if (reqURI.indexOf("/login.xhtml") >= 0
					|| (ses != null && ses.getAttribute("username") != null)
                               )
                        {               
				chain.doFilter(request, response);  // skickar dig till din requestade url
                        }
                        // så att man kan komma åt framsidan utan redirect ( som gör att du omdirigeras för många ggr. )
                        else if(reqURI.indexOf("/Antonsskafferi") >= 0){
                            chain.doFilter(request, response);
                        }
                        // om ingen if-sats är sann skickas du till startsida.
                        else
                            resp.sendRedirect(reqt.getContextPath());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
        }
