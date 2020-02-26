/**
 * AtbashCipher
 */
public class ROT13Cipher {

    public static String encrypt(String decrypted) {
        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String zyx = "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM";
        String encrypted = "";

        for (int i = 0; i < decrypted.length(); i++) {
            String chr = String.valueOf(decrypted.charAt(i));
            encrypted += abc.indexOf(chr) > -1 ? zyx.charAt(abc.indexOf(chr)) : chr;
        }
        return encrypted;
    }
}
