package com.wizerdshins.chaptertwo;

import java.util.*;

public class DnaSearchVersionTwo {

    private static String genome = "ACGTGGCTCTCTAACGTACGTACGTACGGGGTATATATACCCTAGGACTCCCT";
    private static final int CODON_SIZE = 3;
    private boolean isSorted;

    public static class Codon implements Comparable {

        private Character nucleotideOne;
        private Character nucleotideTwo;
        private Character nucleotideThree;

        public Codon(Character nucleotideOne,
                     Character nucleotideTwo,
                     Character nucleotideThree) {
            this.nucleotideOne = nucleotideOne;
            this.nucleotideTwo = nucleotideTwo;
            this.nucleotideThree = nucleotideThree;

        }

        public Character getNucleotideOne() {
            return nucleotideOne;
        }

        public Character getNucleotideTwo() {
            return nucleotideTwo;
        }

        public Character getNucleotideThree() {
            return nucleotideThree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Codon codon = (Codon) o;
            return Objects.equals(nucleotideOne, codon.nucleotideOne) &&
                    Objects.equals(nucleotideTwo, codon.nucleotideTwo) &&
                    Objects.equals(nucleotideThree, codon.nucleotideThree);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nucleotideOne, nucleotideTwo, nucleotideThree);
        }

        @Override
        public String toString() {
            return "[" + nucleotideOne +
                    ", " + nucleotideTwo +
                    ", " + nucleotideThree +
                    "]";
        }

        @Override
        public int compareTo(Object o) {
            return Comparator.comparing(Codon::getNucleotideOne)
                    .thenComparing(Codon::getNucleotideTwo)
                    .thenComparing(Codon::getNucleotideThree)
                    .compare(this, (Codon) o);
        }
    }


    private static List<Codon> gene = new ArrayList<>();

    private void getGeneFromString(String str) {

        System.out.println("Length: " + str.length());
        for (int i = 0; i < str.length(); i+= CODON_SIZE) {

            if (i + 2 >= str.length()) {
                break;
            } else {
                gene.add(new Codon(str.charAt(i), str.charAt(i + 1), str.charAt(i + 2)));
                System.out.println(str.charAt(i) + ", index: " + i);
            }
        }
    }

    public boolean linearSearch(List<Codon> gene, Codon keyCodon) {

        for (Codon codon : gene) {
            if (codon.equals(keyCodon)) {
                System.out.println("Codon " + keyCodon + " was found");
                return true;
            }

        }
        System.out.println("Codon " + keyCodon + " not found");
        return false;
    }

    private boolean binarySearch(List<Codon> gene, Codon keyCodon) {

        if (!isSorted) sort(gene);

        int high = gene.size() - 1;
        int low = 0;
        int mid;

        while (low <= high) {

            mid = high - (high - low) / 2;
            if (gene.get(mid).equals(keyCodon)) {
                System.out.println("Codon " + keyCodon + " was found");
                return true;
            } else if (gene.get(mid).compareTo(keyCodon) > 0) {
                high = mid - 1;
            } else if (gene.get(mid).compareTo(keyCodon) < 0) {
                low = mid + 1;
            }
        }

        System.out.println("Codon " + keyCodon + " not found");
        return false;
    }

    private void sort(List<Codon> gene) {

        gene.sort((o1, o2) -> o1.hashCode() < o2.hashCode()
                ? -1
                : ((o1.hashCode() - o2.hashCode() == 0)
                ? 0
                : 1));
        isSorted = true;
    }


    public static void main(String[] args) {}
}
