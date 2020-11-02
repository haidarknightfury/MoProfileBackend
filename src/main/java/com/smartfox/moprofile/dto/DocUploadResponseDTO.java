package com.smartfox.moprofile.dto;

import java.io.Serializable;

public class DocUploadResponseDTO implements Serializable {
	
	private String response;

	public DocUploadResponseDTO(String response) {
		super();
		this.response = response;
	}

	public DocUploadResponseDTO() {
		super();
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	 

}
