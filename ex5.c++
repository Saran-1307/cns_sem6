#include <iostream>
#include <openssl/evp.h>
#include <cstring>
using namespace std;

int main() {
    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();

    unsigned char key[17] = "0123456789abcdef";  
    unsigned char iv[17]  = "abcdef9876543210";  

    unsigned char plaintext[] = "Hello";
    unsigned char ciphertext[128], decrypted[128];

    int len, ciphertext_len, decrypted_len;


    EVP_EncryptInit_ex(ctx, EVP_aes_128_cbc(), NULL, key, iv);
    EVP_EncryptUpdate(ctx, ciphertext, &len, plaintext, strlen((char*)plaintext));
    ciphertext_len = len;
    EVP_EncryptFinal_ex(ctx, ciphertext + len, &len);
    ciphertext_len += len;

    cout << "Encrypted: ";
    for(int i = 0; i < ciphertext_len; i++) printf("%02x", ciphertext[i]);
    cout << endl;

  
    EVP_DecryptInit_ex(ctx, EVP_aes_128_cbc(), NULL, key, iv);
    EVP_DecryptUpdate(ctx, decrypted, &len, ciphertext, ciphertext_len);
    decrypted_len = len;
    EVP_DecryptFinal_ex(ctx, decrypted + len, &len);
    decrypted_len += len;

    decrypted[decrypted_len] = '\0';
    cout << "Decrypted: " << decrypted << endl;

    EVP_CIPHER_CTX_free(ctx);
}