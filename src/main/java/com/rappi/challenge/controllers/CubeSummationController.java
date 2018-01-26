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
	
	@Autowired
	private CubeSummationService cubeSummationService;
	
	@RequestMapping(value = "/cube", method = RequestMethod.GET)
	public String get() {
		return "cube-in";
	}

	@RequestMapping(value = "/cube", method = RequestMethod.POST)
	public String post(@RequestBody MultiValueMap<String,String> formData) {
		for (Entry<String, List<String>> pieceOfData : formData.entrySet()) {
			System.out.println("Key: " + pieceOfData.getKey());
			System.out.println("Values: ");
			for (String item : pieceOfData.getValue()) {
				System.out.println(item);
			}
		}
		return "cube-out";
	}

}
