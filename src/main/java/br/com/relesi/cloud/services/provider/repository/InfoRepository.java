package br.com.relesi.cloud.services.provider.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.relesi.cloud.services.provider.model.InfoProvider;

@Repository
public interface InfoRepository extends CrudRepository<InfoProvider, Long> {

	InfoProvider findByState(String state);
}
