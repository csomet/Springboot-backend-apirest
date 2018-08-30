package com.csomet.backend.apirest.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.csomet.backend.apirest.model.entity.Client;

public interface IClientDao extends CrudRepository<Client, Long> {

}
