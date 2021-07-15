public class Truck extends Vehicles {
    private String truck;
    String type = "TRUCK";

    public Truck(int x, int y, boolean isAlive) {
        super(x, y, isAlive);
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    @Override
    public void Move(int turn) {
        if (turn % 5 == 0) {

        } else if (turn % 2 == 0) {
            super.setX_val(super.getX_val() + 2);
            super.setY_val(super.getY_val() + 2);
        } else {
            super.setX_val(super.getX_val() - 2);
            super.setY_val(super.getY_val() - 2);
        }
        super.Move(turn);
    }
}

    /*
    Inherits from a vehicle class. Properties: type (string)
Constructor calling the super constructor and initializing the properties and setting the type to “TRUCK”
Move method overrides the Move method in the Vehicle class. Move method:
a) Move method for truck is allowed 2 increment/decrements.
b) Either x or y can increment/decrement, by 2.
c) Both x and y can increment/decrement by 2.
d) Probability for b and c happening should be 50:50
     */

