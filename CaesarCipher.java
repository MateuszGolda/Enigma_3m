public class CaesarCipher {
    public static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String toEncrypt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < toEncrypt.length(); i++) {
            String letter = toEncrypt.substring(i, i + 1);
            if (letter.equals("a")) {
                sb.append("b");
            } else if (letter.equals("A")) {
                sb.append("B");
            } else if (letter.equals("z")) {
                sb.append("a");
            } else if (letter.equals("Z")) {
                sb.append("A");
            } else if (alphabet.contains(letter)) {
                int letterIndex = alphabet.indexOf(letter);
                sb.append(alphabet.substring(letterIndex + 1, letterIndex + 2));
            } else if (!alphabet.contains(letter)) {
                sb.append(toEncrypt.substring(i, i + 1));
            }
        }
        return sb.toString();
    }

    public static String decrypt(String toDecrypt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < toDecrypt.length(); i++) {
            String decryptLetter = toDecrypt.substring(i, i + 1);
            if (decryptLetter.equals("a")) {
                sb.append("z");
            } else if (decryptLetter.equals("A")) {
                sb.append("Z");
            } else if (decryptLetter.equals("z")) {
                sb.append("y");
            } else if (decryptLetter.equals("Z")) {
                sb.append("Y");
            } else if (alphabet.contains(decryptLetter)) {
                int letter2Index = alphabet.indexOf(decryptLetter);
                sb.append(alphabet.substring(letter2Index - 1, letter2Index));
            } else if (!alphabet.contains(decryptLetter)) {
                sb.append(toDecrypt.substring(i, i + 1));
            }
        }
        return sb.toString();
    }
}