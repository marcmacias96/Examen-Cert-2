package com.escolastico.web.controllers;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.escolastico.web.models.entities.Docente;
import com.escolastico.web.models.services.IDocenteService;

@Controller
@RequestMapping(value="/docente")
public class DocenteController {

	@Autowired
	private IDocenteService service;
			
	@GetMapping(value="/create")
	public String create(Model model) {
		Docente docente = new Docente();
		model.addAttribute("title", "Nuevo registro");
		model.addAttribute("docente", docente);
		return "docente/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Long id, Model model) {
		Docente docente = service.findById(id);
		model.addAttribute("docente", docente);
		return "docente/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Long id, Model model) {
		Docente docente = service.findById(id);
		model.addAttribute("title", "Actualización de registro");
		model.addAttribute("docente", docente);
		return "docente/form";		
	} 
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Long id, Model model, 
			RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
		}	
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
		}
		return "redirect:/docente/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Docente docente, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				if(docente.getIdpersona() == null) {
					model.addAttribute("title","Nuevo registro");					
				}
				else {
					model.addAttribute("title","Actualización de registro");
				}				
				return"docente/form";
			}			
			service.save(docente);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
			return "redirect:/docente/retrieve/" + docente.getIdpersona() ;
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/docene/form";
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Docente> lista = service.findAll();
		model.addAttribute("title", "Listado de docentes");
		model.addAttribute("lista", lista);

		return "docente/list";		
	}
		
	public int Age (Calendar date) {

		return 1;

	}
	
}
