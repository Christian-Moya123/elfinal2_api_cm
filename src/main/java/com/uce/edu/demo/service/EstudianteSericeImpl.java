package com.uce.edu.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Estudiante;
import com.uce.edu.demo.modelo.to.EsrtudianteTo;
import com.uce.edu.demo.respository.IEstudianteRepository;

@Service
public class EstudianteSericeImpl implements IEstudianteService{
	
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public EsrtudianteTo insertarEstudiante(EsrtudianteTo estuddiante) {
		this.estudianteRepository.insertarEstudiante(this.convertirN(estuddiante));
		Estudiante e =this.estudianteRepository.buscarEstudianteporCedula(estuddiante.getCedula());
		return  this.convertir(e);
	}
	

	@Override
	public List<EsrtudianteTo> buscarTodos() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteRepository.buscarTodos();
		List<EsrtudianteTo> listaTO = lista.stream().map(estudiante -> this.convertir(estudiante)).collect(Collectors.toList());

		return listaTO;
	}

	@Override
	public EsrtudianteTo buscarEstudianteporCedula(String cedula) {
		// TODO Auto-generated method stub
		
		return this.convertir(this.estudianteRepository.buscarEstudianteporCedula(cedula));
		
	}
	
	private EsrtudianteTo convertir(Estudiante estudiante) {
		EsrtudianteTo estudianteTo = new EsrtudianteTo();
		estudianteTo.setApellido(estudiante.getApellido());
		estudianteTo.setCedula(estudiante.getCedula());
		estudianteTo.setId(estudiante.getId());
		estudianteTo.setNombre(estudiante.getNombre());
		
		return estudianteTo;
		
	}
	
	private Estudiante convertirN(EsrtudianteTo estudianteTO) {
		Estudiante e = new Estudiante();
		e.setNombre(estudianteTO.getNombre());
		e.setApellido(estudianteTO.getApellido());
		e.setCedula(estudianteTO.getCedula());

		return e;
	}

	

	

}
