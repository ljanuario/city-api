package com.api.city.service;

import java.util.Collection;

import com.api.city.dao.IMunicipioRepositorio;
import com.api.city.entity.Municipio;
import com.api.city.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioServico {

	@Autowired
	private IMunicipioRepositorio municipioDao;

	public boolean naoExistePorId(Long id) {
		return !municipioDao.existsById(id);
	}

	public void salvar(Municipio municipio) {
		municipioDao.save(municipio);
	}

	public Municipio buscarPorId(Long id) {
		return municipioDao.findById(id).get();
	}

	public Collection<Municipio> buscarPorUf(Long uf, String nome) {
		return municipioDao.buscarMunicipiosPorUf(uf, StringUtil.removerAcentosUpperCase(nome));
	}

	public Collection<Municipio> buscarTodos(String nome) {
		return municipioDao.buscaMunicipios(StringUtil.removerAcentosUpperCase(nome));
	}
}
