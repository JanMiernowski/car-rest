package pl.sda.carsrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> carsList(){
        return ResponseEntity.ok(carService.findAllCars());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CarDto> car(@PathVariable Integer id){
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<CarDto>> carsListpagination(
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page,
            @RequestParam("model") String model,
            @RequestParam("sortField") String sortField
    ){
        return ResponseEntity.ok(carService.findAllCars(size, page, model, sortField));
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto){
        carService.addCar(carDto);
        return ResponseEntity.ok().build();
    }
}
