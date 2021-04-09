package br.com.relesi.cloud.services.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.relesi.cloud.services.provider.model.InfoProvider;
import br.com.relesi.cloud.services.provider.services.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	private InfoService infoservice;
	
	@RequestMapping("/{state}")
	public InfoProvider getInfoToState(@PathVariable String state) {
		return infoservice.getInfoToState(state);
	}

}
