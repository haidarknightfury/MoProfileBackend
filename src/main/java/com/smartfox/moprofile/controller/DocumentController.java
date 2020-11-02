package com.smartfox.moprofile.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartfox.moprofile.dto.DocUploadResponseDTO;
import com.smartfox.moprofile.service.DocumentStorageService;

// https://dzone.com/articles/java-springboot-rest-api-to-uploaddownload-file-on
// https://www.baeldung.com/spring-boot-mongodb-upload-file

@CrossOrigin
@RestController
public class DocumentController {

	@Autowired
	public DocumentStorageService documentStorageService;
	
	@PostMapping(value = "/docupload")
	public ResponseEntity<?> storeFile(@RequestParam("file")MultipartFile file) throws IOException{
		String fileName = documentStorageService.storeFile(file);
		System.out.println("storing file" + fileName);
		DocUploadResponseDTO docUploadResponseDTO = new DocUploadResponseDTO(fileName);
		return ResponseEntity.ok(docUploadResponseDTO);		
	}
	
}
