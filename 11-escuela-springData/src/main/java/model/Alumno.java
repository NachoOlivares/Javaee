package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
@NamedQuery(name="Alumno.findByCurso", query="select c from Curso c where c.denominacion=?1")
@NamedQuery(name="Curso.findByDates", query="select c from Curso c where c.fechaInicio>=?1 and c.fechaInicio<=?2")
@NamedQuery(name="Curso.updateByDuration", query="update Curso c set c.precio=c.precio*((100-?1)/100) where c.duracion>?2")
@NamedQuery(name="Curso.findByDuration", query="Select c from Curso c where c.duracion<?1")
@NamedQuery(name="Curso.findByAlumno", query="select c from Curso c join c.alumnos a where a.dni=?1")
@NamedQuery(name="Curso.findByCurso", query="SELECT c FROM Alumno c WHERE c.curso.denominacion=?1")
public class Alumno {
	@Id
	private String dni;
	private String nombre;
	private int edad;
	private String email;
	@ManyToOne
	@JoinColumn(name="idCurso",referencedColumnName = "idCurso")
	private Curso curso;
	public Alumno(String dni, String nombre, int edad, String email, Curso curso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.curso = curso;
	}
	public Alumno() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
