package com.acwing.spring2023;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class acwing3451 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str = sc.nextLine();
            StringBuilder cs = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i))) {
                    cs.append(str.charAt(i));
                }
            }

            Character[] cs1 = cs.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

            Arrays.sort(cs1, Comparator.comparingInt(Character::toLowerCase));


            for (int i = 0, j = 0; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i))) {
                    System.out.print(cs1[j++]);
                } else {
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }




}
