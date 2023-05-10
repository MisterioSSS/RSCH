package com.psuti.Itruhin.dao;


import com.psuti.Itruhin.entity.Variant3.Car;
import com.psuti.Itruhin.entity.Variant3.CarProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    @Query(value = "SELECT CAST(id as varchar) id, modelname, color, platenumber from cars", nativeQuery = true)
    List<CarProjection> getAllCars();
}
