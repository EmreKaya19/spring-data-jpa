package com.example.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IAddressController;
import com.example.dto.DtoAddress;
import com.example.services.IAddressService;

@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAddressController {
	
	@Autowired
	private IAddressService AddressService;

	@GetMapping("/list/{id}")
	@Override
	public DtoAddress findAddressById(@PathVariable(name = "id") Long id) {
		
		return AddressService.findAddressById(id);
	}

}
