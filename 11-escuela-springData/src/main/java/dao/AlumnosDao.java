package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

//La interfaz tiene que heredar del repositorio
public interface AlumnosDao extends JpaRepository<Alumno, String>{
	//void save(Alumno alumno);	No se tiene que indicar save porque ya lo hereda
	//Alumno findById(String dni);	Tambien lo hereda
	
	@Query(name="Alumno.findByCurso")
	List<Alumno> findByCurso(int idCurso);
	
	@Query(name="Alumno.findFechaCurso")
	List<Alumno> findByFechaCurso(Date fechaInicio);
}
