package com.example.car.services;

public class CarNotFoundExcep extends RuntimeException {
    public CarNotFoundExcep(String message) {

        super(message);
    }
}