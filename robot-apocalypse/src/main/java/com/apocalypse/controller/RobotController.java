package com.apocalypse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apocalypse.entity.Robot;
import com.apocalypse.service.RobotService;

@RestController
public class RobotController {
	@Autowired
    private RobotService robotService;
	
	@PostMapping("/addRobots")
	public List<Robot> addRobots(@RequestBody List<Robot>robotList) {
		return this.robotService.addRobots(robotList);
	}
	@PostMapping("/addRobot")
	public Robot addRobot(@RequestBody Robot robot) {
		return this.robotService.addRobot(robot);
	}
	@GetMapping("/getAllRobots")
	public List<Robot> getAllRobots() {
		return this.robotService.getAllRobot();
	}
	@GetMapping("/getRobotsCategoryWise/{category}")
	public List<Robot> getRobotsCategoryWise(@PathVariable String category) {
		return this.robotService.getCategoryWisedRobots(category);
	}
	
	@GetMapping("/getSortedByDate")
	public List<Robot> getSortedByDate() {
		return this.robotService.findByOrderByManufacturedDateAsc();
	}
	
	
	
}
