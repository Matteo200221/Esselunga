package esselunga.rest.config;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import esselunga.rest.ProdottoRest;
import esselunga.rest.UtenteRest;


@ApplicationPath("/rest")
public class ControllerRestApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(UtenteRest.class);
		set.add(ProdottoRest.class);
		
		return set;
	}


}
