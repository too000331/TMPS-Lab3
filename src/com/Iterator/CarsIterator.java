package com.Iterator;

import com.Cars.Cars;

import java.util.Iterator;
import java.util.List;

public class CarsIterator implements Iterator<Cars> {
    private List<Cars> carss;
    private int currentItem = 0;

    public CarsIterator(List<Cars> carss) {
        this.carss = carss;
    }

    @Override
    public boolean hasNext() {
        return (currentItem < carss.size() && carss.get(currentItem) != null);
    }

    @Override
    public Cars next() {
        return carss.get(currentItem++);
    }
}
