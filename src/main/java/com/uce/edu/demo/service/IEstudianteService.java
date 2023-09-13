package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.modelo.Estudiante;
import com.uce.edu.demo.modelo.to.EsrtudianteTo;

public interface IEstudianteService {
	public EsrtudianteTo insertarEstudiante(EsrtudianteTo estuddiante);
	public List<EsrtudianteTo> buscarTodos();
	public EsrtudianteTo buscarEstudianteporCedula(String cedula) ;

}
