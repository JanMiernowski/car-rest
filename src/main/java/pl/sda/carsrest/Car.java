package pl.sda.carsrest;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String model;
    private String vin;
    @OneToMany
    private List<Accessory> accessories;

    public Car() {
    }

    public Car(String model, String vin, List<Accessory> accessories) {
        this.model = model;
        this.vin = vin;
        this.accessories = accessories;
    }

    public CarDto toDto() {
        return new CarDto(
                id,
                model,
                vin,
                accessories.stream().map(entity -> entity.toDto()).collect(Collectors.toList()));
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

    public List<Accessory> getAccessories() {
        return accessories;
    }
}
