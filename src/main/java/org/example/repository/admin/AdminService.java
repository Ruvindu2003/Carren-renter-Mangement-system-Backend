package org.example.repository.admin;

import org.example.dto.Car;
import org.example.entity.CarEntity;

public interface AdminService {

    CarEntity addCar(Car car);
}
