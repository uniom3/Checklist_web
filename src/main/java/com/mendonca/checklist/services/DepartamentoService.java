package com.mendonca.checklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mendonca.checklist.entities.Departamento;
import com.mendonca.checklist.repositories.DepartamentoRepository;
import com.mendonca.checklist.repositories.DepartamentoRepositoryImp;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private DepartamentoRepositoryImp departamentoRepositoryImpl;

	public List<Departamento> findAll() {
		return departamentoRepository.findAll();
	}

	public Departamento findById(Integer id) {
		return departamentoRepositoryImpl.findById(id);
	}

	public List<Departamento> findByNome(String nome) {
		return departamentoRepositoryImpl.findByNome(nome);
	}

	public Departamento insert(Departamento obj) {
		obj.setId(null);
		return departamentoRepository.save(obj);
	}

	public Departamento editar(Departamento obj) {
		departamentoRepository.save(obj);
		return obj;
	}

	public void excluir(Integer id) {
		departamentoRepository.deleteById(id);
	}

	public boolean departamentoTemCargos(Integer id) {
		if (((Departamento) findById(id)).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}
	

}
