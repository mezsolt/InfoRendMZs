package model;

import java.io.Serializable;

/**
 * Created by mezsolt on 2018.12.03..
 */

public enum VehicleType implements Serializable {
    CAR("CAR"),
    SHIP("SHIP");

    private final String value;

    VehicleType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
