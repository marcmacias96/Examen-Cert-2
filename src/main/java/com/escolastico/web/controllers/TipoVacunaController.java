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

import com.escolastico.web.models.entities.TipoVacuna;
import com.escolastico.web.models.services.ITipoVacunaService;

@Controller
@RequestMapping(value="/tipovacuna")
public class TipoVacunaController {

	@Autowired
	private ITipoVacunaService service;
			
	@GetMapping(value="/create")
	public String create(Model model) {
		TipoVacuna tipovacuna = new TipoVacuna();
		model.addAttribute("title", "Nuevo registro");
		model.addAttribute("tipovacuna", tipovacuna);
		return "tipovacuna/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		TipoVacuna tipovacuna = service.findById(id);		
		model.addAttribute("tipovacuna", tipovacuna);
		return "tipovacuna/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		TipoVacuna tipovacuna = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ tipovacuna.getNombre());
		model.addAttribute("tipovacuna", tipovacuna);
		return "tipovacuna/form";		
	} 
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, 
			RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
		}	
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
		}
		return "redirect:/tipovacuna/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid TipoVacuna tipovacuna, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				if(tipovacuna.getIdtipovacuna() == null) {
					model.addAttribute("title","Nuevo registro");					
				}
				else {
					model.addAttribute("title","Actualización de registro");
				}				
				return"tipovacuna/form";
			}			
			service.save(tipovacuna);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<TipoVacuna> lista = service.findAll();
		model.addAttribute("title", "Listado de tipo de vacunas");
		model.addAttribute("lista", lista);
		return "tipovacuna/list";		
	}
		
	
	
}
