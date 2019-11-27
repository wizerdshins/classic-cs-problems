package com.wizerdshins.othertasks;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {

    private static String SOURCE = "Encode me!";
    private static List<Byte> characters = new ArrayList<>();

    /**
     * simplest realization of caesar cipher;
     * key is hardcoded and not checked
     * can u make it easier?
     */

    private String encode(String source, int key) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            builder.append((char)(source.charAt(i) + key));
        }
        return builder.toString();
    }

    private String decode(String encryptString, int key) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < encryptString.length(); i++) {
            builder.append((char)(encryptString.charAt(i) - key));
        }
        return builder.toString();
    }

    /**
     * string encryption with byte[] arrays
     * ... and get random bytes if character is not letter or digit
     */

    private byte[] encodeWithBytes(String str, int key) {

        byte[] source = str.getBytes();
        byte[] encode = new byte[source.length];

        for (int i = 0; i < source.length; i++) {
            char c = (char) source[i];
            if (!Character.isLetterOrDigit(c)) {
                characters.add((byte) c);
                c = (char)((Math.random() * (90 - 65) + 1) + 65);
                characters.add((byte) i);
                encode[i] = (byte) c;
            } else {
                encode[i] = (byte)(c + key);
            }
        }
        return encode;
    }

    private byte[] decodeWithBytes(byte[] encode, int key, List<Byte> savedCharacters) {

        byte[] decode = new byte[encode.length];

        for (int i = 0; i < encode.length; i++) {
            decode[i] = (byte)(encode[i] - key);
            for (int j = 0; j < savedCharacters.size(); j++) {
                if (i == savedCharacters.get(j)) {
                    decode[i] = savedCharacters.get(j - 1);
                }
            }
        }
        return decode;
    }

    public static void main(String[] args) {}
}
