package datos;

import java.time.LocalDate;

public class Final extends NotaPedido{
	private LocalDate fechaExamen;
	
	public Final() {}

	public Final(LocalDate fechaExamen, LocalDate fecha, int cantEstudiantes, Materia materia) {
		super(fecha, cantEstudiantes, materia);
		this.fechaExamen = fechaExamen;
	}

	public LocalDate getFechaExamen() {
		return fechaExamen;
	}

	public void setFechaExamen(LocalDate fechaExamen) {
		this.fechaExamen = fechaExamen;
	}

	@Override
	public String toString() {
		return "Final [fechaExamen=" + fechaExamen + ", cantidad de Estudiantes=" + super.getCantEstudiantes() + ", fecha=" + super.getFecha() + ", materia=" +super.getMateria() +" \n]";
	}
	
	
	
}
