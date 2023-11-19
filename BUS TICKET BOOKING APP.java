import java.util.*;

interface ticket {
    void booking();

    void display();
}

class busticket {
    Scanner input = new Scanner(System.in);
    int tarr[] = new int[30];
    String name, gender;
    int num, count = 0, sno, ch;

    void input() {
        System.out.print("Enter Name: ");
        name = input.nextLine();
        System.out.print("Enter Gender: ");
        gender = input.nextLine();
        System.out.print("Enter the number of persons: ");
        num = input.nextInt();
    }

    void display() {
        for (int i = 0; i < 30; i++) {
            if (tarr[i] == 0) {
                count++;
            }
        }
        System.out.println("No. of Seats Available: " + count);
        if ((gender.equalsIgnoreCase("female")) && (num == 1)) {
            System.out.println("Seat no.s available for single female passenger: 3,6,9,12,15,18,21,24,27,30");
        }
        System.out.println("Seats Arrangement: ");
        for (int i = 1; i <= 30; i++) {
            if ((i >= 3) && (i % 3 == 0)) {
                System.out.println("        " + i);
            } else {
                System.out.print(i + " ");
            }
        }
    }

    void booking() {
        int f = 0;
        int arr[] = new int[30];
        for (int i = 0; i < num; i++) {
            int a = i;
            System.out.print("Enter the seat" + (a + 1) + ":");
            sno = input.nextInt();
            if ((gender.equalsIgnoreCase("female")) && (num == 1) && (sno % 2 == 0)) {
                f = 1;
                System.out.println("You can only select seats reserved for female passengers!");
                break;
            }
            if (tarr[sno] == 1) {
                f = 1;
                System.out.println("Seat already Booked");
                break;
            }
            arr[sno] = 1;
            tarr[sno] = 1;
        }
        if (f == 0) {
            System.out.println("-----------------------YOUR SEATS BOOKED SUCCESSFULLY------------------------");
            System.out.println("NAME: " + name);
            System.out.println("GENDER: " + gender);
            System.out.print("Booked Seat no.: ");
            for (int i = 1; i < 30; i++) {
                if (arr[i] == 1) {
                    System.out.print(i + "  ");
                }
            }
        }
        System.out.println("");
        System.out.print("Do you want to continue? (0/1): ");
        ch = input.nextInt();
        input.nextLine();

    }
}

class interfaces {
    public static void main(String[] args) {
        busticket obj = new busticket();
        do {
            obj.input();
            obj.display();
            obj.booking();
        } while (obj.ch == 1);
    }
}