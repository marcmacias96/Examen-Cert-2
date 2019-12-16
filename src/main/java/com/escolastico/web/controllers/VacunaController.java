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

import com.escolastico.web.models.entities.Vacuna;
import com.escolastico.web.models.services.IVacunaService;
import com.escolastico.web.models.services.IEstudianteService;
import com.escolastico.web.models.services.ITipoVacunaService;

@Controller
@RequestMapping(value = "/vacuna")
public class VacunaController {

	@Autowired
	private IVacunaService service;

	@GetMapping(value = "/create/{id}")
	public String create(@PathVariable(value = "id") Integer id, Model model) {
		Vacuna vacuna = new Vacuna();
		model.addAttribute("vacuna", vacuna);
		model.addAttribute("title", "Nuevo registro");
		return "vacuna/form";
	}
	
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		Vacuna vacuna = service.findById(id);		
		model.addAttribute("vacuna", vacuna);
		model.addAttribute("title", "Actualización de registro");
		return "vacuna/form";
	}

	@GetMapping(value = "/list/{id}")
	public String list(@PathVariable(value = "id") Long id, Model model) {
		return "vacuna/list";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {		
		try {
			service.delete(id);			
		} catch (Exception ex) {			
		}
		return "vacuna/list";
	}

	@PostMapping(value = "/save")
	public String save(@RequestBody @Valid Vacuna vacuna, BindingResult result, Model model) {
		
				
		try {			
			if(result.hasErrors())
			{
				model.addAttribute("vacuna", vacuna);
				if(vacuna.getIdvacuna() == null) {
					model.addAttribute("title","Nuevo registro");					
				}
				else {
					model.addAttribute("title","Actualización de registro");
				}
								
				return "vacuna/form";
			}
			
			service.save(vacuna);
						
			//List<Vacuna> vacunas = service.findByEstudiante();
			//model.addAttribute("vacunas", vacunas);			
			return "vacuna/list";			
			
		} catch (Exception ex) {			
			model.addAttribute("title","Error al guardar el registro");
			return "vacuna/form";
		}		
	}

}
