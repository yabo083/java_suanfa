package com.lanqiao;

public class acwing499 {

    public static void main(String[] args)


    {

        int res = 0;
        for (int i = 0; i < 10000; i ++ )
        {
            int x = i, r = i;
            for (int j = 0; j < 4; j ++ ) {
                r = r * 10 + x % 10;
                x /= 10;
            }
            System.out.println(r);
        }
    }


}
