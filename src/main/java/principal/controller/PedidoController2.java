//package aplicacion.controlador;
// 
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
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
//import aplicacion.modelo.Alumno;
//import aplicacion.modelo.Bocadillo;
//import aplicacion.modelo.Ingrediente;
//import aplicacion.modelo.Pedido;
//import aplicacion.persistencia.Crud;
//import aplicacion.servicio.implementacion.AlumnoServiceImp;
//import aplicacion.servicio.implementacion.BocadilloServiceImp;
//import aplicacion.servicio.implementacion.IngredienteServiceImp;
//import aplicacion.servicio.implementacion.PedidoServiceImp;
//import aplicacion.servicio.interfaces.AlumnoService;
//
//
//@RequestMapping("/pedidos")
//@Controller
//public class PedidoController {
//
//	@Autowired
//	private AlumnoServiceImp alumnoService;
//	@Autowired
//	private PedidoServiceImp pedidoService;
//	@Autowired
//	private BocadilloServiceImp bocadilloService;
//	
//	//private AlumnoServiceImp alumnoService = new AlumnoServiceImp(); 
//	
//	
//	private Crud<Bocadillo> crudBocadillo = new Crud<>(Bocadillo.class);
//	private Crud<Pedido> crudPedido = new Crud<>(Pedido.class);
//	private Crud<Alumno> crudAlumno = new Crud<>(Alumno.class);
//	private Crud<Ingrediente> crudIngrediente = new Crud<>(Ingrediente.class);
//	
//	
//	
//	@GetMapping(value={"","/"})
//	String alumnos(Model model) {
//
//		//return "<h1>Hola mundo SPRING</h1><p>blablabla</p>";
//				
//				model.addAttribute("alumnos", crudAlumno.listarRegistros("Alumno"));
//				model.addAttribute("listabocadillos", crudBocadillo.listarRegistros("Bocadillo"));
//				model.addAttribute("pedidos", crudPedido.listarRegistros("Pedido"));
//				
//				model.addAttribute("pedidoNuevo", new Pedido());
//				
//				
//				
//				return "pedidos";
//	}
//
// 
//	
//	
//	@PostMapping("/add")
//	public String addAlumno( @ModelAttribute("pedidoNuevo") Pedido pedidoNuevo,   BindingResult bindingResult) {
//		
//		
//		pedidoNuevo.calcularPrecio();
//		
//		//Alumno alumnoNuevo = alumnoService.obtenerAlumno(pedidoNuevo.getAlumno().getNombre());
//	 	Alumno alumnoNuevo = crudAlumno.buscarPorNombre(pedidoNuevo.getAlumno().getNombre());
//				
//  		alumnoNuevo.getPedidos().add(pedidoNuevo);
//		pedidoNuevo.setAlumno(alumnoNuevo);
//		 
//		//Si tenemos CASCADE.ALL utilizando servicios, con el insert del pedido guarda todo lo demás.
//		//pedidoService.insertarPedido(pedidoNuevo);
//		//SINO, como en TablasBBDD
//		crudPedido.insertarRegistroJPA(pedidoNuevo);
//		
//		for(Bocadillo b:pedidoNuevo.getBocadillos()) {
//			b.getPedidos().add(pedidoNuevo); 
//			crudBocadillo.ActualizarRegistro(b);
//		}
//		  
//		return "redirect:/pedidos";	
//	}
//	
//	
//	
//	
//	@GetMapping({"/{id}"})
//	public String obtenerAlumno(Model model, @PathVariable Integer id) {
//	 
//		model.addAttribute("alumno", crudAlumno.buscarPorId(id));
//		
//		return "alumno";
//	}
//	
//	@GetMapping({"/buscar/{nombre}"})
//	public String obtenerAlumno(@PathVariable String nombre) {
//		Alumno Alumno = alumnoService.obtenerAlumno(nombre);
//		return "alumno";
//	}
//	
//	@GetMapping({"/delete/{id}"})
//	public String borrarAlumno(@PathVariable Integer id) {
//		
//		//Alumno alumno = crudAlumno.buscarPorId(id);
//		//crudAlumno.eliminarRegistro(alumno);
//		alumnoService.eliminarAlumno(id);
//		
//		return "redirect:/alumnos";
//		 
//	}
//	
//	
//	
//}
