package com.gideon.bims_oxy.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController{
	
	/**
	 * intro page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/")
	public String login(Model model) {
		return "login";
	}
	
	/**
	 * intro page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/home.jsp")
	public String test(Model model) {
		return "login";
	}	
}
