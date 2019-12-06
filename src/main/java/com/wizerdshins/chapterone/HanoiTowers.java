package com.wizerdshins.chapterone;

import java.util.ArrayDeque;

public class HanoiTowers {

    private static ArrayDeque<Character> towerOne = new ArrayDeque<>();
    private static ArrayDeque<Character> towerTwo = new ArrayDeque<>();
    private static ArrayDeque<Character> towerThree = new ArrayDeque<>();

    private void init() {
        towerOne.addFirst('A');
        towerOne.addFirst('B');
        towerOne.addFirst('C');
    }

    /**
     * Homer Jay Simpson's style
     */

    public void moveSimple() {

        int count = 0;

        System.out.println("First tower: " + towerOne);
        System.out.println("Third tower: " + towerThree);

        char a, b, c; // omg

        c = towerOne.removeFirst();
        towerThree.addFirst(c);
        count++;

        b = towerOne.removeFirst();
        towerTwo.addFirst(b);
        count++;

        towerTwo.addFirst(towerThree.removeFirst());
        count++;

        a = towerOne.removeFirst();
        towerThree.addFirst(a);
        count++;

        towerOne.addFirst(towerTwo.removeFirst());
        count++;

        towerThree.addFirst(towerTwo.removeFirst());
        count++;

        towerThree.addFirst(towerOne.removeFirst());
        count++;

        System.out.println("Third tower: " + towerThree);
        System.out.println("First tower: " + towerOne);
        System.out.println("Moves: " + count);
    }

    /**
     * classic recursive algorithm
     * @param number start tower size
     */

    private void moveWithRecursion(ArrayDeque<Character> begin,
                                  ArrayDeque<Character> end,
                                  ArrayDeque<Character> temp,
                                  int number) {

        if (number == 1) {
            end.addFirst(begin.removeFirst());
        } else {
            moveWithRecursion(begin, temp, end, number - 1);
            moveWithRecursion(begin, end, temp, 1);
            moveWithRecursion(temp, end, begin, number - 1);
        }
    }


    public static void main(String[] args) {}

}
