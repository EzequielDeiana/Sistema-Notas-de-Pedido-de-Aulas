package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.NotaPedidoDAO;
import datos.Final;
import datos.Materia;
import datos.NotaPedido;

public class NotaPedidoABM {
	public static NotaPedidoABM instance;
	
	public static NotaPedidoABM getInstance() {
		if(instance == null) {
			instance = new NotaPedidoABM();
		}
		return instance;
	}
	
	public NotaPedido traerNotaPedidoConMateria(int idNotaPedido) {
		return NotaPedidoDAO.getInstance().traerNotaPedidoConMateria(idNotaPedido);
	}
	
	public List<NotaPedido> traer(LocalDate fechaExamen){
		return NotaPedidoDAO.getInstance().traer(fechaExamen);
	}
	
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta){
		return NotaPedidoDAO.getInstance().traerFinales(desde, hasta);
	}
	
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta, Materia materia){
		List<NotaPedido> lista = NotaPedidoDAO.getInstance().traerFinales(desde, hasta, materia);
		List<NotaPedido> listaFinales = new ArrayList<NotaPedido>();
		
		for (NotaPedido notaPedido : lista) {
			if(notaPedido.getMateria().getIdMateria() == materia.getIdMateria()) {
				listaFinales.add(notaPedido);
			}
		}
		
		return listaFinales;
	}
	
	public int agregar(LocalDate fecha, int cantEstudiantes, Materia materia, String codCurso) {
		return NotaPedidoDAO.getInstance().agregar(fecha, cantEstudiantes, materia, codCurso);
	}
	
}
