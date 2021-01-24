package pl.sda.carsrest;

public class AccessoryDto {

    private Integer id;
    private String accessoryName;

    public AccessoryDto() {
    }

    public AccessoryDto(Integer id, String accessoryName) {
        this.id = id;
        this.accessoryName = accessoryName;
    }

    public Integer getId() {
        return id;
    }

    public String getAccessoryName() {
        return accessoryName;
    }
}
