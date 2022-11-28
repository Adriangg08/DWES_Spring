package principal.persistencia;

import principal.modelo.Alumno;
import principal.modelo.Bocadillo;
import principal.modelo.Ingrediente;
import principal.modelo.Pedido;

public class Tablas {
	
	public void crearTablas() {

		
		//EJEMPLO: Insertar un Alumno con un pedido de 2 bocadillos, cada uno con 2 ingredientes.		
		
        //Creamos bocadillo choripan con dos ingredientes
        Ingrediente in1 = new Ingrediente("Lomo",false);
        Ingrediente in2 = new Ingrediente("Queso",true);
        Bocadillo bocata1 = new Bocadillo("Bocadillo de Lomoqueso",false, 6.75);
        bocata1.getIngredientes().add(in1);
        bocata1.getIngredientes().add(in2);
        in1.getBocadillos().add(bocata1);
        in2.getBocadillos().add(bocata1);
        
        //Creamos bocadillo lomocompi con dos ingredientes
        Ingrediente in3 = new Ingrediente("pimiento",false);
        Ingrediente in4 = new Ingrediente("aceitunas rellenas",true);
        Bocadillo bocata2 = new Bocadillo("Bocadillo de Pimientos",true,5.85);
        bocata2.getIngredientes().add(in3);
        bocata2.getIngredientes().add(in4);
        in3.getBocadillos().add(bocata2);
        in4.getBocadillos().add(bocata2);
        
        //Creamos pedido y añadimos los dos bocadillos
        Pedido pedido = new Pedido();
        pedido.getBocadillos().add(bocata1);
        pedido.getBocadillos().add(bocata2);
        bocata1.getPedidos().add(pedido);
        bocata2.getPedidos().add(pedido);
        pedido.calcularPrecio();
        
        //Creamos alumno y asociamos al pedido anterior
        Alumno alumno = new Alumno("Paquita");
        alumno.getPedidos().add(pedido);
        pedido.setAlumno(alumno);
        
        
        //Volcamos los objetos en la BBDD       
        GenericDAO<Alumno> crudAlumno = new GenericDAO<>(Alumno.class);
        GenericDAO <Bocadillo> crudBocadillo = new GenericDAO<>(Bocadillo.class);
        GenericDAO <Ingrediente> crudingrediente = new GenericDAO<>(Ingrediente.class);
        GenericDAO <Pedido> crudPedido = new GenericDAO<>(Pedido.class);
        
        pedido.calcularPrecio2();
        
        crudAlumno.insertarTJPA(alumno);
        crudPedido.insertarTJPA(pedido);
        crudBocadillo.insertarTJPA(bocata1);
        crudBocadillo.insertarTJPA(bocata2);
        crudingrediente.insertarTJPA(in1);
        crudingrediente.insertarTJPA(in2);
        crudingrediente.insertarTJPA(in3);
        crudingrediente.insertarTJPA(in4); 
        
	}

}
