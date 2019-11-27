package com.wizerdshins.chapterone;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class UnbreakableEncryption {

    /*
    one-time pad encryption
     */

    private static String SOURCE = "Encode me!";

    private byte[] getKey(String str) {

        byte[] key = new byte[str.length()];

        try {
            SecureRandom.getInstanceStrong().nextBytes(key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return key;
    }

    private byte[] encode(String str, byte[] key) {

        byte[] sourceSequence = str.getBytes();

        byte[] encodedMessage = new byte[sourceSequence.length];
        for (int i = 0; i < sourceSequence.length; i++) {
            encodedMessage[i] = (byte)(sourceSequence[i] ^ key[i]);
        }

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

    private String getEncodingWithOneTimePadCipher(String SOURCE) {

        byte[] key = getKey(SOURCE);
        byte[] encode = encode(SOURCE, key);
        byte[] decode = decode(encode, key);

        return new String(decode);
    }

    public static void main(String[] args) {}
}
