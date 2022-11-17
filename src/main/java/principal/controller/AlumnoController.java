package principal.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import principal.modelo.Alumno;
import principal.persistencia.AlumnoDAO;

@RequestMapping("/alumnos")
@Controller
public class AlumnoController {

	AlumnoDAO aDAO = new AlumnoDAO();
	
	@GetMapping(value = {"","/"})
	String homealumnos(Model model) {
		
		//Buscar en la BBDD
		ArrayList<Alumno> listaAlumnos = aDAO.listarAlumnosJPA();
		
		model.addAttribute("listaAlumnos", listaAlumnos);
		model.addAttribute("alumnoaEditar",new Alumno());
		
		return "alumnos";
	}
	
	@PostMapping("/edit/{id}")
	public String editarAlumno(@PathVariable Integer id, @ModelAttribute("alumnoaEditar") Alumno alumnoaEditar, BindingResult bindingResult) {
//		System.out.println(id);
//		alumnoaEditar.imprimir();
//		int idFormulario = id;
//		aDAO.buscarIDJPA(id).imprimir();
		
		Alumno alumnoEditado = aDAO.buscarIDJPA(id);
		alumnoEditado.setNombre(alumnoaEditar.getNombre());
		aDAO.modificarAlumnoJPA(alumnoaEditar);
		
//		aDAO.imprimirAlumnos(aDAO.listarAlumnosJPA());
		//Para recargar la pagina
		return "redirect:/alumnos";
	}
	
	@GetMapping("/{id}")
	String idAlumno() {
		
		return "alumno";
	}
}
