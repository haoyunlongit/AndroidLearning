import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.SecureRandom;

public class AESUtils {

    /** 密钥长度: 128, 192 or 256 */
    private static final int KEY_SIZE = 128;

    /** 加密/解密算法名称 */
    private static final String ALGORITHM = "AES/ECB/NoPadding";

    /** 随机数生成器（RNG）算法名称 */
    private static final String RNG_ALGORITHM = "SHA1PRNG";

    /**
     * 数据加密: 明文 -> 密文
     */
    public static byte[] encrypt(byte[] plainBytes, String key) throws Exception {

        // 生成密钥对象
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // 初始化密码器（加密模型）
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        // 加密数据, 返回密文
        byte[] cipherBytes = cipher.doFinal(plainBytes);

        return cipherBytes;
    }

    /**
     * 数据解密: 密文 -> 明文
     */
    public static byte[] decrypt(byte[] cipherBytes, String key) throws Exception {
        // 生成密钥对象
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");

        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 初始化密码器（解密模型）
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);

        // 解密数据, 返回明文
        byte[] plainBytes = cipher.doFinal(cipherBytes);

        return plainBytes;
    }

    private static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                // nothing
            }
        }
    }

    public static void main(String[] args) {

        int newCap = (int)Math.ceil(1 * 0.33);


        // 输出解密后的明文: "Hello world!"
        System.out.println("!~~~~~~~~" + newCap);
    }
}
