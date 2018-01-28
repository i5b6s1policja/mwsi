package pl.edu.wat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.entity.Car;
import pl.edu.wat.repository.CarRepository;
import pl.edu.wat.repository.DriverRepository;

/**
 * Created by Paweł Skrzypkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */
@Controller
@RequestMapping("car")
public class CarController {
    @Autowired
    CarRepository carRepository;
    @Autowired
    DriverRepository driverRepository;
    @GetMapping("/add/{id}")
    public String addCarForm(@PathVariable("id") Long driverId, Model model){
        model.addAttribute("driverId", driverId);
        return "addCar";
    }
    @PostMapping("/add")
    public String addCar(@RequestParam("brand") String brand, @RequestParam("model") String model, @RequestParam("vin") String vin,
                         @RequestParam("plateNumber") String plateNumber, @RequestParam("engineNumber") String engineNumber,
                         @RequestParam("bodyNumber") String bodyNumber, @RequestParam("insurance") String insurance,
                         @RequestParam("inspection") String inspection, @RequestParam("driver") Long driver){
        Car car = Car.builder().brand(brand).model(model).vin(vin).plateNumber(plateNumber).engineNumber(engineNumber).
                    bodyNumber(bodyNumber).insurance(insurance).inspection(inspection).stolen(false).
                    driver(driverRepository.findOne(driver)).build();
        carRepository.save(car);
        return "home";
    }
}
