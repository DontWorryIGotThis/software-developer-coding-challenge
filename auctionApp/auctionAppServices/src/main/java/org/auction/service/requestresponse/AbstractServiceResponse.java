package org.auction.service.requestresponse;

public abstract class AbstractServiceResponse {
	ServiceResponseScenario scenario;

	public ServiceResponseScenario getScenario() {
		return scenario;
	}

	public void setScenario(ServiceResponseScenario scenario) {
		this.scenario = scenario;
	}

}
