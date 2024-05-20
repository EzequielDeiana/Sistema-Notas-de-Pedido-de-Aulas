package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Materia;

public class MateriaDAO {
	protected static Session session;
	protected Transaction transaction;
	public static MateriaDAO instance;
	
	public static MateriaDAO getInstance() {
		if(instance == null) {
			instance = new MateriaDAO();
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

	public Materia traerMateria(int idMateria) {
		Materia objeto = null;
				
		try {
			iniciaOperacion();
			objeto = (Materia) session.get(Materia.class, idMateria);
		} finally {
			session.close();
		}
				
		return objeto;
	}
}
