public class Car extends Vehicles {
    String type = "CAR";
    private String carName;

    public Car(int x, int y, boolean isAlive) {
        super(x, y, isAlive);
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return null;
    }
}

    /*
    Inherits from a vehicle. Properties: type (string)
    Constructor calling the super constructor and initializing the properties
    and setting the type to “CAR”.

    Move method inherited from the vehicle class.

    toString method overriding from the vehicle class.

     */

