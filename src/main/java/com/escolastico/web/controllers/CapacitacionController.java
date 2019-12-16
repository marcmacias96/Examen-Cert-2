package com.escolastico.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.escolastico.web.models.entities.Capacitacion;
import com.escolastico.web.models.services.IAvalService;
import com.escolastico.web.models.services.ICapacitacionService;
import com.escolastico.web.models.services.IDocenteService;

@Controller
@RequestMapping(value = "/capacitacion")
public class CapacitacionController {

	@Autowired
	private ICapacitacionService service;

	@GetMapping(value = "/create/{id}")
	public String create(@PathVariable(value = "id") Integer id, Model model) {
		Capacitacion capacitacion = new Capacitacion();
		model.addAttribute("capacitacion", capacitacion);
		model.addAttribute("title", "Nuevo registro");
		return "capacitacion/form";
	}
	
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		Capacitacion capacitacion = service.findById(id);		
		model.addAttribute("capacitacion", capacitacion);
		model.addAttribute("title", "Actualización de registro");
		return "capacitacion/form";
	}

	@GetMapping(value = "/list/{id}")
	public String list(@PathVariable(value = "id") Long id, Model model) {
		return "capacitacion/list";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {		
		try {
			service.delete(id);			
		} catch (Exception ex) {			
		}
		return "capacitacion/list";
	}

	@PostMapping(value = "/save")
	public String save(@RequestBody @Valid Capacitacion capacitacion, BindingResult result, Model model) {
		
				
		try {			
			if(result.hasErrors())
			{
				model.addAttribute("capacitacion", capacitacion);
				if(capacitacion.getIdcapacitacion() == null) {
					model.addAttribute("title","Nuevo registro");					
				}
				else {
					model.addAttribute("title","Actualización de registro");
				}
								
				return "capacitacion/form";
			}
			
			service.save(capacitacion);
						
			return "capacitacion/list";			
			
		} catch (Exception ex) {			
			model.addAttribute("title","Error al guardar el registro");
			return "capacitacion/form";
		}		
	}

}
