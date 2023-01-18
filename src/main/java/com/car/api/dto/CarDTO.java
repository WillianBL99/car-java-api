package com.car.api.dto;

import com.car.api.handlers.*;

public record CarDTO(String model, String brand, String dateOfManufacture, String color, String price,
    String modelYear) {
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
