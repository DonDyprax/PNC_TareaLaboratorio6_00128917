package com.uca.capas.TareaLaboratorio6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.TareaLaboratorio6.dao.ImportanciaDAO;
import com.uca.capas.TareaLaboratorio6.domain.Importancia;

@Service
public class ImportanciaServicesImpl implements ImportanciaServices{
	
	@Autowired
	ImportanciaDAO importanciaDao;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return importanciaDao.findAll();
	}



}