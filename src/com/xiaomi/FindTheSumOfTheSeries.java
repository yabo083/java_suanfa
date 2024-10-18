package com.xiaomi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindTheSumOfTheSeries {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            double x = n, sum = n;
            for (int i = 0; i < m - 1; i++) {
                x = Math.sqrt(x); // x 自身也得每次重新赋值
                sum += x;
            }
            /**
             * 在 Java 中，`%n` 是格式化字符串中的一个占位符，用于表示平台无关的换行符。它会根据运行时平台自动选择适当的换行符（例如，在 Windows 上是 `\r\n`，在 Unix/Linux 上是 `\n`）。
             *
             * 使用 `%n` 而不是 `\n` 可以确保代码在不同操作系统上运行时都能正确换行。
             *
             * 在你的代码中：
             * ```java
             * System.out.printf("%.2f%n", sum);
             * ```
             * `%n` 确保了输出的换行符在所有平台上都是正确的。
             */
            System.out.printf("%.2f%n", sum);
        }


    }


}
