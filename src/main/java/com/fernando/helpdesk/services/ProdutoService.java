package com.fernando.helpdesk.services;

import com.fernando.helpdesk.domain.Cliente;
import com.fernando.helpdesk.domain.Produto;
import com.fernando.helpdesk.domain.dtos.ProdutoDTO;
import com.fernando.helpdesk.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto create(ProdutoDTO objDTO) {
		objDTO.setId(null);
		Produto newObj = new Produto(objDTO);
		return repository.save(newObj);
	}

	public Produto update(Integer id, @Valid ProdutoDTO objDTO) {
		objDTO.setId(id);
		Produto oldObj = findById(id);

		oldObj = new Produto(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Produto obj = findById(id);

		repository.deleteById(id);
	}
	

}
