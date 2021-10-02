package com.api.city.controller;

import java.util.Collection;

import com.api.city.entity.Municipio;
import com.api.city.service.MunicipioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipios")
public class MunicipioRecurso {

	@Autowired
	private MunicipioServico municipioServico;

	/**
	 * Retorna os todos os municípios.
	 **/
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Municipio>> listarTodos(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.ok().body(municipioServico.buscarTodos(nome));
	}
	
	/**
	 * Retorna os municípios por id passada como parâmetro.
	 **/
	@GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Municipio> listarPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(municipioServico.buscarPorId(id));
	}
}
