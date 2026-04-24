import java.util.*;

class Ticket {
    int id;
    String title;
    String status;

    Ticket(int id, String title) {
        this.id = id;
        this.title = title;
        this.status = "Open";
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Status: " + status;
    }
}

public class TicketSystem {

    static List<Ticket> tickets = new ArrayList<>();
    static int idCounter = 1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\n===== TICKET SYSTEM =====");
            System.out.println("1. Create Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Update Ticket");
            System.out.println("4. Delete Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // CREATE
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    tickets.add(new Ticket(idCounter++, title));
                    System.out.println("✅ Ticket Created Successfully!");
                    break;

                // VIEW
                case 2:
                    if (tickets.isEmpty()) {
                        System.out.println("⚠ No tickets available!");
                    } else {
                        for (Ticket t : tickets) {
                            System.out.println(t);
                        }
                    }
                    break;

                // UPDATE
                case 3:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean foundUpdate = false;

                    for (Ticket t : tickets) {
                        if (t.id == id) {
                            System.out.print("Enter new status (Open/In Progress/Closed): ");
                            t.status = sc.nextLine();
                            System.out.println("✅ Ticket Updated!");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("❌ Ticket not found!");
                    }
                    break;

                // DELETE
                case 4:
                    System.out.print("Enter Ticket ID: ");
                    int delId = sc.nextInt();

                    boolean removed = tickets.removeIf(t -> t.id == delId);

                    if (removed) {
                        System.out.println("🗑 Ticket Deleted!");
                    } else {
                        System.out.println("❌ Ticket not found!");
                    }
                    break;

                // EXIT
                case 5:
                    running = false;
                    System.out.println("👋 Exiting System...");
                    break;

                default:
                    System.out.println("⚠ Invalid Choice!");
            }
        }

        sc.close();
    }
}