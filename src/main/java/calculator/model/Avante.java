package calculator.model;

public class Avante implements Car {

    private final String name = "Avante";
    private final int distancePerLiter = 15;
    private int tripDistance;

    public Avante(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    public double getDistancePerLiter() {
        return distancePerLiter;
    }

    public double getTripDistance() {
        return tripDistance;
    }

    public String getName() {
        return name;
    }

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}

//public class Avante extends Car {
//
//    private final String name = "Avante";
//    private final int distancePerLiter = 15;
//    private int tripDistance;
//
//    public Avante(int tripDistance) {
//        this.tripDistance = tripDistance;
//    }
//
//    @Override
//    double getDistancePerLiter() {
//        return distancePerLiter;
//    }
//
//    @Override
//    double getTripDistance() {
//        return tripDistance;
//    }
//
//    @Override
//    String getName() {
//        return name;
//    }
//
//    @Override
//    double getChargeQuantity() {
//        return super.getChargeQuantity();
//    }
//}
