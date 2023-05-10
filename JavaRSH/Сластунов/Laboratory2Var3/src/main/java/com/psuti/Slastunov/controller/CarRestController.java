package com.psuti.Slastunov.controller;

import com.psuti.Slastunov.dao.CarRepository;

import com.psuti.Slastunov.entity.Variant3.Car;
import com.psuti.Slastunov.entity.Variant3.CarProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;


@RequestMapping("/cars")
@RestController
public class CarRestController {

    private final CarRepository carRepository;

    @Autowired
    public CarRestController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Autowired
    CarService carService;

    @GetMapping
    public  List<CarProjection> getCars(){
        return carService.getCars();
    }

    @GetMapping("/cars_full")
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getById (@PathVariable("id") UUID id){
        return carRepository.findById(id).get();
    }

    @PutMapping
    public Car update (@RequestBody Car car){
        if(carRepository.existsById (car.getId())) {
            return carRepository.save(car);
        }
        throw new EntityExistsException("User with id:'"+ car.getId() +"' doesn't exists");
    }

    @PostMapping
    public Car create(@RequestBody Car car){
        return carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public void remove (@PathVariable("id") UUID id){
        carRepository.deleteById(id);
    }
}
