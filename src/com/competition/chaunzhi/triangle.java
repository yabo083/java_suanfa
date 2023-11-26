package com.competition.chaunzhi;

import java.util.Scanner;

public class triangle {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int S = scanner.nextInt();
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();

            double distance = Math.sqrt(Math.pow(x0 - x, 2) + Math.pow(y0 - y, 2));
            if (distance > r) {
                System.out.println("-1");
                return;
            }

            double xa = x + r * (x0 - x) / distance;
            double ya = y + r * (y0 - y) / distance;

            double theta = Math.atan2(y0 - y, x0 - x);
            double xb = x + r * Math.cos(theta + 2 * Math.PI / 3);
            double yb = y + r * Math.sin(theta + 2 * Math.PI / 3);
            double xc = x + r * Math.cos(theta - 2 * Math.PI / 3);
            double yc = y + r * Math.sin(theta - 2 * Math.PI / 3);

            double area = Math.abs(0.5 * (xa*(yb-yc) + xb*(yc-ya) + xc*(ya-yb)));
            if (area < S) {
                System.out.println("-1");
            } else {
                System.out.printf("%.7f %.7f %.7f %.7f %.7f %.7f\n", xa, ya, xb, yb, xc, yc);
            }
        }
    }


