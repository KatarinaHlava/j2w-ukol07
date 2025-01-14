package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Vizitka;
import cz.czechitas.java2webapps.ukol7.repository.VizitkyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class VizitkyController {

   private final VizitkyRepository repository;


   @Autowired
    public VizitkyController(VizitkyRepository repository) {
        this.repository = repository;
    }

    /* z tohohle jsem zmatena:
    8.Uprav controller tak, že bude mít field pro repository. Vytvoř pro controller konstruktor, který dostane repository jako vstupí parametr a uloží si ho do fieldu, aby bylo možné repository později v controlleru používat.

     znamena to ze nemam mat priamo vlastne repository ale list<repository>?  alebo ako presne funguje ich vztah, databaza a list?
      viem ze filip to spominal na prednaske ze sa chova ako list, ale este v tom nemam celkom jasno */

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public Object seznam(){
        return  new ModelAndView("seznam")
                .addObject("vizitka", repository.findAll());
    }

    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable int id) {
        Optional<Vizitka> vizitka = repository.findById(id);
        if (vizitka.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ModelAndView("vizitka")
                .addObject("vizitka", vizitka.get());
    }
    @GetMapping("/nova")
    public Object formular() {
        return new ModelAndView("formular")
                .addObject("vizitka", new Vizitka());
    }

    @PostMapping("/nova")
    public Object pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/nova";
        }
       // vizitka.setId(null);
        repository.save(vizitka);
        return "redirect:/";
    }
    //Do controlleru přidej POST metodu, která bude reagovat na POST požadavky na adrese /nova.
    // Jako parametr bude přijímat entitu Vizitka, použijeme ji i pro přenos dat z formuláře. Použij metodu save() repository pro uložení vizitky.
    // Po uložení vizitky přesměruj uživatele na úvodní stránku. Vyzkoušej v prohlížeči, že funguje přidání vizitky.



}
