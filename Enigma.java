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
            if (chosenCipher.equals("4")) {
                String keyA = getChoice("Enter first key: ");
                String keyB = getChoice("Enter second key: ");
                String[] choices = {chosenOperation, chosenCipher, keyA, keyB};
                runCipher(choices);
            }
            else {
            String[] choices = {chosenOperation, chosenCipher};
            runCipher(choices);
            }
        }
    }

    public static void handleCLArguments(String[] args) {
        if (args[0].equalsIgnoreCase("-l"))
            printCiphers();
        else {
            try {
                runCipher(args);
            } catch (Exception e) {
                System.out.println("Invalid arguments");
            }
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

    public static void runCipher(String[] args) {
        switch (args[1]) {
            case "1":
                System.out.println(AtbashCipher.encrypt(getUserInput()));
                break;
            
            case "3":
                if (args[0].equals("-e"))
                    System.out.println(CaesarCipher.encrypt(getUserInput()));
                else
                    System.out.println(CaesarCipher.decrypt(getUserInput()));
                break;

            case "4":
                byte keyA = Byte.parseByte(args[2]);
                byte keyB = Byte.parseByte(args[3]);
                if (args[0].equals("-e"))
                    System.out.println(AffineCipher.encrypt(getUserInput(), keyA, keyB));
                else
                    System.out.println(AffineCipher.decrypt(getUserInput(), keyA, keyB));
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