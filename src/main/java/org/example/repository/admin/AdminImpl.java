package org.example.repository.admin;

import lombok.RequiredArgsConstructor;
import org.example.dto.Car;
import org.example.entity.CarEntity;
import org.example.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AdminImpl implements AdminService{

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    @Override


    public CarEntity addCar(Car car) {
     CarEntity carEntity=modelMapper.map(car, CarEntity.class);
        return carRepository.save(carEntity);
    }
}
