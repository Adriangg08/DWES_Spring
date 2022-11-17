package principal;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import principal.modelo.Alumno;
import principal.persistencia.AlumnoDAO;
import principal.persistencia.TablasBBDD;

@SpringBootApplication

public class Main {

	public static void main(String[] args) {

//		TablasBBDD t = new TablasBBDD();
//		t.crearTablas();
		
//		AlumnoDAO aDAO = new AlumnoDAO();
//		Alumno a = aDAO.buscarIDJPA(1);
//		System.err.println("**************************************************");
//		a.imprimir();
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Main.class, args);
		
		
	}

}	
