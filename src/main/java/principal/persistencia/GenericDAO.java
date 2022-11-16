package principal.persistencia;

	import java.util.ArrayList;

	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceException;

	import org.hibernate.Session;
	import org.hibernate.Transaction;

	import principal.util.HibernateUtil;
	import principal.util.JPAUtil;

	public class GenericDAO<T> {

		private Class<T> tipo;

		public GenericDAO (Class<T> mitipo) {
			tipo = mitipo;
		}
		
		 public void insertarTJPA(T cosa) {
			 
			 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
			 
			 try {
				em.getTransaction().begin();
				em.persist(cosa);
				em.getTransaction().commit();
			} catch (PersistenceException e) {
				em.getTransaction().rollback();
				System.err.println(e.getMessage());
			} finally {
				em.close();
			}
			 
		 }
		 
		 public void insertarTHibernate(T cosa) {
			 
			 Transaction tr = null;
			 Session session = null;
			 
			 try {
				session = HibernateUtil.getSessionFactory().openSession();
				tr = session.beginTransaction();
				session.persist(cosa);
				tr.commit();
			} catch (PersistenceException e) {
				tr.rollback();
				System.err.println(e.getMessage());
			} finally {
				session.close();
			}
			 
		 }
		 
		 public void modificarTHibernate (T cosa) {
			 
			 Transaction tr = null;
			 Session session = null;
			 
			 try {
					session = HibernateUtil.getSessionFactory().openSession();
					tr = session.beginTransaction();
					session.merge(cosa);
					tr.commit();
				} catch (PersistenceException e) {
					tr.rollback();
					System.err.println(e.getMessage());
				} finally {
					session.close();
				}
		 }
		 
		 public void modificarTJPA (T cosa) {
			
			 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
			 
			 try {
				em.getTransaction().begin();
				em.merge(cosa);
				em.getTransaction().commit();
			} catch (PersistenceException e) {
				em.getTransaction().rollback();
				System.err.println(e.getMessage());
			} finally {
				em.close();
			} 
		 }

//		 public void eliminarTJPA (T cosa) {
//
//			 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
//			 
//			 try {
//				T a;
//				Class[] cArg = new Class[1];
//		        cArg[0] = tipo;
//				a = em.find(tipo, cosa.getClass().getMethod("getId", cArg));
//				em.getTransaction().begin();
//				em.remove(a);
//				em.getTransaction().commit();
//				
//			} catch (PersistenceException e) {
//				em.getTransaction().rollback();
//				System.err.println(e.getMessage());
//			}  catch (NoSuchMethodException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SecurityException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				em.close();
//			} 
//		 }
		 
		 public void eliminarTHibernate (T cosa) {
			 
			 Transaction tr = null;
			 Session session = null;
			 
			 try {
					session = HibernateUtil.getSessionFactory().openSession();
					tr = session.beginTransaction();
					session.delete(cosa);
					tr.commit();
				} catch (PersistenceException e) {
					tr.rollback();
					System.err.println(e.getMessage());
				} finally {
					session.close();
				}
		 }
		 
		 public ArrayList<T> listarTsJPA () {
			
			 EntityManager em =  JPAUtil.getEntityManagerFactory().createEntityManager();
			 
			 try {
				em.getTransaction().begin();
				ArrayList<T> listaTs = (ArrayList<T>) em.createQuery("from "+tipo.getName()).getResultList();
				em.getTransaction().commit();
				return listaTs;
			} catch (PersistenceException e) {
				em.getTransaction().rollback();
				System.err.println(e.getMessage());
			} finally {
				em.close();
			} 
			 
			 return null;
		 }
		 
//		 public ArrayList<T> listarTsHibernate (String clase) {
//				
//			 Transaction tr = null;
//			 Session session = null;
//			 
//			 try {
//					session = HibernateUtil.getSessionFactory().openSession();
//					tr = session.beginTransaction();
//					ArrayList<T> listaTs = (ArrayList<T>) session.createQuery("from "+T.getClass()).getResultList();
//					tr.commit();
//					return listaTs;
//				} catch (PersistenceException e) {
//					tr.rollback();
//					System.err.println(e.getMessage());
//				} finally {
//					session.close();
//				}
//			 return null;
//		 }
		 
		 public void imprimirTs(ArrayList<T> listaTs) {
			 
			 for (T a: listaTs) {
				 System.out.println(a.toString());
			 }
		 }
		 
		 public T buscarIDJPA(int id) {
		        EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		        try {
		            entity.getTransaction().begin();
		            T cosa = (T) entity.find(tipo, id);
		            entity.getTransaction().commit();
		            System.out.println("El cosa del id " +id+ " es " +cosa);
		            return cosa;
		        } catch (PersistenceException exception) {
		            entity.getTransaction().rollback();
		            System.out.println(exception.getMessage());
		        } finally {
		            entity.close();
		        }
		        return null;    
		    }
		 
		 public T buscarIDHibernate(int id) {
			 Transaction tr = null;
			 Session session = null;
			 T resultado = null;
			 
			 try {
					session = HibernateUtil.getSessionFactory().openSession();
					tr = session.beginTransaction();
					resultado = session.find(tipo, id);
					tr.commit();
					System.out.println("Id " +id+ " es " +resultado.toString());
					return resultado;
				} catch (PersistenceException e) {
					tr.rollback();
					System.err.println(e.getMessage());
				} finally {
					session.close();
				}
			 return resultado;
		    }
	}


