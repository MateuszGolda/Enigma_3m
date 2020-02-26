/**
 * AffineCipher
 */
public class AffineCipher {
    public static final String ABC = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String TO_ENCRYPT, byte a, byte b) {
        String encrypted = "";

        for (byte i = 0; i < TO_ENCRYPT.length(); i++) {
            String chr = String.valueOf(TO_ENCRYPT.charAt(i));
            if (ABC.indexOf(chr) > -1)
                encrypted += ABC.charAt((ABC.indexOf(chr) * a + b) % ABC.length());
            else
                encrypted += chr;
        }
        return encrypted;
    }

    public static String decrypt(String TO_ENCRYPT, byte a, byte b) {
        int aInv = 0;

        for (int i = 0; i < ABC.length(); i++) {
            int flag = (a * i) % ABC.length();

            if (flag == 1) {
                aInv = i;
            }
        }
        String decrypted = "";
        for (int i = 0; i < TO_ENCRYPT.length(); i++) {
            String chr = String.valueOf(TO_ENCRYPT.charAt(i));
            if (ABC.indexOf(chr) > -1) {
                int temp = aInv * (ABC.indexOf(chr) - b);
                int mod = (temp % ABC.length() + ABC.length()) % ABC.length();
                decrypted += ABC.charAt(mod);
            } else {
                decrypted += chr;
            }
        }
        return decrypted;
    }
}
