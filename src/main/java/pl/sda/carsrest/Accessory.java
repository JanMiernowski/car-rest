package pl.sda.carsrest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String accessoryName;

    public Accessory() {
    }

    public Accessory(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public static Accessory fromDto(AccessoryDto dto) {
        return new Accessory(dto.getAccessoryName());
    }

    public Integer getId() {
        return id;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public AccessoryDto toDto() {
        return new AccessoryDto(id, accessoryName);
    }
}
