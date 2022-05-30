package com.apocalypse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apocalypse.entity.Survivor;
import com.apocalypse.service.SurvivorService;

@RestController
public class SurvivorCotroller {
	@Autowired
    private SurvivorService service;
	
	@PostMapping("/addSurvivors")
	public List<Survivor>addSurvivors(@RequestBody  List<Survivor>survivorList){
		return service.saveSurvivors(survivorList);
	}
	@GetMapping("/getAllSurvivors")
	public List<Survivor>getAllSurvivors(){
		return this.service.getAllSurvivors();
	}
	
	@GetMapping("/getAllInfectedSurvivors")
	public List<Survivor>getAllInfectedSurvivors(){
		return this.service.getInfectedSurvivors();
	}
	@GetMapping("/nonInfectedSurvivors")
	public List<Survivor>nonInfectedSurvivors(){
		return this.service.nonInfectedSurvivors();
	}
	@GetMapping("/getInfectedSurvivorPercentage")
	public double getInfectedSurvivorPercentage(){
		return this.service.getInfectedSurvivorPercentage();
	}
	@PutMapping("/updateStatus")
	public Survivor updateStatus(@RequestBody Survivor survivor) {
		return this.service.updateSurvivorStatus(survivor);
	}
	@PutMapping("/updateLocation")
	public Survivor updateLocation(@RequestBody Survivor survivor) {
		return this.service.updateLocation(survivor);
	}
	
	@GetMapping("/nonInfectedSurvivorsPerc")
	public double getNotInfectedSurvivorPercentage(){
		return this.service.getNotInfectedSurvivorPercentage();
	}
}
