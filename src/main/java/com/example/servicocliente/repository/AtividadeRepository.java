package com.example.servicocliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.servicocliente.model.Atividade;

public interface AtividadeRepository extends MongoRepository<Atividade, String> {

}
