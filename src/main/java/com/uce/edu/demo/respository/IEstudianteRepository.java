package com.uce.edu.demo.respository;

import java.util.List;

import com.uce.edu.demo.modelo.Estudiante;


public interface IEstudianteRepository {
	
	public void insertarEstudiante(Estudiante estuddiante);
	public List<Estudiante> buscarTodos();
	public Estudiante buscarEstudianteporCedula(String cedula) ;

}
