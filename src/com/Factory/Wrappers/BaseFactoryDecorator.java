package com.Factory.Wrappers;

import com.Cars.Cars;
import com.Factory.BaseFactory;

public class BaseFactoryDecorator implements BaseFactory {
    protected BaseFactory wrapper;

    public BaseFactoryDecorator(BaseFactory baseFactory){

        this.wrapper = baseFactory;
    }

    public Cars createCars(String type) {
        return wrapper.createCars(type);
    }
}
