import java.util.Scanner;

public class Tram {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberOfStops = scanner.nextInt();
        scanner.nextLine();
        final String[] passengers = new String[numberOfStops];
        for (int i = 0; i < numberOfStops; i++) {
            passengers[i] = scanner.nextLine();
        }
        int maxCapacity = 0;
        int totalPassengersAtTime = 0;
        for (int i = 0; i < numberOfStops; i++) {
            String[] passengerDetails = passengers[i].split(" ");
            int exit = Integer.parseInt(passengerDetails[0]);
            int enter = Integer.parseInt(passengerDetails[1]);
            totalPassengersAtTime = totalPassengersAtTime - exit + enter;
            if(totalPassengersAtTime > maxCapacity) {
                maxCapacity = totalPassengersAtTime;
            }
        }
        System.out.println(maxCapacity);
    }
}
