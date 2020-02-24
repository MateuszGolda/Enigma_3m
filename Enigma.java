import java.util.Scanner;
/**
 * Enigma
 */
public class Enigma {
    String[] CiphersToChoose = {"Atbash Cipher", "ROT13 Cipher", "Caesar Cipher", "Affine Cipher", "Rail-fence Cipher", "Baconian Cipher"};
    public void printingCiphers(){
        for (int i = 0; i < CiphersToChoose.length; i++){
            System.out.println((i + 1) + " " + CiphersToChoose[i]);}
    }
    public void ChooseCipher(){
        System.out.println("Choose your Cipher:");
        try (Scanner input = new Scanner(System.in)){
            final String userChoice = input.next();
            if (userChoice.equals("1")) {System.out.println("a");}
            else if (userChoice.equals("2")) {ChooseCrypting();}
            else if (userChoice.equals("3")) {ChooseCrypting();}
            else if (userChoice.equals("4")) {ChooseCrypting();}
            else if (userChoice.equals("5")) {ChooseCrypting();}
            else if (userChoice.equals("6")) {ChooseCrypting();}
            else {ChooseCipher();}
    }
    }
    public void ChooseCrypting() {
        System.out.println("To encrypt choose 1, to decrypt choose 2");
        System.out.println("Enter your choice");
        try (Scanner secondInput = new Scanner(System.in)) {
            final String userChoice = secondInput.next();
            if (userChoice.equals("1")) {AtbashCipher.decrypt(TextToGive());}
            else if (userChoice.equals("2")) {AtbashCipher.encrypt(TextToGive());}
            else {ChooseCrypting();}
        }
    }
    
    public String TextToGive() {
        System.out.println("Enter your text");
        try (Scanner thirdInput = new Scanner(System.in)) {
            final String userInput = thirdInput.next();
            return userInput;
        }  
    } 

    
    public void printDecrypted() {
        System.out.println(AtbashCipher.decrypt(TextToGive()));
    }
    public void printEncrypted() {
        System.out.println(AtbashCipher.Encrypt(TextToGive()));
    }
    public static void main(String[] args) {
        final Enigma enigma = new Enigma();
        enigma.printingCiphers();
        enigma.ChooseCipher();
        enigma.printDecrypted();
        enigma.printEncrypted();
    }
}
