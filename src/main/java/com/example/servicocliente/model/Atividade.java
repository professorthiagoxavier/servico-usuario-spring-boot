package com.example.servicocliente.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
@Document
public class Atividade {

	@Id
	private String id;
	
	private Integer rm; 
	private String nome;
	private String urlGitHub;
	private int numeroAtividade;
}