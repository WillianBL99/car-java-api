package com.car.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.api.dto.CarDTO;
import com.car.api.model.Car;
import com.car.api.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/car")
public class CarController {
  @Autowired
  private CarRepository carRepository;

  @PostMapping
  public void create(@RequestBody @Valid CarDTO req) {
    carRepository.save(new Car(req));
  }

  @GetMapping("/{carId}")
  public Optional<Car> get(@PathVariable String carId) {
    System.out.println("carId: " + carId);
    UUID id = UUID.fromString(carId);
    System.out.println("carId: " + carId);
    return carRepository.findById(id);
  }

  @DeleteMapping("/{carId}")
  public void delete(@PathVariable String carId) {
    UUID id = UUID.fromString(carId);
    carRepository.deleteById(id);
  }

  @PutMapping("/{carId}")
  public void update(@PathVariable String carId, @RequestBody @Valid CarDTO req) {
    UUID id = UUID.fromString(carId);
    carRepository.findById(id).map(car -> {
      car.setBrand(req.brand());
      car.setModel(req.model());
      car.setModelYear(req.modelYear());
      car.setPrice(req.price());
      car.setDateOfManufacture(req.dateOfManufacture());
      return carRepository.save(car);
    });
  }

  @GetMapping("/list")
  public List<Car> list() {
    return carRepository.findAll();
  }

}
