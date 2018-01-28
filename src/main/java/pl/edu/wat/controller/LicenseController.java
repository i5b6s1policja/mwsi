package pl.edu.wat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wat.entity.Driver;
import pl.edu.wat.repository.DriverRepository;

/**
 * Created by Paweł Skrzypkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Controller
@RequestMapping("license")
public class LicenseController {
    @Autowired
    DriverRepository driverRepository;

    @GetMapping("/stop/{id}")
    public String setStopLicense(@PathVariable("id") Long id){
        Driver driver = driverRepository.findOne(id);
        driver.setDrivingLicenseTaken(true);
        driverRepository.save(driver);
        return "home";
    }
    @GetMapping("/give/{id}")
    public String setGiveLicense(@PathVariable("id") Long id){
        Driver driver = driverRepository.findOne(id);
        driver.setDrivingLicenseTaken(false);
        driverRepository.save(driver);
        return "home";
    }
}
