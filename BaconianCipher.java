/**
 * BaconianCipher
 */
public class BaconianCipher {
    public static final String ABC = "abcdefghiklmnopqrstuwxyz";
    public static final String ABCJV = "abcdefghjklmnopqrstvwxyz";

    public static String encrypt(String toEncrypt) {
        String encrypted = "";
        for (int chr = 0; chr < toEncrypt.length(); chr++) {
            if (toEncrypt.charAt(chr) == 'j' || toEncrypt.charAt(chr) == 'v')
            encrypted += chrToAOrB((byte) ABCJV.indexOf(toEncrypt.charAt(chr)));
            else if (ABC.indexOf(toEncrypt.charAt(chr)) > -1)
            encrypted += chrToAOrB((byte) ABC.indexOf(toEncrypt.charAt(chr)));
        }
        return encrypted;
    }

    public static String decrypt(String toDecrypt) {
        String empty = toDecrypt.replace("a", "").replace("b", "");
        if (empty.length() != 0) {
            System.out.println("Invalid input");
            System.exit(0);
        }
        String decrypted = "";
        String chrEncrypted = "";
        for (int chr = 0; chr < toDecrypt.length(); chr++) {
            chrEncrypted += toDecrypt.charAt(chr);
            if (chrEncrypted.length() == 5){
                byte chrDecrID = binToByte(chrEncrypted);
                if (ABC.charAt(chrDecrID) > -1)
                    decrypted += ABC.charAt(chrDecrID);
                chrEncrypted = "";
            }
        }
        return decrypted;
    }

    public static String chrToAOrB(byte chr) {
        String binReversed = "";

        for (int i = 1; i < 32; i = i << 1)
            binReversed += ((chr & i) > 0 ? 1 : 0);

        String binary = new StringBuilder(binReversed).reverse().toString();
        return binary.replace("0", "a").replace("1", "b");
    }

    public static byte binToByte(String word) {
        String binary = word.replace("a", "0").replace("b", "1");
        byte chrByte = 0;
        for (int i = 0; i < (word.length()); i++) {
            chrByte += binary.charAt(word.length() - 1 - i) == '1' ? Math.pow(2, i) : 0;
        }
        return chrByte;
    }
}