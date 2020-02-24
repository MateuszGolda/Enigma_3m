import java.util.ArrayList;

/* to encrypt
i to decrypt zamienic na
pzrekazany input*/
public class CaesarCipher {
    public static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String toEncrypt) {
        ArrayList<String> encrypted = new ArrayList<>();
        for (int i = 0; i < toEncrypt.length(); i++) {
            String letter = toEncrypt.substring(i, i + 1);
            if (letter.equals("a")) {
                encrypted.add("z");
            } else if (letter.equals("A")) {
                encrypted.add("Z");
            } else if (letter.equals("z")) {
                encrypted.add("a");
            } else if (letter.equals("Z")) {
                encrypted.add("A");
            } else if (alphabet.contains(letter)) {
                int letterIndex = alphabet.indexOf(letter);
                encrypted.add(alphabet.substring(letterIndex + 1, letterIndex + 2));
            } else if (!alphabet.contains(letter)) {
                encrypted.add(toEncrypt.substring(i, i + 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : encrypted)
            sb.append(s);
        return sb.toString();
    }

    public static String decrypt(String toDecrypt) {
        ArrayList<String> decrypted = new ArrayList<>();
        for (int i = 0; i < toDecrypt.length(); i++) {
            String decryptLetter = toDecrypt.substring(i, i + 1);
            if (decryptLetter.equals("a")) {
                decrypted.add("z");
            } else if (decryptLetter.equals("A")) {
                decrypted.add("Z");
            } else if (decryptLetter.equals("z")) {
                decrypted.add("a");
            } else if (decryptLetter.equals("Z")) {
                decrypted.add("A");
            } else if (alphabet.contains(decryptLetter)) {
                int letter2Index = alphabet.indexOf(decryptLetter);
                decrypted.add(alphabet.substring(letter2Index - 1, letter2Index));
            } else if (!alphabet.contains(decryptLetter)) {
                decrypted.add(toDecrypt.substring(i, i + 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : decrypted)
            sb.append(s);
        return sb.toString();
    }
}
