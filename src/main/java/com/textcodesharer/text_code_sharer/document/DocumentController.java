package com.textcodesharer.text_code_sharer.document;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/document")
public class DocumentController {
	
	private final DocumentRepository repository;
	
	DocumentController(DocumentRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping()
	List<Document> getAllDocuments() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	Document getDocumentById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new DocumentNotFoundException(id));
	}

	@PostMapping()
	Document createDocument(@RequestBody Document newDocument) {
		return repository.save(newDocument);
	}
	
	@PutMapping("/{id}")
	Document updateDocument(@RequestBody Document newDocument, @PathVariable Long id) {
		return repository.findById(id)		
				.map(document -> {
					document.setTitle(newDocument.getTitle());
					document.setCategory(newDocument.getCategory());
					return repository.save(document);
				})
				.orElseGet(() -> {
					return repository.save(newDocument);
				});
	}
	
	@DeleteMapping("/{id}")
	void deleteDocument(@PathVariable Long id) {
		repository.deleteById(id);
	}


}
