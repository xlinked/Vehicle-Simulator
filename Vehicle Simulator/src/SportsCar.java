public class SportsCar extends Vehicles {
    private String sportsCar;
    private boolean isDeadOnce;
    String type = "SPORTSCAR";

    public SportsCar(int x, int y, boolean isAlive) {
        super(x, y, isAlive);
    }

    public String getSportsCar() {
        return sportsCar;
    }

    public void setSportsCar(String sportsCar) {
        this.sportsCar = sportsCar;
    }

    public boolean isDeadOnce() {
        return isDeadOnce;
    }

    public void setDeadOnce(boolean deadOnce) {
        isDeadOnce = deadOnce;
    }

    @Override
    public void Move(int turn) {
        if (turn % 5 == 0) {

        }
        else if (turn % 3 == 0) {
            super.setX_val(super.getX_val() + 3);
            super.setY_val(super.getY_val() + 3);
        }
        else {
            super.setX_val(super.getX_val() - 3);
            super.setY_val(super.getY_val() - 3);
        }
        super.Move(turn);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
/*
    Inherits from a Vehicle class. Properties: type (string)
Constructor calling the super constructor and initializing the properties and setting the type to “SPORTSCAR”
Move method overrides the Move method from the Vehicle class. SportsCar is allowed one more life
Move method:
a) Move method for SportsCar is allowed 3 increment/decrements.
b) Abstract value for movement always has to be 3 and has to move freely.
For example: (0,0) - > (2, -1) (2, -1) - > (5, -1) (5, -1) - > (4, -3)
toString method overriding from the vehicle class.
     */

