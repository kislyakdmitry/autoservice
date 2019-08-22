package autoservice.app.services.impl;

import autoservice.app.exceptions.CarNotFoundException;
import autoservice.app.services.CarsService;
import autoservice.app.domain.Car;
import autoservice.app.repositories.CarsRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CarsServiceImpl implements CarsService {

    private CarsRepo carsRepo;

    public List<Car> getAllCars() {
        return (List<Car>) carsRepo.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carsRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car " + id + " not found"));
    }
}
