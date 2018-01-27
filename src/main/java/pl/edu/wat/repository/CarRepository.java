package pl.edu.wat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.wat.entity.Driver;
import pl.edu.wat.enums.Brand;
import pl.edu.wat.enums.Model;

public interface CarRepository extends JpaRepository<Driver, Long> {
    @Modifying
    @Query(value = "insert into Car (brand,model,vin,plateNumber,engineNumber,bodyNumber,insurance,stolen,inspection,driver) " +
            "       VALUES (:brand,:model,:vin,:plateNumber,:engineNumber,:bodyNumber,:insurance,:stolen,:inspection,:driver)", nativeQuery = true)
    void insertNewCar(@Param("brand") Brand brand, @Param("model") Model model,@Param("vin") String vin, @Param("plateNumber") String plateNumber,
                @Param("engineNumber") String engineNumber,@Param("bodyNumber") String bodyNumber,@Param("insurance") String insurance,
                @Param("stolen") Boolean stolen,@Param("inspection") String inspection,@Param("driver") Driver driver);
}
