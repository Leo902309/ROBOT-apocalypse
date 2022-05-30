package com.apocalypse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apocalypse.entity.Robot;
import com.apocalypse.repository.RobotRepo;

@Service
public class RobotService {
  @Autowired
  private RobotRepo repo;
  
  public List<Robot> addRobots(List<Robot>robotList) {
	 return (List<Robot>) repo.saveAll(robotList);
  }
  public Robot addRobot(Robot robot) {
	 return this.repo.save(robot);
  }
  public List<Robot>getAllRobot(){
	  return (List<Robot>) this.repo.findAll();
  }
  
  public List<Robot> getCategoryWisedRobots(String catagory){
	  return this.repo.getCategoryWisedRobots(catagory);
  }
  public List<Robot> findByOrderByManufacturedDateAsc(){
	  return this.repo.findByOrderByManufacturedDateAsc();
  }
 
  
}
