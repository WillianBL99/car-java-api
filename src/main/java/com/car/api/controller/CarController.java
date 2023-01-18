package com.car.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.api.dto.CarDTO;
import com.car.api.model.Car;
import com.car.api.repository.CarRepository;

@RestController
@RequestMapping("/car")
public class CarController {
  @Autowired
  private CarRepository carRepository;

  @PostMapping
  public void create(@RequestBody CarDTO req) {
    carRepository.save(new Car(req));
  }

  @GetMapping("/")
  public Optional<Car> get(@RequestParam String carId) {
    UUID id = UUID.fromString(carId);
    System.out.println("carId: " + carId);
    return carRepository.findById(id);
  }

  @GetMapping("/list")
  public List<Car> list() {
    return carRepository.findAll();
  }

}
