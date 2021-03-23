package com.tutorial.spb.rest.controlers;

import com.tutorial.spb.rest.entities.Coffee;
import com.tutorial.spb.rest.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffesRest")
public class RestCoffeeController {

    private CoffeeRepository coffeeRepository;

    @Autowired
    RestCoffeeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
        coffeeRepository.saveAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Ganador"),
                new Coffee("Café Lareño"),
                new Coffee("Café Três Pontas"))
        );
    }


    @GetMapping
    Iterable<Coffee> getCoffee() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        return Optional.of(coffeeRepository.getOne(id));
    }


    @PostMapping
    Coffee saveCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }


    @PutMapping("/{id}")
    ResponseEntity<Coffee> updateCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        return coffeeRepository.existsById(id) ?
                new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK) :
                new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id){
        coffeeRepository.deleteById(id);
    }


}
