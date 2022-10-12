package calculator.model;

public class K5 implements Car {

    private final String name = "K5";
    private final int distancePerLiter = 13;
    private int tripDistance;

    public K5(int tripDistance) {
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

//public class K5 extends Car {
//
//    private final String name = "K5";
//    private final int distancePerLiter = 13;
//    private int tripDistance;
//
//    public K5(int tripDistance) {
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
