import javax.crypto.*;
import java.util.*;
import java.util.Base64;

public class Main{
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey key = kg.generateKey();

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(msg.getBytes());

        // Convert to readable format
        String encMsg = Base64.getEncoder().encodeToString(encrypted);

        System.out.println("Encrypted message: " + encMsg);
    }
}