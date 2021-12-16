package com.Iterator;

import com.Cars.Cars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Garage implements CarsCollection {
    private static volatile Garage garage;
    private List<Cars> carss;

    private Garage() {
        carss = new ArrayList<>();
    }

    public static Garage getGarage() {
        if (garage == null)
            synchronized (Garage.class) {
                if (garage == null)
                    garage = new Garage();
            }
        return garage;
    }

    public void arrangeGarage(Cars... arranges){
        System.out.println("\nGarage objects:\n");
        for (Cars cars : arranges)
            System.out.println(cars.toString());
    }

    public boolean addCars(Cars cars){
        return carss.add(cars);
    }

    public List<Cars> getCars() {
        return carss;
    }

    @Override
    public Iterator<Cars> iterator() {
        return new CarsIterator(carss);
    }
}
