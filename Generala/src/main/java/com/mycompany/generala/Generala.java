/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generala;

/**
 * @author Marcelo
 */

public class Generala {
    private int[] dice;


    public static int chance(int... dice) {
        int total = 0;

        for (int i = 0; i < dice.length; i++) {
            total += dice[i];
        }
        return total;
    }


    // '(int... dice)' es similar a tener public static int generala(int d1, int d2, int d3 , etc) pero permite realizar operaciones como -> for (int die : dice)
    //es una forma de decir que el metodo puede aceptar 1 o más parametros de tipo int ... lista de parametros dinamicos.
    public static int generala(int... dice) {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int... dice) {
        return addEqualsDice(dice, 1);
    }


    public static int twos(int... dice) {
        return addEqualsDice(dice, 2);
    }

    public static int threes(int... dice) {
        return addEqualsDice(dice, 3);
    }

    private static int addEqualsDice(int[] dice, int valor) {
        int sum = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == valor) {
                sum += valor;
            }
        }

        return sum;
    }


    public Generala(int d1, int d2, int d3, int d4, int _5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    public int fours() {
        return addEqualsDice(dice, 4);
    }

    public int fives() {
        return addEqualsDice(dice, 5);
    }

    public int sixes() {
        return addEqualsDice(dice, 6);
    }

    public static int score_pair(int... dice) {
        return addPairs(dice);
    }

    private static int addPairs(int[] dice) {
        int[] counts = new int[6];
        for (int i = 0; i < dice.length; i++) {
            counts[dice[i] - 1]++;
        }
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    public static int two_pair(int... dice) {
        return moreOfThanPair(dice);
    }

    private static int moreOfThanPair(int[] dice) {
        int[] counts = new int[6];
        for (int i = 0; i < dice.length; i++) {
            counts[dice[i] - 1]++;
        }
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int... dice) {

        return searchSameKind(dice, 4);
    }

    private static int searchSameKind(int[] dice, int valor) {
        int[] tallies = new int[6];
        for (int die : dice)
            tallies[die - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= valor)
                return (i + 1) * valor;
        return 0;
    }

    public static int three_of_a_kind(int... dice) {

        return searchSameKind(dice, 3);
    }

    public static int smallStraight(int... dice) {

        int[] tallies = new int[6];
        for (int die : dice)
            tallies[die - 1]++;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }


    public static int largeStraight(int... dice) {
        int[] tallies = new int[6];
        int acumulador= 0;
        for (int die : dice)
            tallies[die - 1]--;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] == (-1)) {
                acumulador++;

            }

        }

        if (acumulador == 5) {
            return 20;
        } else {
            return 0;
        }




    }

    public static int fullHouse(int... dice) {
        boolean two = false;
        boolean three = false;
        int at_Two = 0;
        int at_three = 0;

        int[] tallies = new int[6];
        for (int die : dice)
            tallies[die - 1]++;
        
        for (int i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                two = true;
               at_Two = i + 1;
            }

        for (int i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                three = true;
                 at_three= i + 1;
            }

        if (two && three)
            return at_Two * 2 + at_three * 3;
        else
            return 0;
    }

}

