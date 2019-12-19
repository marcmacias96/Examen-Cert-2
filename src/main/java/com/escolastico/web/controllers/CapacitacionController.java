package com.escolastico.web.controllers;

import javax.validation.Valid;

import com.escolastico.web.models.dao.IAval;
import com.escolastico.web.models.entities.Aval;
import com.escolastico.web.models.entities.Docente;
import com.escolastico.web.models.services.IAvalService;
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
import com.escolastico.web.models.services.ICapacitacionService;
import com.escolastico.web.models.services.IDocenteService;

import java.util.List;

@Controller
@RequestMapping(value = "/capacitacion")
public class CapacitacionController {

	@Autowired
	private ICapacitacionService srvCap;

	@Autowired
	private IDocenteService srvDoc;

	@Autowired
	private IAvalService srvAva;

	@GetMapping(value = "/create/{id}")
	public String create(@PathVariable(value = "id") Long id, Model model) {
		Capacitacion capacitacion = new Capacitacion();
		capacitacion.setDocenteId(id);
		List<Aval> avalList = srvAva.findAll();
		model.addAttribute("avalList", avalList);
		model.addAttribute("capacitacion", capacitacion);
		model.addAttribute("title", "Nuevo registro");
		return "capacitacion/form";
	}
	
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		Capacitacion capacitacion = srvCap.findById(id);
		model.addAttribute("capacitacion", capacitacion);
		model.addAttribute("title", "Actualización de registro");
		return "capacitacion/form";
	}

	@GetMapping(value = "/list/{id}")
	public String list(@PathVariable(value = "id") Long id, Model model) {
		List<Capacitacion> capacitacionList = srvCap.findByDocente(id);
		model.addAttribute("capacitacionList",capacitacionList);
		return "capacitacion/list";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {		
		try {
			srvCap.delete(id);
		} catch (Exception ex) {			
		}
		return "capacitacion/list";
	}

	@PostMapping(value = "/save")
	public String save( @Valid Capacitacion capacitacion, BindingResult result, Model model) {
		
				
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
			System.out.println(capacitacion.getDocenteId());
			Docente docente = srvDoc.findById(capacitacion.getDocenteId());
			capacitacion.setDocente(docente);

			srvCap.save(capacitacion);
						
			return "capacitacion/list";			
			
		} catch (Exception ex) {			
			model.addAttribute("title","Error al guardar el registro");

			return "capacitacion/form";
		}		
	}

}
