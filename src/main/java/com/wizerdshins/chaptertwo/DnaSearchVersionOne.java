package com.wizerdshins.chaptertwo;

import java.util.*;

public class DnaSearchVersionOne {

    private static String genome = "ACGTGGCTCTCTAACGTACGTACGTACGGGGTATATATACCCTAGGACTCCCT";
    private static List<Character[]> gene = new ArrayList<>();
    private static final int CODON_SIZE = 3;

    private boolean isSorted;

    public enum Nucleotide {

        A('A'), C('C'), G('G'), T('T');

        private char name;

        Nucleotide(char name) {
            this.name = name;
        }
    }

    private void getGeneFromString(String str) {

        for (int i = 0; i < str.length(); i+= CODON_SIZE) {

            if (i + 2 >= str.length()) {
                break;
            } else {
                gene.add(new Character[]{str.charAt(i), str.charAt(i + 1), str.charAt(i + 2)});
            }
        }
    }

    public boolean linearSearch(List<Character[]> gene, Character[] keyCodon) {

        for (Character[] codon : gene) {
            if (Arrays.equals(codon, keyCodon)) {
                System.out.println("Codon " + Arrays.toString(keyCodon) + " was found");
                return true;
            }

        }

        System.out.println("Codon " + Arrays.toString(keyCodon) + " not found");
        return false;
    }

    private boolean binarySearch(List<Character[]> gene, Character[] keyCodon) {

        if (!isSorted) sort(gene);

        int low = 0;
        int high = gene.size() - 1;
        int mid;

        while (low <= high) {

            mid = high - (high - low) / 2;

            if (Arrays.equals(gene.get(mid), keyCodon)) {
                System.out.println("Codon " + Arrays.toString(keyCodon) + " was found");
                return true;
            } else if (compare(gene.get(mid), keyCodon) > 0) {
                high = mid - 1;
            } else if (compare(gene.get(mid), keyCodon) < 0) {
                low = mid + 1;
            }
        }

        System.out.println("Codon " + Arrays.toString(keyCodon) + " not found");
        return false;
    }

    private void sort(List<Character[]> gene) {

        gene.sort((o1, o2) -> {
            int result = o1[0].compareTo(o2[0]);
            if (result == 0) {
                result = o1[1].compareTo(o2[1]);
                if (result == 0) {
                    result = o1[2].compareTo(o2[2]);
                }
            }
            return result;
        });
        isSorted = true;
    }

    private int compare(Character[] array1, Character[] array2) {

        int o1 = Arrays.hashCode(array1);
        int o2 = Arrays.hashCode(array2);
        return Integer.compare(o1, o2);
    }

    public static void main(String[] args) {

        DnaSearchVersionOne dnaSearch = new DnaSearchVersionOne();
        dnaSearch.getGeneFromString(genome);

        Character[] acgCodon = {Nucleotide.A.name, Nucleotide.C.name, Nucleotide.G.name};
        Character[] gatCodon = {Nucleotide.G.name, Nucleotide.A.name, Nucleotide.T.name};
        Character[] ataCodon = {Nucleotide.A.name, Nucleotide.T.name, Nucleotide.A.name};
    }
}
