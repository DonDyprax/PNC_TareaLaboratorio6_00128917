package com.uca.capas.TareaLaboratorio6.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.TareaLaboratorio6.domain.Importancia;

public interface ImportanciaServices {
	
	public List<Importancia>findAll() throws DataAccessException;

}
