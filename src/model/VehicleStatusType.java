package model;

import java.io.Serializable;

/**
 * Created by mezsolt on 2018.12.03..
 */

public enum VehicleStatusType implements Serializable {
    FREE("FREE"),
    RESERVED("RESERVED"),
    NOT_AVAILABLE("NOT_AVAILABLE");

    private final String value;

    VehicleStatusType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
