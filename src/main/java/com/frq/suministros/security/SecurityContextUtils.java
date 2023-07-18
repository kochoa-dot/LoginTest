package com.frq.suministros.security;

import java.net.InetAddress;

//import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;

public class SecurityContextUtils {
	//private static final Logger log = Logger.getLogger(SecurityContextUtils.class);
	  
	  public static UserPrincipal getUserPrincipal() {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserPrincipal up = null;
	    if (auth != null && auth.getPrincipal() != null) {
	      up = (UserPrincipal)auth.getPrincipal();
	    } else {
	      up = new UserPrincipal();
	      up.setUsuarioAd("anonymous");
	    } 
	    return up;
	  }
	  
	  public static String encodeBase64(String str) {
	    String enc = str;
	    for (int i = 1; i <= 3; i++)
	      enc = new String(Base64.encode(enc.getBytes())); 
	    return enc;
	  }
	  
	  public static String decodeBase64(String str) {
	    String enc = str;
	    for (int i = 1; i <= 3; i++)
	      enc = new String(Base64.decode(enc.getBytes())); 
	    return enc;
	  }
	  
	  public static boolean isBase64(String str) {
	    try {
	      Base64.decode(str.getBytes());
	      return true;
	    } catch (IllegalArgumentException e) {
	      return false;
	    } 
	  }
	  
	  public static String environment() {
	    try {
	      String hostname = InetAddress.getLocalHost().getHostName();
	      if (hostname == null) {
	        //log.error("Hostname is null");
	        return "[N/D]";
	      } 
	      if (hostname.toUpperCase().contains("DEV"))
	        return "[DEV]"; 
	      if (hostname.toUpperCase().contains("TST"))
	        return "[TST]"; 
	      if (hostname.toUpperCase().contains("PRD"))
	        return ""; 
	      return "[N/D]";
	    } catch (Exception e) {
	      //log.error("Error al obtener hostname", e);
	      return "[N/D]";
	    } 
	  }
}
