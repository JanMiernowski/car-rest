package pl.sda.carsrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accessories")
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;

    @GetMapping("/car/{id}")
    public List<AccessoryDto> accessories(@PathVariable Integer id){
        return accessoryService.findAccessoriesByCarId(id);
    }

}
