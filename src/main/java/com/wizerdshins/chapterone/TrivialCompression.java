package com.wizerdshins.chapterone;

import java.util.BitSet;

public class TrivialCompression {

    private String compressWithBitSet(String str) {

        StringBuilder encodeBuilder = new StringBuilder();

        int bitSetSize = 2 * str.length();
        BitSet bitSet = new BitSet(bitSetSize);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'C') {
                bitSet.clear(i * 2);
                bitSet.set(i * 2 + 1);
            } else if (str.charAt(i) == 'A') {
                bitSet.clear(i * 2);
                bitSet.set(i * 2 + 1, false);
            } else if (str.charAt(i) == 'T') {
                bitSet.clear(i * 2);
                bitSet.set(i * 2, i * 2 + 2);
            } else if (str.charAt(i) == 'G') {
                bitSet.clear(i * 2 + 1);
                bitSet.set(i * 2);
            }
        }

        for (int i = 0; i < bitSetSize; i++) {
            if (bitSet.get(i)) {
                encodeBuilder.append("1");
            } else {
                encodeBuilder.append("0");
            }
        }
        return encodeBuilder.toString();
    }

    private String decodeWithBitSet(String str) {

        StringBuilder decodeBuilder = new StringBuilder();
        String[] bits = str.split("(?<=\\G.{2})");
        for (String bit : bits) {
            switch (bit) {
                case "00":
                    decodeBuilder.append("A");
                    break;
                case "01":
                    decodeBuilder.append("C");
                    break;
                case "10":
                    decodeBuilder.append("G");
                    break;
                case "11":
                    decodeBuilder.append("T");
                    break;
            }
        }
        return decodeBuilder.toString();
    }

    public static void main(String[] args) {}

}
