package pl.edu.wat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.wat.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {


    @Query("SELECT c FROM Car c WHERE c.plateNumber = :plateNumber")
    List<Car> findByPlateNumber(@Param("plateNumber") String plateNumber);

    @Query("SELECT c FROM Car c WHERE c.vin = :vin")
    List<Car> findByVINNumber(@Param("vin") String vin);

    @Query("SELECT c FROM Car c WHERE c.bodyNumber = :bodyNumber")
    List<Car> findByBodyNumber(@Param("bodyNumber") String bodyNumber);

    @Query("SELECT c FROM Car c WHERE c.engineNumber = :engineNumber")
    List<Car> findByEngineNumber(@Param("engineNumber") String engineNumber);

}