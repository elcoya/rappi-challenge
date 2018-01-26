package com.rappi.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rappi.challenge.services.CubeSummationService;

@Controller
public class CubeSummationController {
	
	@Autowired
	private CubeSummationService cubeSummationService;
	
	@RequestMapping(value = "/cube", method = RequestMethod.GET)
	public String get() {
		return "cube-in";
	}

	@RequestMapping(value = "/cube", method = RequestMethod.POST)
	public String post() {
		System.out.println("Hola!!!");
		return "cube-out";
	}

}
