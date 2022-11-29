package principal.persistencia;

import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;

import principal.modelo.Pedido;
import principal.util.JPAUtil;

public class PedidoDAO {
	
//	@Autowired
//	private PedidoRepo pedidoRepo;

	 public void insertarPedidoJPA(Pedido pedido) {
		 
//		 pedidoRepo.save(pedido);
		 
		 /*
		 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
		 
		 try {
			em.getTransaction().begin();
			em.persist(pedido);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.err.println(e.getMessage());   
		} finally {
			em.close();
		}
		*/
		 
	 }
	 
	 public void modificarPedidoJPA (Pedido pedido) {
		
//		 pedidoRepo.save(pedido);
		 
		 /*
		 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
		 
		 try {
			em.getTransaction().begin();
			em.merge(pedido);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			em.close();
		} 
		*/
	 }

	 public void eliminarPedidoJPA (Pedido pedido) {

		 /*
		 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
		 
		 try {
			Pedido p = em.find(Pedido.class, pedido.getId());
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			em.close();
		} 
		*/
	 }
	 
//	 public ArrayList<Pedido> listarPedidosJPA () {
		
//		 return (ArrayList<Pedido>) pedidoRepo.findAll();
		 
		 /*
		 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
		 
		 try {
			em.getTransaction().begin();
			ArrayList<Pedido> listapedidos = (ArrayList<Pedido>) em.createQuery("from Pedido").getResultList();
			em.getTransaction().commit();
			return listapedidos;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			em.close();
		} 
		 
		 return null;
		 */
//	 }
	 
	 public void imprimirPedidos(ArrayList<Pedido> listapedidos) {
		 
		 for (Pedido a: listapedidos) {
			 a.imprimir();
		 }
	 }
	 
//	 public Optional<Pedido> buscarIDJPA(int id) {
		 
//		 return pedidoRepo.findById(id);
		 
		 /*
	        EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	        try {
	            entity.getTransaction().begin();
	            Pedido pedido = entity.find(Pedido.class, id);
	            entity.getTransaction().commit();
	            System.out.println("El pedido de id " +id);
	            return pedido;
	        } catch (PersistenceException exception) {
	            entity.getTransaction().rollback();
	            System.out.println(exception.getMessage());
	        } finally {
	            entity.close();
	        }
	        return null;   
	        */
//	    }

}
