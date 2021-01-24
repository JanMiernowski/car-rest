package pl.sda.carsrest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("select c from Car c join fetch c.accessories ")
    List<Car> findAllWithFetch();

    @Query("select a from Car c join c.accessories a where c.id=?1")
    List<Accessory> findAccessoryByCarId(Integer id);
}
