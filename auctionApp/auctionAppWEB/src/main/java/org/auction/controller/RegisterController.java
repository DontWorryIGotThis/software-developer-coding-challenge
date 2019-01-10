package org.auction.controller;

import org.auction.controller.model.RegisterUserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@Value("${register.link.forward}")
	private String VIEW_NAME;
	
	@RequestMapping(value="${register.link.uri}", method=RequestMethod.GET)
	public String handleRegisterLinkRequest(Model model) {
		model.addAttribute("registerModel", new RegisterUserModel());
		return VIEW_NAME;
	}
}
