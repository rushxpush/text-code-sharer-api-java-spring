package com.textcodesharer.text_code_sharer.document;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/document")
public class DocumentController {
	
	private final DocumentService service;
	
	DocumentController(DocumentService service) {
		this.service = service;
	}
	
	@GetMapping()
	List<Document> findAllDocuments() {
		System.out.println("getAllDocuments");
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	Document findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping()
	Document findByCategory(@RequestParam(value = "category",required = false) String category) {
		System.out.println("findByCategory");
		System.out.println("category: " + category);
		return service.findByCategory(category);
	}

	@PostMapping()
	Document save(@RequestBody Document newDocument) {
		return service.save(newDocument);
	}
	
	@PutMapping("/{id}")
	Document updateDocument(@PathVariable Long id, @RequestBody Document newDocument) {
		return service.update(id, newDocument);
	}
	
	@DeleteMapping("/{id}")
	void deleteDocument(@PathVariable Long id) {
		service.delete(id);
	}
}
