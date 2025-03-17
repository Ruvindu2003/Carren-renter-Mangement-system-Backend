package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Car;
import org.example.entity.CarEntity;
import org.example.repository.admin.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
@CrossOrigin


public class AdminController {
    private final AdminService adminService;

    @PostMapping("/car")
    public ResponseEntity<?> addCar(@ModelAttribute Car car){
    CarEntity saveCar =   adminService.addCar(car);
        if (saveCar==null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }


    }
}
