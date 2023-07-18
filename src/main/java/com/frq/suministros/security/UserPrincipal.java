package com.frq.suministros.security;

import java.math.BigDecimal;
import java.util.List;


public class UserPrincipal {
	
	private String usuarioAd;
	private String adminCia;
	private BigDecimal adminFranquicias;
	private BigDecimal adminTiendas;
	private BigDecimal adminUsuarios;
	private String descripcion;
	private String email;
	private BigDecimal estado;
	//private List<SiFrqAccesoTienda> siFrqAccesoTiendas;
	
	public UserPrincipal() {
		
	}
	
	public String getUsuarioAd() {
		return usuarioAd;
	}
	public void setUsuarioAd(String usuarioAd) {
		this.usuarioAd = usuarioAd;
	}
	public String getAdminCia() {
		return adminCia;
	}
	public void setAdminCia(String adminCia) {
		this.adminCia = adminCia;
	}
	public BigDecimal getAdminFranquicias() {
		return adminFranquicias;
	}
	public void setAdminFranquicias(BigDecimal adminFranquicias) {
		this.adminFranquicias = adminFranquicias;
	}
	public BigDecimal getAdminTiendas() {
		return adminTiendas;
	}
	public void setAdminTiendas(BigDecimal adminTiendas) {
		this.adminTiendas = adminTiendas;
	}
	public BigDecimal getAdminUsuarios() {
		return adminUsuarios;
	}
	public void setAdminUsuarios(BigDecimal adminUsuarios) {
		this.adminUsuarios = adminUsuarios;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getEstado() {
		return estado;
	}
	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	/*public List<SiFrqAccesoTienda> getSiFrqAccesoTiendas() {
		return siFrqAccesoTiendas;
	}
	public void setSiFrqAccesoTiendas(List<SiFrqAccesoTienda> siFrqAccesoTiendas) {
		this.siFrqAccesoTiendas = siFrqAccesoTiendas;
	}*/
	
	
	
}
