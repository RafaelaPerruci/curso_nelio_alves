import java.util.Locale;
import java.util.Scanner;

public class Hostel {
    private String guestName;
    private String emailGuest;
    private int roomNumber;

    public Hostel(String guestName, String emailGuest, int roomNumber) {
        this.guestName = guestName;
        this.emailGuest = emailGuest;
        this.roomNumber = roomNumber;
    }


    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getEmailGuest() {
        return emailGuest;
    }

    public void setEmailGuest(String emailGuest) {
        this.emailGuest = emailGuest;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Name: " + guestName  +
                ", Email: " + emailGuest  +
                ", Room Number: " + roomNumber;
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many rooms will be rented? ");
        int n = sc.nextInt();

        Hostel[] guests = new Hostel[10];

        for (int i=0; i < n; i++){
            System.out.printf("Rent #%d:%n", i+1);
            System.out.println("Name: ");
            String name = sc.next();
            sc.nextLine();
            System.out.println("Email: ");
            String email = sc.nextLine();
            System.out.println("Choose a room number [1-10]: ");
            int room = sc.nextInt();
            int arrayIndex = room - 1;
            guests[arrayIndex] = new Hostel(name, email, room);


        }
        System.out.println("Busy rooms: ");
        for (int i=0; i < guests.length; i++){
            if (guests[i] != null) {
                System.out.println();
                System.out.println(guests[i].toString());
            }
        }
    }
}
