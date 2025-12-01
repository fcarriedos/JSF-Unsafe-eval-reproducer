package org.jboss.eap8.quickstart.bean;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class TestBean {
	
	public void doNothing() throws Exception {
		System.out.println("doing nothing");
		//Thread.sleep(2000);
	}

}
