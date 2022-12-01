package Labs.encryption;

import java.io.*;
import java.nio.ByteBuffer;

public class Magma {

    private final static byte[][] table = {
            {12, 4, 6, 2, 10, 5, 11, 9, 14, 8, 13, 7, 0, 3, 15, 1},
            {6, 8, 2, 3, 9, 10, 5, 12, 1, 14, 4, 7, 11, 13, 0, 15},
            {11, 3, 5, 8, 2, 15, 10, 13, 14, 1, 7, 4, 12, 9, 6, 0},
            {12, 8, 2, 1, 13, 4, 15, 6, 7, 0, 10, 5, 3, 14, 9, 11},
            {7, 15, 5, 10, 8, 1, 6, 13, 0, 9, 3, 14, 11, 4, 2,12},
            {5, 13, 15, 6, 9, 2, 12, 10, 11, 7, 8, 1, 4, 3, 14, 0},
            {8, 14, 2, 5, 6, 9, 1, 12, 15, 4, 11, 0, 13, 10, 3, 7},
            {1, 7, 14, 13, 0, 5, 8, 3, 4, 15, 10, 6, 9, 12, 11, 2}
    };

    private byte[][] key = new byte[8][4];

    public void setKey(byte[][] key) {
        this.key = key;
    }

    private final static int[] keyMap = {0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) throws Exception {

        DataInputStream resource = new DataInputStream(
                new FileInputStream("C:\\Users\\dania\\IdeaProjects\\KATA\\src\\Labs\\encryption\\Resource.txt"));
        DataOutputStream encrypted = new DataOutputStream(
                new FileOutputStream("C:\\Users\\dania\\IdeaProjects\\KATA\\src\\Labs\\encryption\\Encrypted.txt"));


        DataInputStream encryptedForDecoding = new DataInputStream(
                new FileInputStream("C:\\Users\\dania\\IdeaProjects\\KATA\\src\\Labs\\encryption\\Encrypted.txt"));
        DataOutputStream decrypted = new DataOutputStream(
                new FileOutputStream("C:\\Users\\dania\\IdeaProjects\\KATA\\src\\Labs\\encryption\\Decrypted.txt"));


        Magma magma = new Magma();
        magma.rpz(Mode.ENCRYPT, encrypted, resource);
        System.out.println("Successful encryption...\n");

        magma.rpz(Mode.DECRYPT, decrypted, encryptedForDecoding);
        System.out.println("Successful decoding... ");


    }

    public void rpz(Mode mode, DataOutputStream dos, DataInputStream dis) throws Exception {
        byte[] data = new byte[8];
        int count = dis.read(data);
        System.out.println(count);
        while (count != -1) {
            if (count % 8 > 0) {
                for (int i = 8 - count % 8; i < count; i++) {
                    data[i] = 0x0f;
                }
            }
            byte[] B = new byte[4],
                    A = new byte[4];
            System.arraycopy(data, 0, B, 0, 4);
            System.arraycopy(data, 4, A, 0, 4);

            for (int k = 0; k < 32; k++) {
                byte[] K = Mode.ENCRYPT.equals(mode) ? key[keyMap[k]] : key[keyMap[31 - k]];
                int buf = ByteBuffer.wrap(A).getInt() + ByteBuffer.wrap(K).getInt();
                buf &= 0xffffffff; // A + K (mod 2^32)
                int[] s = {
                        (buf & 0xF0000000) >>> 28,
                        (buf & 0x0F000000) >>> 24,
                        (buf & 0x00F00000) >>> 20,
                        (buf & 0x000F0000) >>> 16,
                        (buf & 0x0000F000) >>> 12,
                        (buf & 0x00000F00) >>> 8,
                        (buf & 0x000000F0) >>> 4,
                        (buf & 0x0000000F)
                };
                buf = 0x00000000;
                for (int b = 0; b < 8; b++) {
                    buf <<= 4;
                    buf += table[b][s[b] & 0x0000000f];
                }
                buf = ((buf << 11) | (buf >>> 21));
                byte[] resBytes = ByteBuffer.allocate(4).putInt(buf).array();
                byte[] newB = {0x00, 0x00, 0x00, 0x00};

                System.arraycopy(A, 0, newB, 0, 4);
                for (int b = 0; b < 4; b++) {
                    A[b] = (byte) (resBytes[b] ^ B[b]);
                }
                System.arraycopy(newB, 0, B, 0, 4);
            }

            dos.write(A, 0, A.length);
            dos.write(B, 0, B.length);
            count = dis.read(data);
        }
        dis.close();
        dos.close();
    }

    public enum Mode {
        ENCRYPT,
        DECRYPT
    }
}
