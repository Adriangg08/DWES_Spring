package principal.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import principal.modelo.Pedido;
import principal.persistencia.PedidoDAO;

@RequestMapping("/pedidos")
@Controller
public class PedidoController {

	PedidoDAO pDAO = new PedidoDAO();
	
	@GetMapping(value = {"","/"})
	String homepedidos(Model model) {
		
		//Buscar en la BBDD
		ArrayList<Pedido> listaPedidos = pDAO.listarPedidosJPA();
		
		model.addAttribute("listaPedidos", listaPedidos);
		
		return "pedidos";
	}
	
	@GetMapping("/{id}")
	String idPedido() {
		
		return "pedido";
	}
}
