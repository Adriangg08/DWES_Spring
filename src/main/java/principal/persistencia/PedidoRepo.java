package principal.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.modelo.Bocadillo;
import principal.modelo.Pedido;
 
 
public interface PedidoRepo extends JpaRepository<Pedido, Integer> {

//	public Optional<Pedido> findByNombre(String nombre);
	
}