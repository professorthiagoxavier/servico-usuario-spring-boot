package com.example.servicocliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.servicocliente.model.Cliente;
import com.example.servicocliente.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/teste")
	public String teste() {

		return "Olá, galera da FIAP!";
	}

	@GetMapping()
	public List<Cliente> get() {
		return this.clienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable String id) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);

		if (!cliente.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
	}

	@GetMapping("/getByRequestParam")
	public String getByRequestParam(@RequestParam String descricao, @RequestParam String idade) {
		return "Parametro recebido: ".concat(descricao).concat(" - idade " + idade);
	}

	@PostMapping()
	public ResponseEntity<Cliente> post(@RequestBody Cliente cliente) {

		Cliente clienteCriado = this.clienteRepository.save(cliente);

		return new ResponseEntity<Cliente>(clienteCriado, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> put(@PathVariable String id, @RequestBody Cliente cliente) {

		Optional<Cliente> clienteUpdated = this.clienteRepository.findById(id);

		if (!clienteUpdated.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		clienteUpdated.get().setNome(cliente.getNome());

		this.clienteRepository.save(clienteUpdated.get());

		return new ResponseEntity<>(clienteUpdated.get(), HttpStatus.OK);
	}

}
