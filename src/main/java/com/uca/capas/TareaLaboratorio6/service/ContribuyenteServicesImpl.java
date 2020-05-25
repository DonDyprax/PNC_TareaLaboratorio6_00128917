package com.uca.capas.TareaLaboratorio6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.TareaLaboratorio6.dao.ContribuyenteDAO;
import com.uca.capas.TareaLaboratorio6.domain.Contribuyente;

@Service
public class ContribuyenteServicesImpl implements ContribuyenteServices {

	@Autowired
	private ContribuyenteDAO contribuyenteDAO;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}

	@Override
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		contribuyenteDAO.insert(contribuyente);
	}

}