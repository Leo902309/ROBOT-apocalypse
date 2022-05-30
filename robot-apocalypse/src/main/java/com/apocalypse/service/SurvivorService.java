package com.apocalypse.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apocalypse.entity.Survivor;
import com.apocalypse.repository.SurvivorRepository;

@Service
public class SurvivorService {

	@Autowired
	public SurvivorRepository repo;

	public List<Survivor> saveSurvivors(List<Survivor> survivorList) {
		return (List<Survivor>) this.repo.saveAll(survivorList);
	}

	public Survivor saveSurvivor(Survivor survivor) {
		return this.repo.save(survivor);
	}

	public Survivor updateSurvivorStatus(Survivor survivor) {
		Optional<Survivor> survivorDbOp = this.repo.findById(survivor.getPrimaryKey());
		if (survivorDbOp.isPresent()) {
			Survivor survivorDb = survivorDbOp.get();
			survivorDb.setIsInfacted(survivor.isInfacted);
			this.repo.save(survivorDb);
			return survivorDb;
		}
		return null;
	}

	public Survivor updateLocation(Survivor survivor) {
		Optional<Survivor> survivorDbOp = this.repo.findById(survivor.getPrimaryKey());
		if (survivorDbOp.isPresent()) {
			Survivor survivorDb = survivorDbOp.get();
			survivorDb.setLastLocation(survivor.getLastLocation());
			this.repo.save(survivorDb);
			return survivorDb;
		}
		return null;
	}

	public List<Survivor> getAllSurvivors() {
		return (List<Survivor>) this.repo.findAll();
	}

	public Survivor getSurvivor(long primaryKey) {
		Optional<Survivor> s = this.repo.findById(primaryKey);
		return s.get();
	}

	/**
	 * Percentage of infected survivors
	 * 
	 * @return double %
	 * @return
	 */

	public double getInfectedSurvivorPercentage() {
		float all = this.repo.count();
		if (all == 0)
			return 0;
		long infectedSurvCount = this.repo.infectedSurvivorsCount();
		return (infectedSurvCount / all) * 100;
	}

	/**
	 * Percentage of non-infected survivors
	 */

	public double getNotInfectedSurvivorPercentage() {
		float all = this.repo.count();
		if (all == 0)
			return 0;
		long infectedSurvCount = this.repo.infectedSurvivorsCount();
		return ((all-infectedSurvCount)/all)*100;
	}
	/**
	 * This method lists out all the non infected survivors
	 * @return
	 */
	public List<Survivor>nonInfectedSurvivors(){
		return this.repo.nonInfectedSurvivors();
	}
	/**
	 * This method lists out all the infected survivors
	 * @return 
	 */
	public List<Survivor> getInfectedSurvivors() {
		return this.repo.infectedSurvivors();
	}
   
	
}
