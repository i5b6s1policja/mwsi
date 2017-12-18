package pl.edu.wat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wat.entity.Driver;
import pl.edu.wat.model.DrivingLicense;
import pl.edu.wat.model.NameAndSurname;
import pl.edu.wat.model.Pesel;
import pl.edu.wat.repository.DriverRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    private DriverRepository driverRepository;

    @Autowired
    public SearchController(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @GetMapping("")
    public String search(Model model){
        model.addAttribute("nameAndSurname", new NameAndSurname());
        model.addAttribute("drivingLicense", new DrivingLicense());
        model.addAttribute("pesel", new Pesel());
        return "search";
    }


    @PostMapping("/findByPesel")
    public String show(@ModelAttribute Pesel pesel, Model model){
        Driver driver = driverRepository.findByPesel(pesel.getPesel());
        List<Driver> allDrivers = new ArrayList<>();
        allDrivers.add(driver);
        model.addAttribute("allDrivers", allDrivers);
        return "show";
    }

    @RequestMapping("/findByDrivingLicense")
    public String show(@ModelAttribute DrivingLicense drivingLicense, Model model){
        Driver driver = driverRepository.findByDrivingLicense(drivingLicense.getDrivinglicense());
        List<Driver>allDrivers = new ArrayList<>();
        allDrivers.add(driver);
        model.addAttribute("allDrivers", allDrivers);
        return "show";
    }

    @RequestMapping("/findByNameAndSurname")
    public String show(@ModelAttribute NameAndSurname nameAndSurname, Model model){

        List<Driver> drivers = driverRepository.findByNameAndSurname(nameAndSurname.getName(), nameAndSurname.getSurname());

        model.addAttribute("allDrivers", drivers);
        return "show";
    }

}
