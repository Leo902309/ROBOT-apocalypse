package com.apocalypse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apocalypse.entity.Survivor;
@Repository
public interface SurvivorRepository extends JpaRepository<Survivor,Long>{
	public List<Survivor> infectedSurvivors();
	public long infectedSurvivorsCount();
	public List<Survivor>nonInfectedSurvivors();
}
