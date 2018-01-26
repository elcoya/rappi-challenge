package com.rappi.challenge.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CubeSummationController {

	@RequestMapping(value = "/cube", method = RequestMethod.GET)
	public String greeting() {
		return "cube-in";
	}

}
