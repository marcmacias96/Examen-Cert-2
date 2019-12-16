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

import com.escolastico.web.models.entities.Destreza;
import com.escolastico.web.models.services.IDestrezaService;
import com.escolastico.web.models.services.IEstudianteService;
import com.escolastico.web.models.services.ITipoDestrezaService;

@Controller
@RequestMapping(value = "/destreza")
public class DestrezaController {

	@Autowired
	private IDestrezaService service;

	@GetMapping(value = "/create/{id}")
	public String create(@PathVariable(value = "id") Integer id, Model model) {
		Destreza destreza = new Destreza();
		model.addAttribute("destreza", destreza);
		model.addAttribute("title", "Nuevo registro");
		return "destreza/form";
	}
	
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		Destreza destreza = service.findById(id);		
		model.addAttribute("destreza", destreza);
		model.addAttribute("title", "Actualización de registro");
		return "destreza/form";
	}

	@GetMapping(value = "/list/{id}")
	public String list(@PathVariable(value = "id") Long id, Model model) {
		return "destreza/list";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {		
		try {
			service.delete(id);			
		} catch (Exception ex) {			
		}
		return "destreza/list";
	}

	@PostMapping(value = "/save")
	public String save(@RequestBody @Valid Destreza destreza, BindingResult result, Model model) {
		
				
		try {			
			if(result.hasErrors())
			{
				model.addAttribute("destreza", destreza);
				if(destreza.getIddestreza() == null) {
					model.addAttribute("title","Nuevo registro");					
				}
				else {
					model.addAttribute("title","Actualización de registro");
				}
								
				return "destreza/form";
			}
			
			service.save(destreza);
						
			//List<Destreza> destrezas = service.findByEstudiante();
			//model.addAttribute("destrezas", destrezas);			
			return "destreza/list";			
			
		} catch (Exception ex) {			
			model.addAttribute("title","Error al guardar el registro");
			return "destreza/form";
		}		
	}

}
