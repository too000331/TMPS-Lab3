package com;

import com.Adapter.AutoPartsAdapter;
import com.AutoParts.Filter;
import com.AutoParts.Motor;
import com.AutoParts.Tires;
import com.Cars.Cars;
import com.Facade.CarsCustomizer;
import com.Factory.*;
import com.Iterator.Garage;

import java.util.Iterator;


public class Main {

    public static void main(String[] args) {


        BaseFactory mercedesFactory = MercedesFactory.getMercedesFactory();

        Tires tire = new Tires();
        Filter filters = new Filter();
        Motor motors = new Motor();
        AutoPartsAdapter tiresAdapter = new AutoPartsAdapter(tire);
        AutoPartsAdapter filterAdapter = new AutoPartsAdapter(filters);
        AutoPartsAdapter motorAdapter = new AutoPartsAdapter(motors);
        Garage garage = Garage.getGarage();
        garage.arrangeGarage(tiresAdapter,filterAdapter,motorAdapter
                ,mercedesFactory.createCars("sedan")
                ,mercedesFactory.createCars("pickup truck")
                ,mercedesFactory.createCars("minivan"));

        System.out.println("\nCustomized Cars:\n");

        CarsCustomizer customizer = new CarsCustomizer(mercedesFactory);


        System.out.println(customizer.getCustomCars("sedan", "white", "BMW"));
        System.out.println(customizer.getCustomCars("pickup truck", "blue", "Chevrolet"));
        System.out.println(customizer.getCustomCars("minivan", "black", "Fiat"));

        System.out.println("\nOther cars:\n");

        System.out.println(mercedesFactory.createCars("sedan").toString());
        System.out.println(mercedesFactory.createCars("pickup truck").toString());
        System.out.println(mercedesFactory.createCars("minivan").toString());

        BaseFactory fordFactory = FordFactory.getFordFactory();
        System.out.println(fordFactory.createCars("sedan").toString());
        System.out.println(fordFactory.createCars("pickup truck").toString());
        System.out.println(fordFactory.createCars("minivan").toString());

        BaseFactory toyotaFactory = ToyotaFactory.getToyotaFactory();
        System.out.println(toyotaFactory.createCars("sedan").toString());
        System.out.println(toyotaFactory.createCars("pickup truck").toString());
        System.out.println(toyotaFactory.createCars("minivan").toString());

        BaseFactory volkswagenFactory = VolkswagenFactory.getVolkswagenFactory();
        System.out.println(volkswagenFactory.createCars("sedan").toString());
        System.out.println(volkswagenFactory.createCars("pickup truck").toString());
        System.out.println(volkswagenFactory.createCars("minivan").toString());

        garage.addCars(tiresAdapter);
        garage.addCars(filterAdapter);
        garage.addCars(motorAdapter);
        garage.addCars(mercedesFactory.createCars("minivan"));
        garage.addCars(customizer.getCustomCars("sedan", "Pink", "Lexus"));

        printCarsObjects(garage.iterator());

    }
    private static void printCarsObjects(Iterator<Cars> iterator) {
        System.out.println("\nGarage added objects:\n");

        while (iterator.hasNext()) {
            Cars cars = iterator.next();
            System.out.println(cars.toString());
        }
    }
}
