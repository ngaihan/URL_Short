public class App {
    public static void main(String[] args) {
        String userInput;
        userInput = Helper.getUserInput();
            
        while (userInput != null) {
            String shortURL;
            shortURL = Helper.generateShortURL();
            
            Helper.insertURL(shortURL, userInput);

            userInput = Helper.getUserInput();
        }
    }
}

