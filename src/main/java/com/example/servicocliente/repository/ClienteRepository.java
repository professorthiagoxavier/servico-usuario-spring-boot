package com.example.servicocliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.servicocliente.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
