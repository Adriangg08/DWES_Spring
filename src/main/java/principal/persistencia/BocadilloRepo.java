package principal.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.modelo.Bocadillo;
 
 
public interface BocadilloRepo extends JpaRepository<Bocadillo, Integer> {

//	public Optional<Bocadillo> findByNombre(String nombre);
	
}
