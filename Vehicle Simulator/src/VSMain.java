import java.util.Scanner;

public class VSMain {

    static int quadrant_Length;
    static int numberOfVehicle;
    static int numberOfEachVehicleType;

    public static void main(String[] args) {
        VSMain vsmain = new VSMain();
        vsmain.InputValue();
        Simulator simulator = new Simulator();
        simulator.run();
    }

    public static void InputValue() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the length of each quadrant: ");
        quadrant_Length = scan.nextInt();
        System.out.print("Enter the number of vehicles: ");
        numberOfVehicle = scan.nextInt();
        System.out.print("Number of each vehicle: ");
        numberOfEachVehicleType = scan.nextInt();
    }
}

