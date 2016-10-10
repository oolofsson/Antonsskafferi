/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.dt142g.beans;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import se.miun.dt142g.loginData.LoginData;
import se.miun.dt142g.loginData.LoginWaiter;
import se.miun.dt142g.util.SessionUtils;

/**
 *
 * @author William
 */
@ManagedBean
@SessionScoped
public class loginBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
    private String pwd;
    private String msg;
    private String user;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
    public String validateUsernamePassword() {
        boolean valid = LoginData.validate(user, pwd);
        boolean validWaiter = LoginWaiter.validate(user, pwd);
        if(valid){
            HttpSession session = SessionUtils.getSession(); // skapar HttpSession m.h.a klassen SessionUtils som sköter sessioner
            session.setAttribute("username", user); // sätter sessionens inskriva username som ett attribut för sessionen (binds till användarnamn)
            return "create"; // till create.xhtml
        }else if(validWaiter){ // Inloggningsverifiering för servitriser
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "javacalendar.jsp";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_WARN,
            "Incorrect Username and Passowrd",
            "Please enter correct username and Password")); // berättar att du skrivit in fel användarnamn / lösen
            return "login";
        }
    }
    	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate(); // invaliderar sessionen vid knapptryck log out.
		return "login";
	}
    }
    

