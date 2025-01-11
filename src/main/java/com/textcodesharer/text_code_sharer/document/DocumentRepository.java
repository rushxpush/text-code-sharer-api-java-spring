package com.textcodesharer.text_code_sharer.document;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	Optional<List<Document>> findByCategory(String category);
}
