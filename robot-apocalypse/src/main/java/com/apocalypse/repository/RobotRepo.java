package com.apocalypse.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apocalypse.entity.Robot;
@Repository
public interface RobotRepo extends CrudRepository<Robot,Long>{
   public List<Robot>getCategoryWisedRobots(String category);
   public List<Robot>findByOrderByManufacturedDateAsc();
   
}
