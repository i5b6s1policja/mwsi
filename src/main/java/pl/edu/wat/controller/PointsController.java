package pl.edu.wat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.entity.Driver;
import pl.edu.wat.repository.DriverRepository;

@Controller
@RequestMapping("points")
public class PointsController {
    @Autowired
    DriverRepository driverRepository;

    @GetMapping("/change/{id}")
    public String setPointsForm(@PathVariable("id") Long driverId, Model model) {
        model.addAttribute("driverId", driverId);
        return "changePoints";
    }

    @PostMapping("/change")
    public String setPoints(@RequestParam("points") int points, @RequestParam("driver") Long driver) {
        Driver tmpDriver = driverRepository.getOne(driver);
        int tmpPoints;
        if (tmpDriver != null && points >= 0) {
            if ((tmpPoints = tmpDriver.getPenaltyPoints() + points) >= 0) {
                tmpDriver.setPenaltyPoints(tmpPoints);
                driverRepository.save(tmpDriver);
            }
        }
        return "redirect:/search/find/" + driver;
    }

    @PostMapping("/changeMinus")
    public String removePoints(@RequestParam("points") int points, @RequestParam("driver") Long driver) {
        Driver tmpDriver = driverRepository.getOne(driver);
        int tmpPoints;
        if (tmpDriver != null && points >= 0) {
            if ((tmpPoints = tmpDriver.getPenaltyPoints() - points) >= 0) {
                tmpDriver.setPenaltyPoints(tmpPoints);
                driverRepository.save(tmpDriver);
            }
        }
        return "redirect:/search/find/" + driver;
    }

}
