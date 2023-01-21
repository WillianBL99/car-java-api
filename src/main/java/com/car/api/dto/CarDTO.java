package com.car.api.dto;

import java.util.Date;

import com.car.api.handlers.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public record CarDTO(
    @NotBlank String model,
    @NotBlank String brand,
    @Past Date dateOfManufacture,
    @NotBlank String color,
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$") String price,
    @Pattern(regexp = "^[0-9]{2}/[0-9]{2}$") String modelYear) {
}