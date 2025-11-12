import java.util.Scanner;

public class LoginForm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Hardcoded username and password for demo purposes
        String correctUsername = "admin";
        String correctPassword = "1234";

        System.out.println("=== Login Form ===");
        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Login successful! Welcome, " + username + ".");
        } else {
            System.out.println("Login failed! Invalid credentials.");
        }

        sc.close();
    }
}


import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    String date; // format: YYYY-MM-DD

    public Task(String title, String date) {
        this.title = title;
        this.date = date;
    }

    @Override
    public String toString() {
        return date + " - " + title;
    }
}

public class ScheduleManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Scheduling Management System ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter task date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    tasks.add(new Task(title, date));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Scheduled Tasks ---");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks scheduled.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to remove: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    if (num > 0 && num <= tasks.size()) {
                        tasks.remove(num - 1);
                        System.out.println("Task removed successfully!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}
