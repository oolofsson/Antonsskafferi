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
        if(valid){
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "create";
        }
            else{
            FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_WARN,
		"Incorrect Username and Passowrd",
		"Please enter correct username and Password"));
            return "login";
                    }
        }
    	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
    }
    

