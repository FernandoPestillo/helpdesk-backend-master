package com.fernando.helpdesk.resources;

import com.fernando.helpdesk.domain.Produto;
import com.fernando.helpdesk.domain.dtos.ProdutoDTO;
import com.fernando.helpdesk.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) {
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(new ProdutoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> list = service.findAll();
		List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO objDTO) {
		Produto newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Integer id, @Valid @RequestBody ProdutoDTO objDTO) {
		Produto obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ProdutoDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> delete(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
