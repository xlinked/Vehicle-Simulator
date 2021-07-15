import java.util.ArrayList;

public class Field {

    public ArrayList<Car> createInitialCarsPosition() {
        ArrayList<Car> carList = new ArrayList<Car>();
        int max_len = VSMain.quadrant_Length;
        for (int l = 1; l <= VSMain.numberOfEachVehicleType; l++) {

            int x_val = (int) (Math.random() * (max_len + 1));
            int y_val = (int) (Math.random() * (max_len + 1));
            Car car = new Car(x_val, y_val, true);
            car.setCarName("CAR " + l);
            carList.add(car);
        }
        return carList;
    }

    public ArrayList<Truck> createInitialTrucksPosition() {
        ArrayList<Truck> truckList = new ArrayList<Truck>();
        int max_len = VSMain.quadrant_Length;
        for (int l = 1; l <= VSMain.numberOfEachVehicleType; l++) {

            int x_val = -(int) (Math.random() * (max_len + 1));
            int y_val = (int) (Math.random() * (max_len + 1));
            Truck truck = new Truck(x_val, y_val, true);
            truck.setTruck("TRUCK " + l);
            truckList.add(truck);
        }
        return truckList;
    }

    public ArrayList<SportsCar> createInitialSportsCarsPosition() {

        ArrayList<SportsCar> sportsCarList = new ArrayList<SportsCar>();
        int max_len = VSMain.quadrant_Length;
        for (int l = 1; l <= VSMain.numberOfEachVehicleType; l++) {

            int x = -(int) (Math.random() * (max_len + 1));
            int y = -(int) (Math.random() * (max_len + 1));
            SportsCar spCar = new SportsCar(x, y, true);
            spCar.setSportsCar("SPORTSCAR  " + l);
            sportsCarList.add(spCar);
        }
        return sportsCarList;
    }

    public ArrayList<Tractor> createInitialTractorsPosition() {
        ArrayList<Tractor> tractorList = new ArrayList<Tractor>();
        int max_len = VSMain.quadrant_Length;
        for (int l = 1; l <= VSMain.numberOfEachVehicleType; l++) {

            int x = (int) (Math.random() * (max_len + 1));
            int y = (int) (Math.random() * (max_len + 1));
            Tractor tractor = new Tractor(x, y, true);
            tractor.setTractor("TRACTOR  " + l);
            tractorList.add(tractor);
        }
        return tractorList;
    }

}


    /*
Properties:
4 vertex of the field (array of ints [quadrant number][x, y coordinates (store this value in whichever form you want)])
Array of vehicles

Constructor:
a) Takes a parameter to determine the length of the quadrant which is always a right triangle.
b) Takes parameters for how many of each vehicles are to be populated. At least 4 of each vehicle types has to be populated. (Since the result is to sort out the top 3 longest survivors.
c) Populating the vehicles, each vehicles are positioned to random positions within a field.
d) Populated vehicles are stored in the array of vehicle class. (Using ArrayList is also possible.)
When a vehicle steps outside of the field, field class should ‘kill’ the vehicle. You are free to make extra methods that does not violate the guideline.


     */

