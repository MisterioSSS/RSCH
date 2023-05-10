package com.psuti.Itruhin.controller;

import com.psuti.Itruhin.dao.CarRepository;

import com.psuti.Itruhin.entity.Variant3.CarProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<CarProjection> getCars(){
        return carRepository.getAllCars();
    }
}
