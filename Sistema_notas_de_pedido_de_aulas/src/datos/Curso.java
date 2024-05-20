package datos;

import java.time.LocalDate;

public class Curso extends NotaPedido{

	private String codCurso;
	
	public Curso() {}

	public Curso(String codCurso, LocalDate fecha, int cantEstudiantes, Materia materia) {
		super(fecha, cantEstudiantes, materia);
		this.codCurso = codCurso;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	@Override
	public String toString() {
		return "Curso [codCurso=" + codCurso + ", cantidad de Estudiantes=" + super.getCantEstudiantes() + ", fecha=" + super.getFecha() + ", materia=" +super.getMateria() +" \n]";
	}
	
	
	
}
