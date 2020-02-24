import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Enigma
 */
public class Enigma {
    String[] cipherNames = {"Atbash Cipher", "ROT13 Cipher", "Caesar Cipher", "Affine Cipher", "Rail-fence Cipher", "Baconian Cipher"};

    public static void main(String[] args) {
        final Enigma enigma = new Enigma();
        enigma.printCiphers();
        int chosenCipher = enigma.getChoiceBetween("Choose your Cipher: ", 1, 6);
        int chosenOperation = enigma.getChoiceBetween("Choose 1 to encrypt, 2 to decrypt: ", 1, 2);
        runCipher(chosenCipher, chosenOperation);
    }

    public void printCiphers() {
        for (int i = 0; i < cipherNames.length; i++) {
            System.out.println((i + 1) + " " + cipherNames[i]);
        }
        System.out.println();
    }

    public int getChoiceBetween(String message, int min, int max) {
        System.out.print(message);

        Scanner input = new Scanner(System.in);
        int userChoice = -1;

        while (userChoice < min || userChoice > max) {
            try {
                userChoice = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Enter a number between " + min + " and " + max);
            }
        }
        return userChoice;
    }

    public static void runCipher(int cipher, int operation) {

        switch (cipher) {
            case 1:
                System.out.println(AtbashCipher.encrypt(getUserInput()));
                break;

            default:
                break;
        }
    }

    public static String getUserInput() {
        System.out.println("Enter your text");
        try (Scanner thirdInput = new Scanner(System.in)) {
            final String userInput = thirdInput.nextLine();
            return userInput;
        }
    }
}
