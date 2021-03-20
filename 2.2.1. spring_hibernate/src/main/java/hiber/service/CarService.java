package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarService {
    List<Car> getCarsByUser(User user);
}
