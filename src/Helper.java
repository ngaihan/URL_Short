import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;



public class Helper {
    public static final int SHORT_LENGTH = 12;
    public static final String POSSIBLE_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int POSSIBLE_CHARS_LEN = POSSIBLE_CHARS.length();

    private static HashMap<String, String> urlMap = new HashMap<>();

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1 to shorten URL\n2 to get long URL from short\nq to quit\n> ");
        String input = scanner.nextLine();
        String response;
        
        if (input.equals("1")) {
            System.out.print("Enter URL to shorten\n> ");
            input = scanner.nextLine();

            if (input.equals("q")) {
                scanner.close();
                return null;
            }

            String shortURL = generateShortURL();
            insertURL(shortURL, input);

            response = shortURL;
        }

        else if (input.equals("2")) {
            System.out.print("Enter long URL\n> ");
            input = scanner.nextLine();

            if (input.equals("q")) {
                scanner.close();
                return null;
            }

            response = getURL(input);
        }

        else if (input.equals("q")) {
            scanner.close();
            return null;
        }

        else {
            response = "Input not recognized\n";
        }

        scanner.close();

        return response;
    }

    public static String generateShortURL() {
        Random rand = new Random();
        StringBuilder newURLsb = new StringBuilder();
        Boolean isInHash = true;
        String newURL = null;

        while (isInHash) {
            isInHash = false;

            for (int i=0; i<SHORT_LENGTH; i++) {
                newURLsb.append(POSSIBLE_CHARS.charAt(rand.nextInt(POSSIBLE_CHARS_LEN)));
            }

            newURL = newURLsb.toString();

            if (urlMap.get(newURL) != null) isInHash = true;
        }

        if (newURL == null) {
            System.err.println("Error: generate short URL failed");
        }

        return newURL;
    }

    public static void insertURL(String shortURL, String longURL) {
        urlMap.put(shortURL, longURL);
    }

    public static String getURL(String shortURL) {
        String longURL = urlMap.get(shortURL);

        if (longURL == null) {
            System.err.println("Error: URL not found");
        }

        return longURL;
    }
}



