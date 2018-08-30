package com.csomet.backend.apirest.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.csomet.backend.apirest.model.entity.Client;
import com.csomet.backend.apirest.model.services.IClientService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost", "http://csomet.ddns.net"})
public class ClientRestController  {
	
	@Autowired
	private IClientService clientService;
	
	
	@GetMapping("/clients")
	public List<Client> index(){
		return clientService.findAll();
		
	}
	
	@GetMapping("/clients/{id}")
	public Client read(@PathVariable Long id) {
		return clientService.findById(id);
		
	}
	
	@PostMapping("/clients")
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		this.clientService.save(client);
		return client;
	}
	
	
	@PutMapping("/clients/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		
		Client clientDB = clientService.findById(id);
		
		clientDB.setName(client.getName());
		clientDB.setSurname(client.getSurname());
		clientDB.setEmail(client.getEmail());
		//save: does update or save 
		return clientService.save(clientDB);
		
	}
	
	
	@DeleteMapping("/clients/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientService.delete(id);
	}
	
	
	
	

}
