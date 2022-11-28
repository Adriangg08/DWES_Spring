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
import principal.modelo.Bocadillo;
import principal.modelo.Pedido;
import principal.persistencia.AlumnoDAO;
import principal.persistencia.BocadilloDAO;
import principal.persistencia.PedidoDAO;


@RequestMapping("/pedidos")
@Controller
public class PedidoController {

PedidoDAO pDAO = new PedidoDAO();
AlumnoDAO aDAO = new AlumnoDAO();
BocadilloDAO bDAO = new BocadilloDAO();
	
	@GetMapping(value = {"","/"})
	String homepedidos(Model model) {
		
		//Buscar en la BBDD
		ArrayList<Pedido> listaPedidos = pDAO.listarPedidosJPA();
		ArrayList<Alumno> listaAlumnos = aDAO.listarAlumnosJPA();
		ArrayList<Bocadillo> listaBocadillos = bDAO.listarBocadillosJPA();
		
		model.addAttribute("listaPedidos", listaPedidos);
		model.addAttribute("pedidoaEditar",new Pedido());
		model.addAttribute("pedidoNuevo",new Pedido());
		model.addAttribute("listaAlumnos",listaAlumnos);
		model.addAttribute("listaBocadillos",listaBocadillos);
		
		return "pedidos";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePedido(@PathVariable Integer id, Model model) {
		
		Pedido pedidoEliminar = pDAO.buscarIDJPA(id);
		pDAO.eliminarPedidoJPA(pedidoEliminar);
		return "redirect:/pedidos";
	}
	
	@PostMapping("/add/")
	public String addPedido(@ModelAttribute("pedidoNuevo") Pedido pedidoNew, BindingResult bindingResult) {
		
		pedidoNew.calcularPrecio2();
		
		Alumno alumnoPedido = aDAO.buscarIDJPA(pedidoNew.getAlumno().getId());
		
		pedidoNew.setAlumno(alumnoPedido);
		alumnoPedido.getPedidos().add(pedidoNew);
		
		for(Bocadillo b: pedidoNew.getBocadillos()) {
			b.getPedidos().add(pedidoNew);
			pedidoNew.getBocadillos().add(b);
		}
		
		pDAO.insertarPedidoJPA(pedidoNew);
		
		return "redirect:/pedidos";
	}
	
	@GetMapping("/{id}")
	String idPedido(Model model, @PathVariable Integer id) {
		
		Pedido pedidoMostrar = pDAO.buscarIDJPA(id);
		model.addAttribute("pedidoMostrar",pedidoMostrar);
		
		return "pedido";
	}
}
