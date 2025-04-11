package com.example.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IHomeController;
import com.example.dto.DtoHome;
import com.example.services.IHomeService;

@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController {
	
	@Autowired
	private IHomeService homeService;

	@Override
	@GetMapping(path = "/{id}")
	
	public DtoHome findHomeByİd(@PathVariable(name = "id") Long İd) {
		
		return homeService.findHomeByİd(İd);
	}

}
