package pl.sda.carsrest;

import javax.persistence.OneToMany;
import java.util.List;

public class CarDto {

    private Integer id;
    private String model;
    private String vin;
    private List<AccessoryDto> accessories;

    public CarDto(Integer id, String model, String vin, List<AccessoryDto> accessories) {
        this.id = id;
        this.model = model;
        this.vin = vin;
        this.accessories = accessories;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public List<AccessoryDto> getAccessories() {
        return accessories;
    }
}
