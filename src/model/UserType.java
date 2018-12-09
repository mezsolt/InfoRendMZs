package model;

import java.io.Serializable;

/**
 * Created by mezsolt on 2018.12.06..
 */
public enum UserType  implements Serializable {
    CUSTOMER("CUSTOMER"),
    COMPANY("COMPANY");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
