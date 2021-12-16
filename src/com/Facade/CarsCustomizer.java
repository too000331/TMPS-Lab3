package com.Facade;

import com.Cars.Cars;
import com.Factory.BaseFactory;
import com.Factory.Wrappers.BaseFactoryDecorator;
import com.Factory.Wrappers.ColorCustomizer;

public class CarsCustomizer {
    private final BaseFactory  carsFactory;

    public CarsCustomizer(BaseFactory carsFactory) {
        this.carsFactory = carsFactory;
    }

    public Cars getCustomCars(String type, String customColor, String brand) {
        BaseFactoryDecorator customizer = new ColorCustomizer(carsFactory, customColor);
        Cars customCars = customizer.createCars(type);
        customCars.setBrand(brand);
        return customCars;
    }
}
