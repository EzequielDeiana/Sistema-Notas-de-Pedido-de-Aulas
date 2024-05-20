package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Curso;
import datos.Materia;
import datos.NotaPedido;

public class NotaPedidoDAO {
	protected static Session session;
	protected Transaction transaction;
	public static NotaPedidoDAO instance;

	public static NotaPedidoDAO getInstance() {
		if (instance == null) {
			instance = new NotaPedidoDAO();
		}
		return instance;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		transaction.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public NotaPedido traerNotaPedidoConMateria(int idNotaPedido) {
		NotaPedido objeto = null;

		try {
			iniciaOperacion();
			objeto = (NotaPedido) session.get(NotaPedido.class, idNotaPedido);
		} catch (Exception e) {
			session.close();
		}

		return objeto;
	}

	public List<NotaPedido> traer(LocalDate fechaExamen) {
		List<NotaPedido> lista = null;

		try {
			iniciaOperacion();
			lista = session.createQuery("from NotaPedido np where np.fecha=:fechaExamen", NotaPedido.class)
					.setParameter("fechaExamen", fechaExamen).list();
			for (NotaPedido notaPedido : lista) {
				Hibernate.initialize(notaPedido.getMateria());
			}
		} finally {
			session.close();
		}

		return lista;
	}

	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta) {
		List<NotaPedido> lista = null;

		try {
			iniciaOperacion();
			lista = session
					.createQuery("from Final f where f.fechaExamen>=:desde and f.fechaExamen<=:hasta", NotaPedido.class)
					.setParameter("desde", desde).setParameter("hasta", hasta).list();
			for (NotaPedido notaPedido : lista) {
				Hibernate.initialize(notaPedido.getMateria());
			}
		} finally {
			session.close();
		}

		return lista;
	}

	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta, Materia materia) {
		List<NotaPedido> lista = null;

		try {
			iniciaOperacion();
			lista = session.createQuery(
					"from Final f where f.fechaExamen>=:desde and f.fechaExamen<=:hasta",
					NotaPedido.class).setParameter("desde", desde).setParameter("hasta", hasta).list();
			for (NotaPedido notaPedido : lista) {
				Hibernate.initialize(notaPedido.getMateria());
			}
		} finally {
			session.close();
		}

		return lista;
	}
	
	public int agregar(LocalDate fecha, int cantEstudiantes, Materia materia, String codCurso) throws HibernateException{
		int id = 0;
		
		try {
			iniciaOperacion();
			id = (int) session.save(new Curso(codCurso,fecha, cantEstudiantes, materia));
			transaction.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

}
