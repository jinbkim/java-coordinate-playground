package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private List<Car> cars;

    public RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();

        cars.forEach(car -> {
            double chargeQuantity = car.getChargeQuantity();
            stringBuilder.append(car.getName() + " : " + (int) chargeQuantity + "리터\n");
        });
        return stringBuilder.toString();
    }
}
