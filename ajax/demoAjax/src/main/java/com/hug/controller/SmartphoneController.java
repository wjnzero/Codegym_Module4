package com.hug.controller;

import com.hug.model.Smartphone;
import com.hug.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;
    @PostMapping
    public ResponseEntity<Smartphone> creatSmartphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones(){
        return new ResponseEntity<>(smartphoneService.findAll(),HttpStatus.OK);
    }
    @RequestMapping(value = "/list")
    public ModelAndView getAllSmartphonePage(){
        ModelAndView modelAndView = new ModelAndView("phones/list");
        modelAndView.addObject("smartphones",smartphoneService.findAll());
        return  modelAndView;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

}
