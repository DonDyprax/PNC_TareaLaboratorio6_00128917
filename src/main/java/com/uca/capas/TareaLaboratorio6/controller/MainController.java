package com.uca.capas.TareaLaboratorio6.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.TareaLaboratorio6.domain.Contribuyente;
import com.uca.capas.TareaLaboratorio6.domain.Importancia;
import com.uca.capas.TareaLaboratorio6.service.ContribuyenteServices;
import com.uca.capas.TareaLaboratorio6.service.ImportanciaServices;

@Controller
public class MainController {
	
	@Autowired
	private ContribuyenteServices contribuyenteService;
	
	@Autowired
	private ImportanciaServices importanciaService;
	
	@RequestMapping("/index")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias = null;
		try {
			importancias = importanciaService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("importancias", importancias);
		mav.addObject("contribuyente", new Contribuyente());
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/ingresarContribuyente")
	public ModelAndView insertar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Importancia> importancias = null;
			try {
				importancias = importanciaService.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("importancias", importancias);
			mav.setViewName("index");
		} else {
			try {
				Calendar calendar = Calendar.getInstance();
				String fecha = String.valueOf(calendar.get(Calendar.YEAR)) + "/" + String.valueOf(calendar.get(Calendar.MONTH) + 1) + "/" + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
				Date date = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
				contribuyente.setF_fecha_ingreso(date);
				contribuyenteService.insert(contribuyente);
				mav.setViewName("exito");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return mav;
	}

	@RequestMapping("/mostrarContribuyentes")
	public ModelAndView mostrarContribuyentes() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = contribuyenteService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("contribuyentes");
		return mav;
	}
	
	
}
