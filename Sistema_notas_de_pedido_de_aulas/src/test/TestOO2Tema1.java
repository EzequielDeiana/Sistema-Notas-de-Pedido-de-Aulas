package test;

import java.time.LocalDate;

import negocio.MateriaABM;
import negocio.NotaPedidoABM;

public class TestOO2Tema1 {
	public static void main(String[] args) 
    {
		
		System.out.println("\n 1) " + MateriaABM.getInstance().traerMateria(1));
		
		System.out.println("\n 2) " + NotaPedidoABM.getInstance().traerNotaPedidoConMateria(1));
		
		System.out.println("\n 3) " + NotaPedidoABM.getInstance().traer(LocalDate.of(2022, 3, 1)));
		
		System.out.println("\n 4) " + NotaPedidoABM.getInstance().traerFinales(LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 11)));
		
		System.out.println("\n 5) " + NotaPedidoABM.getInstance().traerFinales(LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 11), MateriaABM.getInstance().traerMateria(3)));
		
		System.out.println("\n 6) " + NotaPedidoABM.getInstance().agregar(LocalDate.of(2022, 6, 15), 100, MateriaABM.getInstance().traerMateria(3), "cod 101"));
		
    }
}
