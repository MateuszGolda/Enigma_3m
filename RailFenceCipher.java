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
        String[] decrypted = new String[toEncrypt.length()];
        firstTurn(toEncrypt, decrypted);
        secondTurn(toEncrypt, decrypted);
        thirdTurn(toEncrypt, decrypted);
        
        StringBuilder sb = new StringBuilder();
    for (String s : decrypted)
        sb.append(s);
    return sb.toString();
    }

        public static void firstLine(String toEncrypt, ArrayList<String> changed) {
            int i = 0;
            while (i < toEncrypt.length()) {
                if (i < toEncrypt.length()){
                    changed.add(toEncrypt.substring(i, i+1));
                    i+=4;
                }
                if (i > toEncrypt.length()){
                    break;
                }
            }
        }

       
        public static void secondLine(String toEncrypt, ArrayList<String> changed) {
            int i = 1;
            while (i < toEncrypt.length()) {
                if (i < toEncrypt.length()){
                    changed.add(toEncrypt.substring(i, i+1));
                    i+=2;
                }
                if (i > toEncrypt.length()){
                    break;
                }
            }
        }


        public static void thirdLine(String toEncrypt, ArrayList<String> changed) {
            int i = 2;
            while (i < toEncrypt.length()) {
                if (i < toEncrypt.length()){
                    changed.add(toEncrypt.substring(i, i+1));
                    i+=4;
                }
                if (i > toEncrypt.length()){
                    break;
                }
            }
        }
        public static void firstTurn(String toEncrypt, String[] decrypted) {
            int i = 0;
            while (i < toEncrypt.length()) {
                if (i < toEncrypt.length()){
                    decrypted[i] = toEncrypt.substring(i, i+1);
                    i+=4;
                    iteration+=1;
                }
                if (i > toEncrypt.length()){
                    break;
                }
            }
        }


        public static void secondTurn(String toEncrypt, String[] decrypted) {
            int i = iteration;
            while (i < toEncrypt.length()) {
                if (i < toEncrypt.length()){
                    decrypted[iteration] = "-"; /*toEncrypt.substring(iteration, iteration+1);*/
                    i+=2;
                    iteration+=1;
                }
                if (i > toEncrypt.length()){
                    break;
                }
            }
        }


        public static void thirdTurn(String toEncrypt, String[] decrypted) {
            int i = iteration;
            while (i < toEncrypt.length()) {
                if (i < toEncrypt.length()){
                    decrypted[iteration] = "-";  /*toEncrypt.substring(iteration, iteration+1);*/
                    i+=4;
                    iteration+=1;
                }
                if (i > toEncrypt.length()){
                    break;
                }
            }
        }
        }
