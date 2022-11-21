//package principal.controller;
// 
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
// 
//import principal.modelo.Alumno;
//import principal.modelo.Bocadillo;
//import principal.modelo.Ingrediente;
//import principal.modelo.Pedido;
//import principal.persistencia.AlumnoDAO;
//
//
//
//@RequestMapping("/alumnos")
//@Controller
//public class AlumnoController2 {
//
//	
//	//private AlumnoServiceImp aDAO = new AlumnoServiceImp(); 
//	
//	
//	AlumnoDAO aDAO = new AlumnoDAO();
//	
//	
//	
//	@GetMapping(value={"","/"})
//	String alumnos(Model model) {
//
//		List<Alumno> lista = aDAO.listarAlumnosJPA();
//		model.addAttribute("listaAlumnos",lista );
//		model.addAttribute("alumnoNuevo",new Alumno() );
//		model.addAttribute("alumnoaEditar", new Alumno());    
////		model.addAttribute("nombreNuevo", "");    
//		return "alumnos";
//	}
//
////	@GetMapping(value="/add/{nombre}")
////	public String insertarAlumno(Model model, @PathVariable String nombre ) {
////		
////		 
////		///crudAlumno.insertarRegistroHIBERNATE(alumno);
////		//aDAO.insertarAlumno(nombre);	
////		aDAO.insertarAlumnoJPA(nombre);
////		System.out.println("Insertando alumno nuevo: "+nombre);		
////		
////		return "redirect:/alumnos";
////	}
////	
//	
//	@PostMapping("/add")
//	public String addAlumno(@ModelAttribute("nuevoAlumno") Alumno alumno, BindingResult bindingResult) {
//		
//		aDAO.insertarAlumnoJPA(alumno);
//		System.out.println("Insertando alumno nuevo: "+alumno.getNombre());			
//				
//		return "redirect:/alumnos";	
//	}
//	
//	@PostMapping("/edit/{id}")
//	public String editarAlumno(@PathVariable Integer id, @ModelAttribute("alumnoaEditar") Alumno alumno,BindingResult bindingResult) {
//		
//		Alumno alumnoAEditar = aDAO.buscarIDJPA(id);
//		//crudAlumno.eliminarRegistro(alumno);
//		alumnoAEditar.setNombre(alumno.getNombre());
//		aDAO.modificarAlumnoJPA(alumnoAEditar);
//		
//		return "redirect:/alumnos";
//		 
//	}
//	
//	 
//	/*@GetMapping("/edit/{id}")
//	public String editarAlumnoe(@PathVariable Integer id ) {
//		
//		Alumno alumnoAEditar = aDAO.obtenerAlumno(id);
//		//crudAlumno.eliminarRegistro(alumno);
//		aDAO.insertarAlumno(alumnoAEditar);
//		
//		return "redirect:/alumnos";		 
//	} */
//	
//	
////	@GetMapping({"/{id}"})
////	public String obtenerAlumno(Model model, @PathVariable Integer id) {
////	 
////		model.addAttribute("alumno", crudAlumno.buscarPorId(id));
////		
////		return "alumno";
////	}
////	
////	@GetMapping({"/buscar/{nombre}"})
////	public String obtenerAlumno(@PathVariable String nombre) {
////		Alumno Alumno = aDAO.obtenerAlumno(nombre);
////		return "alumno";
////	}
//	
//	@GetMapping({"/delete/{id}"})
//	public String borrarAlumno(@PathVariable Integer id) {
//		
//		//Alumno alumno = crudAlumno.buscarPorId(id);
//		//crudAlumno.eliminarRegistro(alumno);
//		aDAO.eliminarAlumnoJPA(aDAO.buscarIDJPA(id));
//		
//		return "redirect:/alumnos";
//		 
//	}
//	
//
//	
//	
//	
//}
