public class Tractor extends Vehicles{
    private String tractor;
    String type = "TRACTOR";

    public Tractor(int x, int y, boolean isAlive) {
        super(x, y, isAlive);
    }

    public String getTractor() {
        return tractor;
    }

    public void setTractor(String tractor) {
        this.tractor = tractor;
    }

    @Override
    public void Move(int turn) {
        if (turn % 5 == 0) {
        }
        else if (turn % 2 == 0) {
            super.setX_val(super.getX_val() + 2);
            super.setY_val(super.getY_val() + 2);
        }
        else {
            super.setX_val(super.getX_val() - 2);
            super.setY_val(super.getY_val() - 2);
        }
        super.Move(turn);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /*
    Inherits from a Vehicle class. Properties: type (string)
Constructor calling the super constructor and initializing the properties and setting the type to “TRACTOR”
Move method overrides the Move method from the Vehicle class. Move method:
a) Move method for Tractor is allowed 2 increment/decrements.
b) Abstract value for movement always has to be 2 and has to move freely.
For example: (0,0) - > (2, 0) (2, 0) - > (3, 1) (3, 1) - > (2, 2)
c) Not move at all.
d) Probability of b and c happening should be 50:50
toString method overriding from the vehicle class.

     */
}
