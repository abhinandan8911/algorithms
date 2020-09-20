import java.util.Scanner;

public class Accomodation {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String numberOfRooms = scanner.nextLine();
        int rooms = Integer.parseInt(numberOfRooms);
        int possibleRooms = 0;
        for (int i = 0; i < rooms; i++) {
            String roomDetails = scanner.nextLine();
            String[] pq = roomDetails.split(" ");
            int personStaying = Integer.parseInt(pq[0]);
            int capacity = Integer.parseInt(pq[1]);
            if(capacity - personStaying >= 2) {
                ++possibleRooms;
            }
        }
        System.out.println(possibleRooms);
    }
}
