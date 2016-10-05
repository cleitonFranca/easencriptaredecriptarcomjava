// Class para criptografia.
//import java.security.spec.AlgorithmParameterSpec;
//import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class EasencriptareDecriptar {

static String CHAVE_ENCRIPTACAO = "0123456789abcdef"; // 128 bit

public static void main(String[] args) throws Exception {
String plainText = "01mobile";
String cipherText = encryptText(plainText);
String decryptedText = decryptText(cipherText);

System.out.println("Original Text:" + plainText);
System.out.println("AES Key (Hex Form):" + CHAVE_ENCRIPTACAO);
System.out.println("Encrypted Text (Hex Form):" + cipherText);
System.out.println("Descrypted Text:" + decryptedText);

}

public static String encryptText(String plainText) throws Exception {
// AES defaults to AES/ECB/PKCS5Padding in Java 7
Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
aesCipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(CHAVE_ENCRIPTACAO.getBytes("UTF-8"), "AES"));
byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes("UTF8"));
return DatatypeConverter.printBase64Binary(byteCipherText);

}

public static String decryptText(String byteCipherText) throws Exception {
// AES defaults to AES/ECB/PKCS5Padding in Java 7
Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
aesCipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(CHAVE_ENCRIPTACAO.getBytes("UTF-8"), "AES"));
return new String(aesCipher.doFinal(DatatypeConverter.parseBase64Binary(byteCipherText)), "UTF-8");
}

}
