package com.csomet.backend.apirest.model.services;

import java.util.List;

import com.csomet.backend.apirest.model.entity.Client;

public interface IClientService {

	public List<Client> findAll();
	public Client save(Client client);
	public void delete(Long id);
	public Client findById(Long id);
	
}
