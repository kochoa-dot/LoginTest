package com.frq.suministros.security;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

//import org.hibernate.mapping.Map;
//import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToBytesTransformer;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.frq.suministros.backing.LoginBean;

public class AuthenticationProviderConsitiLDAP implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth) {
		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
			Authentication authRet = null;
			String usuario = auth.getPrincipal().toString().trim();
			String password = auth.getCredentials().toString().trim();
			if (usuario.isEmpty() && password.isEmpty()) {
				throw new BadCredentialsException("Usuario o password incorrectos (" + usuario);
			} else {

			}
			boolean successfullAuth = false;
			successfullAuth = true;
			if (successfullAuth) {
				System.out.println("se logueo");
				List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				UserPrincipal userPrincipal = new UserPrincipal();
				userPrincipal.setUsuarioAd(usuario);
				if (usuario == null)
					throw new BadCredentialsException("Usuario o password incorrectos (" + usuario + ")");
				else {

					FacesContext facesContext = FacesContext.getCurrentInstance();
					Application application = facesContext.getApplication();
					LoginBean loginBean = application.evaluateExpressionGet(facesContext, "#{loginBean}",
							LoginBean.class);
						roles.add(new SimpleGrantedAuthority("ROLE_USER"));
							roles.add(new SimpleGrantedAuthority("ROLE_USER_ADMIN_MTO"));
							roles.add(new SimpleGrantedAuthority("ROLE_USER_ADMIN_INV"));
							roles.add(new SimpleGrantedAuthority("ROLE_USER_ADMIN_OUT"));
							roles.add(new SimpleGrantedAuthority("ROLE_USER_ADMIN_IN"));
						for (GrantedAuthority grantedAuthority : roles) {
							System.out.println(grantedAuthority.toString());
						}
						usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal,
								password, roles);
						System.out.println(usernamePasswordAuthenticationToken.toString());
					}
				}
			return (Authentication) usernamePasswordAuthenticationToken;
		} catch (Exception e) {
			e.printStackTrace();
			mensaje(e.getMessage());
			return null;
		}
	}

	public void mensaje(String respuesta) {
		FacesMessage mensaje = new FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}


}
