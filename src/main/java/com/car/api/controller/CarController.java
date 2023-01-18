package com.car.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.api.dto.CarDTO;

@RestController
@RequestMapping("/car")
public class CarController {
  private List<CarDTO> cars = new ArrayList<>();

  @PostMapping
  public void save(@RequestBody CarDTO req) {
    cars.add(req);
  }

  @GetMapping("/list")
  public List<CarDTO> list() {
    return cars;
  }
}
