package org.auction.service.requestresponse;

import java.util.HashMap;

/**
 * This enumeration is an attempt to address the scalability needs of error reporting
 * in case the applications starts to support API or webservice calls and incorporate white-listed
 * application/service exceptions
 * 
 * @author Kirankumar
 *
 */
public enum ServiceResponseScenario {
	ERROR("Error"),
	WARN("Warning"),
	SUCCESS("Success");
	
	private String result;
	private static HashMap<String, ServiceResponseScenario> lookup = new HashMap<String, ServiceResponseScenario>();
	
	private ServiceResponseScenario(String result) {
		this.result=result;
	}
	
	static {
		populateLookup();
	}
	private static void populateLookup() {
		for(ServiceResponseScenario s : ServiceResponseScenario.values()) {
			lookup.put(s.result, s);
		}
	}

}
