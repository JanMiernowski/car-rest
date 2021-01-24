package pl.sda.carsrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Autowired
    private CarRepository carRepository;

    public List<CarDto> findAllCars(){
        return carRepository.findAllWithFetch().stream()
                .map(entity -> entity.toDto())
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void initializeCars() {
        List<Accessory> accessories = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            accessories.add(new Accessory("akcesorium " + i));
        }
        accessoryRepository.saveAll(accessories);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            List<Accessory> subList = accessories.subList(i * 5, (i * 5) + 5);
            cars.add(new Car("model " + i, i + "", subList));
        }
        carRepository.saveAll(cars);
    }

    public CarDto findCarById(Integer id) {
        return carRepository.findById(id)
                .map(entity -> entity.toDto())
                .orElseThrow(() -> new RuntimeException("Nie znaleziono samochodu o id " + id));
    }
}
