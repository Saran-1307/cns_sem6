public class ex10 {

    static long power(long a, long b, long mod) {
        long result = 1;
        for(int i=0;i<b;i++)
            result = (result * a) % mod;
        return result;
    }

    public static void main(String[] args) {

        long q = 353;   // prime
        long a = 3;     // primitive root

        long XA = 17;   // Alice private key
        long XB = 21;   // Bob private key

        long YA = power(a, XA, q);  // Alice public key
        long YB = power(a, XB, q);  // Bob public key

        long KA = power(YB, XA, q); // shared key by Alice
        long KB = power(YA, XB, q); // shared key by Bob

        System.out.println("Public key of Alice: " + YA);
        System.out.println("Public key of Bob: " + YB);
        System.out.println("Shared key (Alice): " + KA);
        System.out.println("Shared key (Bob): " + KB);
    }
}