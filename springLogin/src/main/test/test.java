import org.junit.Test;


public class test {


//    public static byte[] toByteArray() {
//        short[] src = {-7552, 4448, 8192, 25917, -19047, 2479};
//        int count = src.length;
//        byte[] dest = new byte[count << 1];
//        for (int i = 0; i < count; i++) {
//            dest[i * 2] = (byte) (src[i] >> 8);
//            byte bytes = dest[i * 2 + 1] = (byte) (src[i] >> 0);
//
//            byte [] bytes1 = "-128,96,0,61,-103,-81".getBytes();
//            String [] encoded= bytes1.;
//            byte[] decoded = java.util.Base64.getDecoder().decode(encoded);
//
//            for(String b: encoded){
//                System.out.println(b);
//            }
////            String s= new String(bytes1);
////            System.out.println(decoded);
//        }
//        return  dest;
//    }


    @Test
    public static void main(String[] args) {
        // short [] s = {-7552,4448,8192,25917,-19047,2479};

        short[] s1 = {-7552, 4448, 8192, 25917, -19047, 2479};
        for (short k = 0; k < s1.length; k++) {
//            System.out.println(s1[k]);
            String s2= String.format("%02X", s1[k]);
//            String s = Integer.toHexString().toUpperCase();

            System.out.print(s2);
//            for (int i = 0, n = s.length(); i < n; i += 2) {
//                if (i == (n - 1)) System.out.print("0" + s.charAt(i));
//                else System.out.print("" + s.charAt(i) + s.charAt(i + 1));
//               System.out.print(" ");
//            }
        }
    }
}


