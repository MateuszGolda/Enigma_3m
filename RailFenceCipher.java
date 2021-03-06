import java.util.ArrayList;
/*
0481357926
*/

public class RailFenceCipher {
    public static int iteration = 0;

    public static String encrypt(String toEncrypt) {
        ArrayList<String> changed = new ArrayList<>();
        firstLine(toEncrypt, changed);
        secondLine(toEncrypt, changed);
        thirdLine(toEncrypt, changed);
        StringBuilder sb = new StringBuilder();
        for (String s : changed)
            sb.append(s);
        return sb.toString();
    }

    public static String decrypt(String toEncrypt) {
        String encrypted = "";
        String a, b, c;
        a = toEncrypt.substring(0, ((toEncrypt.length() - 1) / 4) + 1);
        b = toEncrypt.substring(a.length(), a.length() + toEncrypt.length() / 2);
        int lenAB = a.length() + b.length();
        c = toEncrypt.substring(lenAB, lenAB + (toEncrypt.length() - 2) / 4 + 1);

        try {
            for (int i = 0; i < (toEncrypt.length() / 3) + 1; i++) {
                encrypted += a.charAt(i);
                encrypted += b.charAt(i * 2);
                encrypted += c.charAt(i);
                encrypted += b.charAt(i * 2 + 1);
            }
        } catch (StringIndexOutOfBoundsException e) {
            ;
        }
        return encrypted;
    }

    public static void firstLine(String toEncrypt, ArrayList<String> changed) {
        int i = 0;
        while (i < toEncrypt.length()) {
            if (i < toEncrypt.length()) {
                changed.add(toEncrypt.substring(i, i + 1));
                i += 4;
            }
            if (i > toEncrypt.length()) {
                break;
            }
        }
    }

    public static void secondLine(String toEncrypt, ArrayList<String> changed) {
        int i = 1;
        while (i < toEncrypt.length()) {
            if (i < toEncrypt.length()) {
                changed.add(toEncrypt.substring(i, i + 1));
                i += 2;
            }
            if (i > toEncrypt.length()) {
                break;
            }
        }
    }

    public static void thirdLine(String toEncrypt, ArrayList<String> changed) {
        int i = 2;
        while (i < toEncrypt.length()) {
            if (i < toEncrypt.length()) {
                changed.add(toEncrypt.substring(i, i + 1));
                i += 4;
            }
            if (i > toEncrypt.length()) {
                break;
            }
        }
    }
}