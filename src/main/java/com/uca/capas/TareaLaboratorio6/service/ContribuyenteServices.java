package com.uca.capas.TareaLaboratorio6.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.TareaLaboratorio6.domain.Contribuyente;

public interface ContribuyenteServices {
	
	public List<Contribuyente> findAll() throws DataAccessException;
	
	public void insert(Contribuyente contribuyente) throws DataAccessException;
	
}
