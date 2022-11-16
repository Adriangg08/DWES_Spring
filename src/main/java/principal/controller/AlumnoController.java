package principal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import principal.modelo.Alumno;
import principal.persistencia.AlumnoDAO;

@RequestMapping("/alumnos")
@Controller
public class AlumnoController {

	//@Autowired esto para mas adelante
	AlumnoDAO aDAO = new AlumnoDAO();
	
	@GetMapping(value = {"","/"})
	String homealumnos(Model model) {
		
		//Buscar en la BBDD
		ArrayList<Alumno> listaAlumnos = aDAO.listarAlumnosJPA();
		
		model.addAttribute("listaAlumnos", listaAlumnos);
		
		return "alumnos";
	}
	
	@GetMapping("/{id}")
	String idAlumno() {
		
		return "alumno";
	}
}
