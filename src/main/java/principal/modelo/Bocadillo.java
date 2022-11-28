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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="bocadillos")
public class Bocadillo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private double precio = 0;
	
	@Column(name="vegano")
	private boolean vegano;
	
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "pedidos_bocadillos", 
			joinColumns = {@JoinColumn(name = "id_bocadillo")}, 
			inverseJoinColumns = {@JoinColumn(name = "id_pedido")}
		)
	@JsonIgnore
	private Set<Pedido> pedidos;
	
	@ManyToMany(mappedBy = "bocadillos",cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<Ingrediente> ingredientes;
	
	public Bocadillo () {
		pedidos = new HashSet<Pedido>();
		ingredientes = new HashSet<Ingrediente>();
	}

	
	public Bocadillo(String nombre,Double p) {
		this.nombre = nombre;
		precio = p;
		pedidos = new HashSet<Pedido>();
		ingredientes = new HashSet<Ingrediente>();
	}

	public Bocadillo(String n, boolean v, double p) {
		nombre = n;
		pedidos = new HashSet<Pedido>();
		ingredientes = new HashSet<Ingrediente>();
		precio = p;
		vegano = v;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void imprimir() {
		System.out.println("Bocadillo id=" + id + ", nombre=" + getNombre() + ", precio=" + precio);
		for (Ingrediente i: ingredientes) {
			i.imprimir();
		}
	}
	
	
}
