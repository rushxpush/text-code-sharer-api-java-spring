package com.textcodesharer.text_code_sharer.document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	/*
	CommandLineRunner initDatabase(DocumentRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Document("Bitcoin prices go up", "Cryptocurrency", "Some content...")));
			log.info("Preloading " + repository.save(new Document("I like the Super Nintendo", "Gaming", "Some other content...")));
		};
		
	}
	*/

}
