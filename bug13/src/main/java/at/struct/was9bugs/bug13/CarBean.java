package at.struct.was9bugs.bug13;

import javax.validation.constraints.NotNull;

public class CarBean {

    @NotNull
    private final String manufacturer;

    public CarBean(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
