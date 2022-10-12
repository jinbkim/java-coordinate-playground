package calculator.model;

public class Sonata implements Car {

    private final String name = "Sonata";
    private final int distancePerLiter = 10;
    private int tripDistance;

    public Sonata(int tripDistance) {
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

//public class Sonata extends Car {
//
//    private final String name = "Sonata";
//    private final int distancePerLiter = 10;
//    private int tripDistance;
//
//    public Sonata(int tripDistance) {
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
