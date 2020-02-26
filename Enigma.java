import java.util.Scanner;

/**
 * Enigma
 */
public class Enigma {
    public static String[] cipherNames = { "Atbash Cipher", "ROT13 Cipher", "Caesar Cipher",
             "Affine Cipher", "Rail-fence Cipher", "Baconian Cipher" };

    public static void main(String[] args) {
        if (args.length != 0)
        handleCLArguments(args);
        else {
        printCiphers();
        String chosenCipher = getChoice("Choose your Cipher: ");
        String chosenOperation = getChoice("Enter -e to encrypt, -d to decrypt: ");
        runCipher(chosenCipher, chosenOperation);
        }
    }

    public static void handleCLArguments(String[] args) {
        switch (args[0]) {
            case "-l":
                printCiphers();
                break;

            case "-e":
                
                break;

            case "-d":
                
                break;

            default:
                break;
        }
    }

    public static void printCiphers() {
        for (byte i = 0; i < cipherNames.length; i++) {
            System.out.println((i + 1) + " " + cipherNames[i]);
        }
        System.out.println();
    }

    public static String getChoice(String message) {
        System.out.print(message);
        Scanner input = new Scanner(System.in);
        String userChoice = input.nextLine();
        return userChoice;
    }

    public static void runCipher(String cipher, String operation) {
        switch (cipher) {
            case "1":
                System.out.println(AtbashCipher.encrypt(getUserInput()));
                break;
            
            case "3":
                if (operation.equals("-e"))
                    System.out.println(CaesarCipher.encrypt(getUserInput()));
                else
                    System.out.println(CaesarCipher.decrypt(getUserInput()));
                break;

            case "4":
                if (operation.equals("-e"))
                    System.out.println(AffineCipher.encrypt(getUserInput(), (byte) 5, (byte) 9));
                else
                    System.out.println(AffineCipher.decrypt(getUserInput(), 5, 9));
                break;

            default:
                break;
        }
    }

    public static String getUserInput() {
        System.out.println("Enter your text");
        try (Scanner thirdInput = new Scanner(System.in)) {
            String userInput = thirdInput.nextLine();
            return userInput;
        }
    }
}