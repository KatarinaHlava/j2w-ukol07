package cz.czechitas.java2webapps.ukol7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VizitkyController {

  //  private final VizitkyRepository repository;

    @GetMapping("/")
    public Object seznam(){
        return  new ModelAndView("seznam");
    }



//    @InitBinder
//    public void nullStringBinding(WebDataBinder binder) {
//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//    }

}
