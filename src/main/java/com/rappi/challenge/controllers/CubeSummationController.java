package com.rappi.challenge.controllers;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rappi.challenge.services.CubeSummationService;

@Controller
public class CubeSummationController {
	
	private static final String INPUT_KEY = "intake";
	
	@Autowired
	private CubeSummationService cubeSummationService;
	
	@RequestMapping(value = "/cube", method = RequestMethod.GET)
	public String get() {
		return "cube-in";
	}

	@RequestMapping(value = "/cube", method = RequestMethod.POST)
	public String post(@RequestBody MultiValueMap<String,String> formData, Model model) {
		List<String> inputValue = formData.get(INPUT_KEY);

		String rawInput = inputValue.get(0);
		model.addAttribute("input", rawInput);
		
		String output = cubeSummationService.solveInput(rawInput);
		model.addAttribute("output", output);
		
		return "cube-out";
	}

}
