package se.miun.dt142g.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author William
 */
public class SessionUtils {
    public static HttpSession getSession() { // klass som sköter hämtande av session från "current instance", där man är
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() { // klass som sköter hämtande av en request från nuvarande instans
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static String getUserName() { // klass som sköter hämtande av användarnamn via session. funkar ej om ingen session finns. pga (false) som gör att ingen session skapas om ingen finns.
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("username").toString();
	}

	public static String getUserId() { // sköter hämtande av användarID
		HttpSession session = getSession();
		if (session != null) // kör endast om session finns!
			return (String) session.getAttribute("userid");
		else
			return null;
	}
}
