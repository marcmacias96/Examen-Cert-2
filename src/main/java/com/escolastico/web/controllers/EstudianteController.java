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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.escolastico.web.models.entities.Estudiante;
import com.escolastico.web.models.services.IEstudianteService;

@Controller
@RequestMapping(value="/estudiante")
public class EstudianteController {

	@Autowired
	private IEstudianteService service;
			
	@GetMapping(value="/create")
	public String create(Model model) {
		Estudiante estudiante = new Estudiante();
		model.addAttribute("title", "Nuevo registro");
		model.addAttribute("estudiante", estudiante);
		return "estudiante/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Long id, Model model) {
		Estudiante estudiante = service.findById(id);		
		model.addAttribute("estudiante", estudiante);
		return "estudiante/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Long id, Model model) {
		Estudiante estudiante = service.findById(id);
		model.addAttribute("title", "Actualización de registro");
		model.addAttribute("estudiante", estudiante);
		return "estudiante/form";		
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
		return "redirect:/estudiante/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Estudiante estudiante, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				if(estudiante.getIdpersona() == null) {
					model.addAttribute("title","Nuevo registro");					
				}
				else {
					model.addAttribute("title","Actualización de registro");
				}				
				return"estudiante/form";
			}			
			service.save(estudiante);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Estudiante> lista = service.findAll();
		model.addAttribute("title", "Listado de estudiantes");
		model.addAttribute("lista", lista);
		return "estudiante/list";		
	}
		
	
	
}
