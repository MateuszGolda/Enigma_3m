/**
 * AtbashCipher
 */
public class AtbashCipher {

    public static String encrypt(String decrypted) {
        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String zyx = "zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA";
        String encrypted = "";

        for (int i = 0; i < decrypted.length(); i++) {
            String charr = String.valueOf(decrypted.charAt(i));
            encrypted += abc.indexOf(charr) > -1 ? zyx.charAt(abc.indexOf(charr)) : charr;
        }
        return encrypted;
    }

    public static String decrypt(String encrypted) {
        String decrypted = encrypt(encrypted);
        return decrypted;
    }
}
