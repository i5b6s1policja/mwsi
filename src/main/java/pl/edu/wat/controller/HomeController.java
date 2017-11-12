package pl.edu.wat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Paweł Skrzypkowski
 * Wojskowa Akaddemia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */
@Controller
public class HomeController{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }
}
