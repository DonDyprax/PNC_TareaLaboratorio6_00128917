package com.uca.capas.TareaLaboratorio6.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.TareaLaboratorio6.domain.Importancia;

public interface ImportanciaDAO {
	
	public List<Importancia> findAll() throws DataAccessException;
	
}
