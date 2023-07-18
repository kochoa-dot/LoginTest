package com.frq.suministros.backing;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

import com.frq.suministros.security.SecurityContextUtils;
import com.frq.suministros.security.UserPrincipal;

@javax.faces.bean.ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

	//Logger log = Logger.getLogger(LoginBean.class);


	private String envName;
	
	private boolean isFranquicia;
	
	@PostConstruct
	public void beforeLoad() {
		this.envName = SecurityContextUtils.environment();
	}

	public void login() {
		try {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest) context.getRequest();
			HttpServletResponse response = (HttpServletResponse) context.getResponse();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward((ServletRequest) request, (ServletResponse) response);
		} catch (Exception e) {
			//this.log.error(e);
			e.printStackTrace();
			mensaje(e.getMessage());
		}
	}
	
	public void mensaje(String respuesta) {
		FacesMessage mensaje = new FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}


	public String getEnvName() {
		return this.envName;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	
	public boolean isAdminFranquicia()
	{
			return true;

	}
	
	public boolean isAdminIngresos() {
			return true;

	}
	
	public boolean isAdminSalidas() {
			return true;

	}
	
	public boolean isAdminInventario() {
			return true;

	}
	
	public boolean isAdminUsuarios() {
			return true;

	}
	
	public boolean isUsuarioActivo()
	{
			return true;

	}
	
	

}
