import javax.crypto.*;

import java.util.Base64;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String url = sc.nextLine();

        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);
        SecretKey key = kg.generateKey();

        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);

        byte[] enc = c.doFinal(url.getBytes());
        String encrypted = Base64.getEncoder().encodeToString(enc);

        System.out.println("Encrypted URL: " + encrypted);
    }
}