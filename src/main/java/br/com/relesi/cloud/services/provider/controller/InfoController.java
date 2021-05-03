package br.com.relesi.cloud.services.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.relesi.cloud.services.provider.model.InfoProvider;
import br.com.relesi.cloud.services.provider.services.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {

	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

	@Autowired
	private InfoService infoservice;

	@RequestMapping("/{state}")
	public InfoProvider getInfoToState(@PathVariable String state) {
		LOG.info("received request information from the supplier by {}", state);
		return infoservice.getInfoToState(state);
	}

}
