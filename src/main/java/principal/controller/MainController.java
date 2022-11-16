package principal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	String home() {
		return "index";
	}
	
	@GetMapping("/pedidos")
	String homepedidos() {
		return "pedidos";
	}
	
	@GetMapping("/ingredientes")
	String homeingredientes() {
		return "ingredientes";
	}
	
	@GetMapping("/bocadillos")
	String homebocadillos() {
		return "bocadillos";
	}
	
}
