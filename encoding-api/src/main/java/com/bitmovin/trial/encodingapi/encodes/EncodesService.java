package com.bitmovin.trial.encodingapi.encodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class EncodesService {

	private List<Encodes> encodes = new ArrayList<>(Arrays.asList(
			new Encodes(generateEncode("test", "AWS")),
			new Encodes(generateEncode("test-2", "AWS-2"))
		));
	
	public List<Encodes> getAllEncodes() {
		return encodes;
	}
	
	public UUID generateID() {
		UUID uniqueId = UUID.randomUUID();
		return uniqueId;
	}
	
	public Encodes generateEncode(String name, String provider) {
		return new Encodes(generateID(), name, provider);
	}
	
	public Encodes getById(UUID id) {
		Predicate<Encodes> byId = encode -> encode.getId().equals(id);
		
		List<Encodes> encodes = getAllEncodes();
		return encodes.stream().filter(byId).findFirst().get();
	}
	
	public List<Encodes> addEncodes(Encodes newEncodes) {
		Encodes encode = generateEncode(newEncodes.getName(), newEncodes.getProvider());
		encodes.add(encode);
		return getAllEncodes();
	}
	
	public List<Encodes> deleteById(UUID id) {
		Predicate<Encodes> byId = encode -> !encode.getId().equals(id);
		
		List<Encodes> encodes = getAllEncodes();
		List<Encodes> filteredEncodes = encodes.stream().filter(byId).collect(Collectors.toList());
		updateList(filteredEncodes);
		return getAllEncodes();
	}
	
	public void updateList(List<Encodes> encodes) {
		this.encodes = encodes;
	}
}
