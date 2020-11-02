package com.smartfox.moprofile.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentStorageService {

   private final Path fileStorageLocation;
	  
	public DocumentStorageService() {
		this.fileStorageLocation = Paths.get("C:/Devtools").toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception e) {
			System.out.println("Could not create directory");
		}
	}
	
	public String storeFile(MultipartFile multipartFile) throws IOException {
		String originalFileName = multipartFile.getOriginalFilename();
		String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		Path targetLocation = this.fileStorageLocation.resolve(originalFileName);
		Files.copy(multipartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		return fileExtension;
	}
	
}
