/**
 * BaconianCipher
 */
public class BaconianCipher {
    public static final String ABC = "abcdefghjklmnopqrstvwxyz";
    public static void main(String[] args) {
        encrypt("dupa");
    }

    public static void encrypt(String toEncrypt) {
        
    }

    public static void decrypt(String toDecrypt) {
        
    }

    public static String chrToAbaba(byte chr) {
        String binReversed = "";

        for (int i = 1; i < 32; i = i << 1)
            binReversed += ((chr & i) > 0 ? 1 : 0);

        String binary = new StringBuilder(binReversed).reverse().toString();
        return binary.replace("0", "a").replace("1", "b");
    }
}