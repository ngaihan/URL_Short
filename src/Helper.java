import java.util.Scanner;

public class Helper {
    public static String get_user_input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String input = scanner.nextLine();
        scanner.close();

        return input;
    }
}
