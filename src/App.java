import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String response;
        Scanner scanner = new Scanner(System.in);
            
        do {
            response = Helper.handleInput(scanner);
            System.out.println(response);
        } while (!response.equals("exit"));

        scanner.close();

        System.out.println("Application exitted gracefully");
    }
}

