package negocio;

import dao.MateriaDAO;
import datos.Materia;

public class MateriaABM {
	public static MateriaABM instance;
	
	public static MateriaABM getInstance() {
		if(instance == null) {
			instance = new MateriaABM();
		}
		return instance;
	}
	
	public Materia traerMateria(int idMateria) {
		return MateriaDAO.getInstance().traerMateria(idMateria);
	}
	
}
