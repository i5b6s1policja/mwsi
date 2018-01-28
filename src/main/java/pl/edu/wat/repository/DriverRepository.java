package pl.edu.wat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.wat.entity.Driver;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query("SELECT d FROM Driver d WHERE d.pesel = :pesel")
    List<Driver> findByPesel(@Param("pesel") String pesel);

    @Query("SELECT d FROM Driver d WHERE d.name = :name AND d.surname = :surname")
    List<Driver> findByNameAndSurname(@Param("name")String name, @Param("surname")String surname);

    @Query("SELECT d FROM Driver d WHERE d.drivingLicense = :drivingLicense")
    List<Driver> findByDrivingLicense(@Param("drivingLicense")String drivingLicens);
}
