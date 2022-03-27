package com.bitmovin.trial.encodingapi.encodes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncodesController {
	
	@Autowired
	private EncodesService encodeService;

	@GetMapping("/encodes")
	public List<Encodes> getAllEncodes() {
		return encodeService.getAllEncodes();
	}
	
	@GetMapping("/encodes/{id}")
	Encodes getEncodes(@PathVariable UUID id) {
		return encodeService.getById(id);
	}
	
	@DeleteMapping("/encodes/{id}")
	List<Encodes> deleteEncodes(@PathVariable UUID id) {
		return encodeService.deleteById(id);
	}
	
	@PostMapping("/encodes")
	List<Encodes> newEmployee(@RequestBody Encodes newEncodes) {
	   return encodeService.addEncodes(newEncodes);
	}

}
