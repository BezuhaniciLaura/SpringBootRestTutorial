package com.tutorial.spb.rest.controlers;

import com.tutorial.spb.rest.entities.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    private List<Coffee> coffeeList = new ArrayList<>();

    public CoffeeController() {
        coffeeList.addAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Ganador"),
                new Coffee("Café Lareño"),
                new Coffee("Café Três Pontas")
        ));
    }

    @GetMapping
    public Iterable<Coffee> getCoffee() {
        return coffeeList;
    }


    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee coffee : coffeeList) {
            if (coffee.getId().equals(id))
                return Optional.of(coffee);
        }
        return Optional.empty();
    }

    @PostMapping
    public Coffee postMapping(@RequestBody Coffee coffee) {
        coffeeList.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> putMapping(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;
        for (Coffee coffeeIterate : coffeeList) {
            if (coffeeIterate.getId().equals(id)) {
                coffeeIndex = coffeeList.indexOf(coffeeIterate);
                coffeeList.set(coffeeIndex, coffee);
            }
        }
        return coffeeIndex == -1 ?
                new ResponseEntity<>(postMapping(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable String id) {
        coffeeList.removeIf(coffee -> coffee.getId().equals(id));
    }
}
