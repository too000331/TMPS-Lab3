package com.Adapter;

import com.AutoParts.AutoParts;

public class AutoPartsAdapter extends AdapterUtil {
    private final AutoParts object;

    public AutoPartsAdapter(AutoParts autoParts){
        this.object =  autoParts;
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
