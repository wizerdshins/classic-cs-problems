package com.wizerdshins.chapterone;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class UnbreakableEncryption {

    /*
    one-time pad encryption
     */

    private static String source = "Encode me!";

    private byte[] getKey(String str) {

        byte[] key = new byte[str.length()];

        try {
            SecureRandom.getInstanceStrong().nextBytes(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.println("Key in getKey(): " + Arrays.toString(key));
        return key;
    }

    private byte[] encode(String str, byte[] key) {

        byte[] sourceSequence = str.getBytes();
        System.out.println("Source in encode(): " + Arrays.toString(sourceSequence));
        System.out.println("Key in encode(): " + Arrays.toString(key));

        byte[] encodedMessage = new byte[sourceSequence.length];
        for (int i = 0; i < sourceSequence.length; i++) {
            encodedMessage[i] = (byte)(sourceSequence[i] ^ key[i]);
        }
        System.out.println("Encode in encode(): " + Arrays.toString(encodedMessage));
        return encodedMessage;
    }

    private String getEncodeString(byte[] encodedMessage) {
        return new String(encodedMessage);
    }

    private byte[] decode(byte[] encoded, byte[] key) {

        byte[] decodedMessage = new byte[encoded.length];
        for (int i = 0; i < encoded.length; i++) {
            decodedMessage[i] = (byte)(encoded[i] ^ key[i]);
        }

        return decodedMessage;
    }

    private String getEncodingWithOneTimePadCipher(String source) {

        byte[] key = getKey(source);
        byte[] encode = encode(source, key);
        byte[] decode = decode(encode, key);
        return new String(decode);
    }

    public static void main(String[] args) {}
}
