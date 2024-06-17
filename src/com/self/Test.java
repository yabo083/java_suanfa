package com.self;

class Line {
    public class Point {
        public int x;
        public int y;

    }

    public Point getPoint() {
        return new Point();
    }

}

class Triangle {
    public Triangle() {
        float f[][] = new float[2][];
    }

    public static void main(String[] args) {
        long x= 42;
        float f1[] = new float[2];
        f1[0] = 42.0f;
        boolean b = x == f1[0];
        System.out.println(b);
    }

}


