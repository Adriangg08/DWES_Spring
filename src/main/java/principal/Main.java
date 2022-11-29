package principal;

import java.util.ArrayList;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import principal.modelo.Alumno;
import principal.modelo.Pedido;
import principal.persistencia.AlumnoDAO;
import principal.persistencia.PedidoDAO;
import principal.persistencia.Tablas;

@SpringBootApplication

public class Main {

	public static void main(String[] args) {

//		Tablas t = new Tablas();
//		t.crearTablas();
//		
//		PedidoDAO p = new PedidoDAO();
//		ArrayList<Pedido> pL = p.listarPedidosJPA();
//		
//		for (Pedido pe: pL) {
//			pe.imprimir();
//		}
		
//		AlumnoDAO aDAO = new AlumnoDAO();
//		Alumno a = aDAO.buscarIDJPA(1);
//		System.err.println("**************************************************");
//		a.imprimir();
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Main.class, args);
		
		
	}

}	
