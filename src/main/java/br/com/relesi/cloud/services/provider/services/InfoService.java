package br.com.relesi.cloud.services.provider.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relesi.cloud.services.provider.model.InfoProvider;
import br.com.relesi.cloud.services.provider.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;

	public InfoProvider getInfoToState(String state) {

		return infoRepository.findByState(state);

	}

}
