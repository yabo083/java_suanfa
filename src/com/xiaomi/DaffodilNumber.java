package com.xiaomi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DaffodilNumber {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 100; i <= 999; i++) {
//            int x = i % 10;
//            int y = i / 10 % 10;
//            int z = i / 100;
//            if (i == x * x * x + y * y * y + z * z * z) {
//                list.add(i);
//            }
//        }
        list.add(153);
        list.add(370);
        list.add(371);
        list.add(407);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            // 如何实现在list中找出值在[m, n]之间的数，并添加到一个Stringbuilder中？
            StringBuilder sb = new StringBuilder();
            for (int num : list) {
                if (num >= m && num <= n) {
                    sb.append(num).append(" ");
                }
            }
            if (sb.isEmpty()) {
                System.out.println("no");
            } else {
                System.out.println(sb.toString().trim());
            }
        }

    }
}


