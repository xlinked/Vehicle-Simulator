import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Simulator {

    //int noOfTurns = 20;

    Field field = new Field();

    private boolean isTurnOn = false;
    private int turn= 1;

    public void run() {

        // create initial carlist
        ArrayList<Car> carInitialList = field.createInitialCarsPosition();
        ArrayList<Truck> TruckInitialList = field.createInitialTrucksPosition();
        //;
        ArrayList<SportsCar> sportsCarInitialList = field.createInitialSportsCarsPosition();
        ArrayList<Tractor> tractorInitialList = field.createInitialTractorsPosition();

        List<Result> carStack= new Stack<>();
        List<Result> truckStack= new Stack<>();
        List<Result> spStack= new Stack<>();
        List<Result> tractorStack= new Stack<>();

        //for (int turn = 1; turn <= noOfTurns; turn++) {
        long currentTime= System.currentTimeMillis();
        while(true) {

            StringBuffer strbBuffer = new StringBuffer();// to print
            strbBuffer.append("\"TURN " + turn + ": ");
            //++turn;
            isTurnOn =false;
            Simulator sim = new Simulator();
            // move each Car
            for (int c = 0; c < VSMain.numberOfEachVehicleType; c++) {
                Car cr = carInitialList.get(c);
                if (cr.isAlive) {
                    isTurnOn =true;
                    cr = sim.moveAcar(cr, turn);

                    carStack.add(new Result(cr.getCarName(),turn));
                    if (!cr.isAlive) {
                        strbBuffer.append(cr.getCarName() + " (DEAD) ,");
                    } else
                        strbBuffer.append(cr.getCarName() + " (" + cr.getX_val() + "," + cr.getY_val() + ") , ");

                    carInitialList.set(c, cr);
                }

            }

            // move each Truck

            for (int t = 0; t < VSMain.numberOfEachVehicleType; t++) {

                Truck truck = TruckInitialList.get(t);
                if (truck.isAlive) {
                    isTurnOn =true;
                    truck = sim.moveATruck(truck, turn);
                    truckStack.add(new Result(truck.getTruck(),turn));
                    if (!truck.isAlive) {
                        strbBuffer.append(truck.getTruck() + " (DEAD) ,");
                    } else
                        strbBuffer.append(
                                truck.getTruck() + " (" + truck.getX_val() + "," + truck.getY_val() + ") , ");
                    TruckInitialList.set(t, truck);

                }
            }

            // move a sports car

            for (int sp = 0; sp < VSMain.numberOfEachVehicleType; sp++) {
                SportsCar spCar = sportsCarInitialList.get(sp);
                if (spCar.isAlive) {
                    isTurnOn =true;
                    spStack.add(new Result(spCar.getSportsCar(),turn));
                    spCar = sim.moveASportsCar(spCar, turn);
                    if (!spCar.isAlive) {
                        strbBuffer.append(spCar.getSportsCar() + " (DEAD) ,");
                    } else
                        strbBuffer.append(
                                spCar.getSportsCar() + " (" + spCar.getX_val() + "," + spCar.getY_val() + ") , ");
                    sportsCarInitialList.set(sp, spCar);

                }
            }

            // move of tractors
            for (int tr = 0; tr < VSMain.numberOfEachVehicleType; tr++) {
                Tractor tractor = tractorInitialList.get(tr);
                if (tractor.isAlive) {
                    isTurnOn =true;
                    tractorStack.add(new Result(tractor.getTractor(),turn));
                    tractor = sim.moveATractor(tractor, turn);
                    if (!tractor.isAlive) {
                        strbBuffer.append(tractor.getTractor() + " (DEAD) ,");
                    } else
                        strbBuffer.append(tractor.getTractor() + " (" + tractor.getX_val() + ","
                                + tractor.getY_val() + ") , ");
                    tractorInitialList.set(tr, tractor);

                }
            }

            System.out.println(strbBuffer.toString() + "\"");
            if(!isTurnOn) {
                break;
            }else
                turn++;
        } // end of While

        System.out.println(" .......... Simulation Terminated in  "+turn+" Turns .........");
        long simulationEndTime= System.currentTimeMillis();
        System.out.println("\"“Simulation took total "+(simulationEndTime-currentTime)+" miliseconds until all vehicles are terminated.”/");
        int stacksize = carStack.size();
        ArrayList<String> carTop3Rest=new ArrayList<>();

        System.out.println("     Top 3 CARS ");
        for(int i=stacksize-1;i>= 0;i--) {
            if(carTop3Rest.size() >=3 ) {
                break;
            }
            else if(carTop3Rest.size() ==0 ) {
                carTop3Rest.add(carStack.get(i).getvName());
                System.out.println("	1.  "+carStack.get(i).getvName() + " survived " +carStack.get(i).getTurns()+ " Turns  ");
            }else {
                String carName=carStack.get(i).getvName();
                if(!carTop3Rest.contains(carName)) {
                    carTop3Rest.add(carStack.get(i).getvName());
                    System.out.println("	"+carTop3Rest.size()+".  "+carStack.get(i).getvName() + " survived " +carStack.get(i).getTurns()+ " Turns  ");
                }
            }

        }// for for Car

        int tstacksize = truckStack.size();
        ArrayList<String> trTop3Rest=new ArrayList<>();

        System.out.println("     Top 3 TRUCKS ");
        for(int i=tstacksize-1;i>= 0;i--) {
            if(trTop3Rest.size() >=3 ) {
                break;
            }
            else if(trTop3Rest.size() ==0 ) {
                trTop3Rest.add(truckStack.get(i).getvName());
                System.out.println("	1.  "+truckStack.get(i).getvName() + " survived " +truckStack.get(i).getTurns()+ " Turns  ");
            }else {
                String truckName=truckStack.get(i).getvName();
                if(!trTop3Rest.contains(truckName)) {
                    trTop3Rest.add(truckStack.get(i).getvName());
                    System.out.println("	"+trTop3Rest.size()+".  "+truckStack.get(i).getvName() + " survived " +truckStack.get(i).getTurns()+ " Turns  ");
                }
            }

        }//eof Truck

        int spstacksize = spStack.size();
        ArrayList<String> spTop3Rest=new ArrayList<>();

        System.out.println("     Top 3 SPORTSCAR ");
        for(int i=spstacksize-1;i>= 0;i--) {
            if(spTop3Rest.size() >=3 ) {
                break;
            }
            else if(spTop3Rest.size() ==0 ) {
                spTop3Rest.add(spStack.get(i).getvName());
                System.out.println("	1.  "+spStack.get(i).getvName() + " survived " +spStack.get(i).getTurns()+ " Turns  ");
            }else {
                String spName=spStack.get(i).getvName();
                if(!spTop3Rest.contains(spName)) {
                    spTop3Rest.add(spStack.get(i).getvName());
                    System.out.println("	"+spTop3Rest.size()+".  "+spStack.get(i).getvName() + " survived " +spStack.get(i).getTurns()+ " Turns  ");
                }
            }

        }//eof Spcar

        int tractorstacksize = tractorStack.size();
        ArrayList<String> tractorTop3Rest=new ArrayList<>();

        System.out.println("     Top 3 TRACTOR ");
        for(int i=tractorstacksize-1;i>= 0;i--) {
            if(tractorTop3Rest.size() >=3 ) {
                break;
            }
            else if(tractorTop3Rest.size() ==0 ) {
                tractorTop3Rest.add(tractorStack.get(i).getvName());
                System.out.println("	1.  "+tractorStack.get(i).getvName() + " survived " +tractorStack.get(i).getTurns()+ " Turns  ");
            }else {
                String tractorName=tractorStack.get(i).getvName();
                if(!tractorTop3Rest.contains(tractorName)) {
                    tractorTop3Rest.add(tractorStack.get(i).getvName());
                    System.out.println("	"+tractorTop3Rest.size()+".  "+tractorStack.get(i).getvName() + " survived " +tractorStack.get(i).getTurns()+ " Turns  ");
                }
            }

        }// eof of Tractor

    }

    // move the car
    public Car moveAcar(Car car, int turn) {
        Simulator sim = new Simulator();
        car.Move(turn);
        boolean status = sim.checkForDistance(car.getX_val(), car.getY_val());
        if (!status) {
            car.setisAlive(false);
        } else
            car.setisAlive(true);
        return car;
    }

    // move a truck
    public Truck moveATruck(Truck truck, int turn) {
        Simulator sim = new Simulator();
        truck.Move(turn);
        boolean status = sim.checkForDistance(truck.getX_val(), truck.getY_val());
        // System.out.println(status);
        if (!status) {
            truck.setisAlive(false);
        } else
            truck.setisAlive(true);
        return truck;
    }

    // move a sports Car
    public SportsCar moveASportsCar(SportsCar spCar, int turn) {
        Simulator sim = new Simulator();
        spCar.Move(turn);
        boolean status = sim.checkForDistance(spCar.getX_val(), spCar.getY_val());
        if (!status) {
            if (!spCar.isDeadOnce()) {
                spCar.setisAlive(true);
                spCar.setDeadOnce(true);
            }
            spCar.setisAlive(false);
        } else
            spCar.setisAlive(true);
        return spCar;
    }

    // move a Tractor
    public Tractor moveATractor(Tractor tractor, int turn) {
        Simulator sim = new Simulator();
        tractor.Move(turn);
        boolean status = sim.checkForDistance(tractor.getX_val(), tractor.getY_val());
        if (!status) {
            tractor.setisAlive(false);
        } else
            tractor.setisAlive(true);
        return tractor;
    }

    //Check distance between two points and return if its more than the actual length
    public boolean checkForDistance(int x, int y) {

        // int distance = (int) Math.abs(Math.sqrt((x ^ 2) + (y ^ 2)));
        int distance = (int) Math.sqrt(x * x + y * y);

        if (distance <= VSMain.quadrant_Length) {
            return true;

        }
        return false;

    }

}
