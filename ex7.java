import java.security.MessageDigest;
import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String input = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hash = md.digest(input.getBytes());

        System.out.print("Message Digest: ");
        for(byte b : hash){
            System.out.printf("%02x", b);
        }
    }
}