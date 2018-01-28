package pl.edu.wat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.entity.Car;
import pl.edu.wat.model.BodyNumber;
import pl.edu.wat.model.EngineNumber;
import pl.edu.wat.model.PlateNumber;
import pl.edu.wat.model.VINNumber;
import pl.edu.wat.repository.CarRepository;
import pl.edu.wat.repository.DriverRepository;

import java.util.List;

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

    @GetMapping("")
    public String searchCar(Model model) {
        model.addAttribute("plateNumber", new PlateNumber());
        model.addAttribute("vin", new VINNumber());
        model.addAttribute("bodyNumber", new BodyNumber());
        model.addAttribute("engineNumber", new EngineNumber());
        return "car";
    }

    @RequestMapping("/findByPlateNumber")
    public String show(@ModelAttribute PlateNumber plateNumber, Model model) {
        List<Car> cars = carRepository.findByPlateNumber(plateNumber.getPlateNumber());
        Car car;
        if (cars.size() > 0) {
            car = cars.get(0);
        } else {
            car = new Car();
        }

        model.addAttribute("car", car);
        return "show_car";
    }

    @RequestMapping("/findByVIN")
    public String showByVIN(@ModelAttribute VINNumber vin, Model model) {
        List<Car> cars = carRepository.findByVINNumber(vin.getVin());
        Car car;
        if (cars.size() > 0) {
            car = cars.get(0);
        } else {
            car = new Car();
        }

        model.addAttribute("car", car);
        return "show_car";
    }
@RequestMapping("/findByBodyNumber")
    public String showByBodyNumber(@ModelAttribute BodyNumber bodyNumber, Model model) {
        List<Car> cars = carRepository.findByBodyNumber(bodyNumber.getBodyNumber());
        Car car;
        if (cars.size() > 0) {
            car = cars.get(0);
        } else {
            car = new Car();
        }

        model.addAttribute("car", car);
        return "show_car";
    }

    @RequestMapping("/findByEngineNumber")
    public String showByengineNumber(@ModelAttribute EngineNumber engineNumber, Model model) {
        List<Car> cars = carRepository.findByEngineNumber(engineNumber.getEngineNumber());
        Car car;
        if (cars.size() > 0) {
            car = cars.get(0);
        } else {
            car = new Car();
        }

        model.addAttribute("car", car);
        return "show_car";
    }

    @GetMapping("/add/{id}")
    public String addCarForm(@PathVariable("id") Long driverId, Model model) {
        model.addAttribute("driverId", driverId);
        return "addCar";
    }

    @PostMapping("/add")
    public String addCar(@RequestParam("brand") String brand, @RequestParam("model") String model, @RequestParam("vin") String vin,
                         @RequestParam("plateNumber") String plateNumber, @RequestParam("engineNumber") String engineNumber,
                         @RequestParam("bodyNumber") String bodyNumber, @RequestParam("insurance") String insurance,
                         @RequestParam("inspection") String inspection, @RequestParam("driver") Long driver) {
        Car car = Car.builder().brand(brand).model(model).vin(vin).plateNumber(plateNumber).engineNumber(engineNumber).
                bodyNumber(bodyNumber).insurance(insurance).inspection(inspection).stolen(false).
                driver(driverRepository.findOne(driver)).build();
        carRepository.save(car);
        return "home";
    }

    @GetMapping("/stolen/{id}")
    public String setStolen(@PathVariable("id") Long id){
        Car car = carRepository.findOne(id);
        car.setStolen(true);
        carRepository.save(car);
        return "home";
    }
    @GetMapping("/notStolen/{id}")
    public String setNotStolen(@PathVariable("id") Long id){
        Car car = carRepository.findOne(id);
        car.setStolen(false);
        carRepository.save(car);
        return "home";
    }
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id){
        Car car = carRepository.findOne(id);
        carRepository.delete(car);
        return "home";
    }
}
