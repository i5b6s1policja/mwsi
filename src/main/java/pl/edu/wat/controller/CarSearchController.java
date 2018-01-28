package pl.edu.wat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wat.entity.Car;
import pl.edu.wat.model.PlateNumber;
import pl.edu.wat.repository.CarRepository;

import java.util.List;

@Controller
@RequestMapping("car")
public class CarSearchController {
    private CarRepository carRepository;

    @Autowired
    public CarSearchController(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @GetMapping("")
    public String searchCar(Model model){
        model.addAttribute("plateNumber", new PlateNumber());
        return "car";
    }

    @RequestMapping("/findByPlateNumber")
    public String show(@ModelAttribute PlateNumber plateNumber, Model model){
        Car car = carRepository.findByPlateNumber(plateNumber.getPlateNumber()).get(0);

        model.addAttribute("car",car);
        return "show_car";
    }
}
