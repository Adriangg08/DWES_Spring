package principal.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import principal.modelo.Alumno;
import principal.modelo.Bocadillo;
import principal.modelo.Pedido;
import principal.persistencia.AlumnoDAO;
import principal.persistencia.AlumnoRepo;
import principal.persistencia.BocadilloDAO;
import principal.persistencia.BocadilloRepo;
import principal.persistencia.PedidoDAO;
import principal.persistencia.PedidoRepo;


@RequestMapping("/pedidos")
@Controller
public class PedidoController {

PedidoDAO pDAO = new PedidoDAO();
AlumnoDAO aDAO = new AlumnoDAO();
BocadilloDAO bDAO = new BocadilloDAO();

@Autowired
private PedidoRepo pedidoRepo;

@Autowired
private AlumnoRepo alumnoRepo;

@Autowired
private BocadilloRepo bocadilloRepo;
	
	@GetMapping(value = {"","/"})
	String homepedidos(Model model) {
		
		//Buscar en la BBDD
		ArrayList<Pedido> listaPedidos = (ArrayList<Pedido>) pedidoRepo.findAll();
		ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) alumnoRepo.findAll();
		ArrayList<Bocadillo> listaBocadillos = (ArrayList<Bocadillo>) bocadilloRepo.findAll();
		
		
		
		model.addAttribute("listaPedidos", listaPedidos);
		model.addAttribute("pedidoNuevo",new Pedido());
		model.addAttribute("listaAlumnos",listaAlumnos);
		model.addAttribute("listaBocadillos",listaBocadillos);
		
		return "pedidos";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePedido(@PathVariable Integer id, Model model) {
		
//		Pedido pedidoEliminar = pDAO.buscarIDJPA(id);
//		pDAO.eliminarPedidoJPA(pedidoEliminar);
		
		pedidoRepo.deleteById(id);
		
		return "redirect:/pedidos";
	}
	
	@PostMapping("/add/")
	public String addPedido(@ModelAttribute("pedidoNuevo") Pedido pedidoNew, BindingResult bindingResult) {
		
		pedidoNew.calcularPrecio2();
		
		Alumno alumnoPedido = alumnoRepo.findById(pedidoNew.getAlumno().getId()).get();
		
		pedidoNew.setAlumno(alumnoPedido);
		alumnoPedido.getPedidos().add(pedidoNew);
		
		for(Bocadillo b: pedidoNew.getBocadillos()) {
			b.getPedidos().add(pedidoNew);  
//			pedidoNew.getBocadillos().add(b);
		}
		
		pedidoRepo.save(pedidoNew);
		
		return "redirect:/pedidos";
	}
	
	@GetMapping("/{id}")
	public String idPedido(Model model, @PathVariable Integer id) {
		
		Pedido pedidoMostrar = pedidoRepo.findById(id).get();
		model.addAttribute("pedidoMostrar",pedidoMostrar);
//		model.addAttribute("pedidoMostrar",pedidoMostrar);
//		model.addAttribute("pedidoEdit",new Pedido());
		model.addAttribute("listaAlumnos",(ArrayList<Alumno>) alumnoRepo.findAll());
		model.addAttribute("listaBocadillos",(ArrayList<Bocadillo>) bocadilloRepo.findAll());
		
		return "pedido";
	}
	
	@PostMapping("/edit/{id}")
	public String editPedido(@PathVariable Integer id,@ModelAttribute("pedidoMostrar") Pedido pedidoMostrar){
		
		Alumno a = alumnoRepo.findById(pedidoMostrar.getAlumno().getId()).get();
		pedidoMostrar.setAlumno(a);
		
		Pedido paEditar = pedidoRepo.findById(id).get();
		
		for(Bocadillo b: paEditar.getBocadillos()) {
			
			if (!pedidoMostrar.getBocadillos().contains(b)) {
				b.getPedidos().remove(paEditar);
			}
			
		}
		
		for(Bocadillo b: pedidoMostrar.getBocadillos()) {
			
			if (!paEditar.getBocadillos().contains(b)) {
				b.getPedidos().add(paEditar);
			}
			
		}
		
		pedidoMostrar.calcularPrecio2();
		
		pedidoRepo.save(pedidoMostrar);
		
		return "redirect:/pedidos";
	}
}
