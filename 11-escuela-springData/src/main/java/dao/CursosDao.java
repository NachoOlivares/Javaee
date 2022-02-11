package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
import model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{
	//void save(Curso curso);
	//Curso findById(int idCurso);
	@Query("Curso.findByName")
	Curso findByName(String name);	//Si lo hubieramos llamado findByDenominacion no habria hecho falta poner la query
	//List<Curso> findAll();
	@Query("Curso.findByDates")
	List<Curso> findByDates(Date f1, Date f2);	//findByFechaInicioBetween para que lo hubiera hecho sin query
	
	@Transactional
	@Modifying
	@Query("Curso.updateByDuration")
	void updateByDuration(int percent, int duration);
	
	@Query("Curso.findByDuration")
	List<Curso> findByDurationMax(int duration);
	//List<Curso> findByLessThanDuration(int duration);	//Para ahorrar la query
	
	@Query("Curso.findByAlumno")
	Curso findByAlumno(String dni);
	
	@Query("Curso.findByCurso")
	List<Alumno> findByCurso(String nombre);
}
