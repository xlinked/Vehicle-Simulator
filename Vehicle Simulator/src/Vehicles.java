public abstract class Vehicles {
    private int x_val, y_val;
    boolean isAlive;

    //Constructor.
    public Vehicles(int X, int Y, boolean Alive) {
        x_val = X;
        y_val = Y;
        isAlive = Alive;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "x_val=" + x_val +
                ", y_val=" + y_val +
                ", alive=" + isAlive +
                '}';
    }

    public void Move(int turn) {
        if (isAlive == true || (turn % 3 == 0)) {
            this.setY_val(this.y_val + 1);
            this.setX_val(this.x_val + 1);
        }
        else {
            this.setX_val(this.x_val - 1);
            this.setY_val(this.y_val - 1);
        }
    }

    public int getX_val() {
        return x_val;
    }

    public void setX_val(int x_val) {
        this.x_val = x_val;
    }

    public int getY_val() {
        return y_val;
    }

    public void setY_val(int y_val) {
        this.y_val = y_val;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setisAlive(boolean Alive) {
        this.isAlive = Alive;
    }
}

/*
    Vehicle abstract class
    Superclass for all vehicles.
    Properties: X coordinate (int), Y coordinate (int), alive (Boolean)
    Constructor to initialize all properties.
    Move Method :
    a) Called for all alive vehicles each turn
    b) Increments or decrements either x or y coordinates by 1.
    Any type of vehicle should throw an exception
    if the move method is invoked even when the vehicle is dead.

    toString method should be provided.

 */
