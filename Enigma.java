import java.util.Scanner;
/**
 * Enigma
 */
public class Enigma {
    String[] cipherNames = {"Atbash Cipher", "ROT13 Cipher", "Caesar Cipher", "Affine Cipher", "Rail-fence Cipher", "Baconian Cipher"};

    public static void main(String[] args) {
        final Enigma enigma = new Enigma();
        enigma.printCiphers();
        enigma.chooseCipher();
    }

    public void printCiphers() {
        for (int i = 0; i < cipherNames.length; i++) {
            System.out.println((i + 1) + " " + cipherNames[i]);
        }
    }

    public void chooseCipher() {
        System.out.println("Choose your Cipher:");
        try (Scanner input = new Scanner(System.in)){
            final String userChoice = input.next();
            if (userChoice.equals("1")) {chooseCrypting();}
            else if (userChoice.equals("2")) {chooseCrypting();}
            else if (userChoice.equals("3")) {chooseCrypting();}
            else if (userChoice.equals("4")) {chooseCrypting();}
            else if (userChoice.equals("5")) {chooseCrypting();}
            else if (userChoice.equals("6")) {chooseCrypting();}
            else {chooseCipher();}
        }
    }

    public void chooseCrypting() {
        System.out.println("To encrypt choose 1, to decrypt choose 2");
        System.out.println("Enter your choice");
        try (Scanner secondInput = new Scanner(System.in)) {
            final String userChoice = secondInput.next();
            if (userChoice.equals("1")) {System.out.println(AtbashCipher.decrypt(getUserInput()));}
            else if (userChoice.equals("2")) {System.out.println(AtbashCipher.encrypt(getUserInput()));}
            else {chooseCrypting();}
        }
    }

    public String getUserInput() {
        System.out.println("Enter your text");
        try (Scanner thirdInput = new Scanner(System.in)) {
            final String userInput = thirdInput.nextLine();
            return userInput;
        }
    }
}
