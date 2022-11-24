package principal.persistencia;

import principal.modelo.Alumno;
import principal.modelo.Bocadillo;
import principal.modelo.Ingrediente;
import principal.modelo.Pedido;

public class TablasBBDD {

	public void crearTablas() {
//		Alumno a = new Alumno("Adrian");
		AlumnoDAO aDAO = new AlumnoDAO();
//		Alumno a = aDAO.buscarIDJPA(1);
//		aDAO.insertarAlumnoJPA(a);
//		a.setNombre("Paco");
//		aDAO.modificarAlumno(a);
//		aDAO.eliminarAlumno(a);
//		aDAO.imprimirAlumnos(aDAO.listarAlumnos());
//		System.out.println(aDAO.readAlumno(7).toString());

//		aDAO.insertarAlumnoHibernate(a);
//		aDAO.insertarAlumnoHibernate(a);
//		aDAO.imprimirAlumnos(aDAO.listarAlumnosHibernate());
//		aDAO.buscarIDHibernate(3);
		
//		Pedido p = new Pedido(a);
//		PedidoDAO pDAO = new PedidoDAO();
//		Pedido p = pDAO.buscarIDJPA(1);
		
//		p.setAlumno(a);
//		a.getPedidos().add(p);
		
//		p.setAlumno(a);
//		a.getPedidos().add(p);
		
//		Bocadillo b = new Bocadillo("Jamon",3.0);
//		BocadilloDAO bDAO = new BocadilloDAO();
//		Bocadillo b = bDAO.buscarIDJPA(1);
		
//		p.getBocadillos().add(b);
//		b.getPedidos().add(p);
		
//		p.getBocadillos().add(b);
//		b.getPedidos().add(p);
//		
//		Ingrediente i1 = new Ingrediente("Pan",true);
//		Ingrediente i2 = new Ingrediente("Tomate",true);
//		Ingrediente i3 = new Ingrediente("Jamon",false);
//		IngredienteDAO iDAO = new IngredienteDAO();
//		
//		b.getIngredientes().add(i1);
//		b.getIngredientes().add(i2);
//		b.getIngredientes().add(i3);
//		
//		i1.getBocadillos().add(b);
//		i2.getBocadillos().add(b);
//		i3.getBocadillos().add(b);
//		
//		b.getIngredientes().add(i1);
//		b.getIngredientes().add(i2);
//		b.getIngredientes().add(i3);
//		
//		aDAO.insertarAlumnoJPA(a);
//		
//		pDAO.insertarPedidoJPA(p);
//		
//		bDAO.insertarBocadilloJPA(b);
//		
//		iDAO.insertarIngredienteJPA(i1);
//		iDAO.insertarIngredienteJPA(i2);
//		iDAO.insertarIngredienteJPA(i3);
		
		GenericDAO<Alumno> agDAO = new GenericDAO<Alumno>(Alumno.class);
		GenericDAO<Bocadillo> bgDAO = new GenericDAO<Bocadillo>(Bocadillo.class);
		GenericDAO<Pedido> pgDAO = new GenericDAO<Pedido>(Pedido.class);
		GenericDAO<Ingrediente> igDAO = new GenericDAO<Ingrediente>(Ingrediente.class);
		
		Alumno a = new Alumno("Alumno 2");
		Bocadillo b = new Bocadillo("Bocadillo3",2.0);
		Bocadillo b2 = new Bocadillo("Bocadillo4",3.0);
		Pedido p = new Pedido(a);
		Ingrediente i = new Ingrediente("Ingrediente2",true);
		
		
		
		p.setAlumno(a);
		a.getPedidos().add(p);
		
		p.getBocadillos().add(b);
		b.getPedidos().add(p);
		
		p.getBocadillos().add(b2);
		b2.getPedidos().add(p);
		
		i.getBocadillos().add(b);
		b.getIngredientes().add(i);
		
		i.getBocadillos().add(b2);
		b2.getIngredientes().add(i);
		
		p.calcularPrecio2();
		
		agDAO.insertarTJPA(a);
		pgDAO.insertarTJPA(p);
		bgDAO.insertarTJPA(b);
		igDAO.insertarTJPA(i);
	}
}
