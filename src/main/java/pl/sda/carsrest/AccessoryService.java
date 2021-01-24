package pl.sda.carsrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessoryService {

    @Autowired
    private CarRepository carRepository;

    public List<AccessoryDto> findAccessoriesByCarId(Integer id) {
        return carRepository.findAccessoryByCarId(id).stream()
                .map(entity -> entity.toDto())
                .collect(Collectors.toList());
    }

}
