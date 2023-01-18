package com.car.api.dto;

import com.car.api.handlers.*;

public record CarDTO(String model, String brand, String dateOfManufacture, String color, String price,
    String modelYear) {

  public CarDTO {
    if (model == null || model.isBlank()) {
      throw new IllegalArgumentException("Model must be between 1 and 50 characters");
    } else if (model.length() < 1 || model.length() > 50) {
      throw new IllegalArgumentException("Model must be between 1 and 50 characters");
    }

    if (brand == null || brand.isBlank()) {
      throw new IllegalArgumentException("Brand must be informed");

    } else if (brand.length() < 3 || brand.length() > 50) {
      throw new IllegalArgumentException("Brand must be between 3 and 50 characters");
    }

    if (dateOfManufacture == null || dateOfManufacture.isBlank()) {
      throw new IllegalArgumentException("Date of manufacture must be informed");
    } else if (!DataHandler.isDateValid(dateOfManufacture)) {
      throw new IllegalArgumentException("Date of manufacture must be in the format dd/MM/yyyy");
    }

    if (color == null || color.isBlank()) {
      throw new IllegalArgumentException("Color must be informed");
    }

    if (price == null || price.isBlank()) {
      throw new IllegalArgumentException("Price must be informed");
    } else if (!price.matches("[0-9]+(\\.[0-9]{1,2})?")) {
      throw new IllegalArgumentException("Price must be a number with up to 2 decimal places");
    }

    if (modelYear == null || modelYear.isBlank()) {
      throw new IllegalArgumentException("Model year must be informed");
    } else if (!modelYear.matches("[0-9]{4}")) {
      throw new IllegalArgumentException("Model year must be a number with yy/yy format");
    }
  }
}

// body response
// {
// "modle": "Gol",
// "brand": "Volkswagen",
// "dateOfManufacture": "01/01/2021",
// "color": "Black",
// "price": "100000",
// "modelYear": "2021"
// }
