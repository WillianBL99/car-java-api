package com.car.api.model;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.car.api.dto.CarDTO;
import com.car.api.handlers.DataHandler;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "car", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class Car {

  public Car() {
  }

  public Car(CarDTO data) {
    this.model = data.model();
    this.brand = data.brand();
    this.dateOfManufacture = DataHandler.parse(data.dateOfManufacture());
    this.color = data.color();
    this.price = data.price();
    this.modelYear = data.modelYear();
  }

  @Id
  @UuidGenerator
  private UUID id;

  @Column(length = 50, nullable = false)
  private String model;

  @Column(length = 50, nullable = false)
  private String brand;

  @Column(nullable = false)
  private LocalDate dateOfManufacture;

  @Column(length = 10, nullable = false)
  private String color;

  @Column(length = 10, nullable = false)
  private String price;

  @Column(length = 4, nullable = false)
  private String modelYear;
}
