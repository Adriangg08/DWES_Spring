package principal;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import principal.modelo.Alumno;
import principal.persistencia.AlumnoDAO;
import principal.persistencia.Tablas;

@SpringBootApplication

public class Main {

	public static void main(String[] args) {

//		Tablas t = new Tablas();
//		t.crearTablas();
		
//		AlumnoDAO aDAO = new AlumnoDAO();
//		Alumno a = aDAO.buscarIDJPA(1);
//		System.err.println("**************************************************");
//		a.imprimir();
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Main.class, args);
		
		
	}

}	
