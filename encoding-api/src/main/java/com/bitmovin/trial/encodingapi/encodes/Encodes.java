package com.bitmovin.trial.encodingapi.encodes;

import java.util.UUID;

public class Encodes {
	
	private UUID id;
	private String name;
	private String provider;
	
	public Encodes(UUID id, String name, String provider) {
		super();
		this.id = id;
		this.name = name;
		this.provider = provider;
	}
	
	public Encodes(Encodes generateEncode) {
		super();
		this.id = generateEncode.id;
		this.name = generateEncode.name;
		this.provider = generateEncode.provider;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}

}
