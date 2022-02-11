package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQuery(name="Curso.finByName", query="select c from Curso c where c.denominacion=?1")
@Entity
@Table(name="cursos")
public class Curso {
	@Id			//strategy añade reglas para el manejo de la BD. GenerationType limita la variable a la que precede(que estara en una tabla)
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//IDENTITY Indica que el valor generado para esta variable debe ser unico
	private int idCurso;
	private String denominacion;
	private int duracion;
	private double precio;
	@Temporal(TemporalType.DATE)	
	private Date fechaInicio;
	@OneToMany(mappedBy = "curso")
	private List<Alumno> alumnos;
	public Curso(int idCurso, String denominacion, int duracion, double precio, Date fechaInicio) {
		super();
		this.idCurso = idCurso;
		this.denominacion = denominacion;
		this.duracion = duracion;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
	}
	public Curso() {
		super();
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
}
