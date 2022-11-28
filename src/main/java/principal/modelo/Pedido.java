package principal.modelo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;  
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_alumno", nullable = false)
	@JsonIgnore
	private Alumno alumno;
	
	@ManyToMany(mappedBy = "pedidos", fetch = FetchType.EAGER) //Asociado al atributo Set
	private Set<Bocadillo> bocadillos;
	
	@Column(name="precio")
	private double precio;

	public Pedido(Alumno a) {
		alumno = a;
		bocadillos = new HashSet<Bocadillo>();
	}
	
	public Pedido() {
		bocadillos = new HashSet<Bocadillo>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Set<Bocadillo> getBocadillos() {
		return bocadillos;
	}

	public void setBocadillos(Set<Bocadillo> bocadillos) {
		this.bocadillos = bocadillos;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void imprimir() {
		System.out.println("Pedido id=" + id);
		for(Bocadillo b: bocadillos) {
			b.imprimir();
		}
		
		System.out.println("El precio total es: " + calcularPrecio());
	}

	public String calcularPrecio() {
		
		double resul = 0;
		
		for(Bocadillo b: bocadillos) {
			resul += b.getPrecio();
		}
		
		return String.valueOf(resul);
	}
	
	public void calcularPrecio2() {
		
		for(Bocadillo b: bocadillos) {
			precio += b.getPrecio();
		}
		
	}
	
}
