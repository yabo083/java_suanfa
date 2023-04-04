package com.lanqiao;

import java.io.*;

public class acwing868 {

    static int N = 1000010;
    static int[] primes = new int[N];//存质数的数组，与cnt搭配使用
    static boolean[] st = new boolean[N];//标识一个数是否被筛掉，false没被筛，true被筛了，没被筛的是质数。
    static int cnt;



    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public static  <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }


    static void get_prime1(int n) {
        for (int i = 2; i < n; i++) {
            if (!st[i]) primes[cnt ++] = i;
            for (int j = i + i; j <= n; j += i)
                st[j] = true;
        }
    }

    static void get_prime2(int n){
        for (int i = 2; i <= n;i ++){
            if (st[i]) continue;
            primes[cnt ++] = i;
            for (int j = i * i; j <= n; j += i)
                st[j] = true;
        }
    }

    //线性筛法
    static void get_prime3(int n) {

        //从2开始，确保筛数时用的是最小质因子
        for (int i = 2; i <= n; i++) {

            //语义：若为false，则说明未被筛掉，是质数，所以存起来。
            if (!st[i]) primes[cnt ++] = i;

            //这里有两个问题：一是你怎么解决重复筛？二是

            //理论上是将质数的所有倍数筛掉，剩下的就都是质数了，但这里似乎也筛合数的倍数？
            //得，别管这个了，不知道从哪听来的，看下面吧！

            //每个数都用最小质因子去筛,每个数的最小质因子只有一个，所以每个数都只被筛一次，所以是线性的。
            //上面解释了为什么是线性的，但是每个数的最小质因子只有唯一性，没有特异性，也就是不同数的最小质因子可能相同，
            //那这怎么保证在筛20时，12不会被重复筛呢？我去试试...
            //蚌埠住了，筛20的时候，虽然p[j]第一个还是2，但是i此时早就等于10了，没可能再筛12了，已经无法触及了
            //这是因为i不同，所以质数数组primes这个放大器放出来的数也就不同！
            //模拟的最后结果就是，凡不是用最小质因子去筛的（体现在你不加if (i % primes[j] == 0) break;），那必会重复筛；
            //凡是加了，那就是用最小质因子去筛的，那必不会重复筛！
            //这是实践得出来的，尚待与理论结合


            //看了一句鞭辟入里的话，一下子就概括了这个内层循环的作用：
            //当i是质数，就筛掉i与primes中所有质数的乘积；i是非质数，筛掉i与primes中所有<=(i的最小质因子)的乘积
            //至于即使是质数，也有可能用不完primes数组的问题，无关重复筛问题，它只是限制筛的边界（n给的太小才会出现）而已，筛了也没意义。

            //为什么不需要写j<cnt，不需要担心primes数组越界？
            //- primes数组中存有<=i的所有质数
            //- 当i是合数时, pj为i的最小质因子时break, j不会越界
            //- 当i是质数时, primes数组的最后一个元素就是i, 当pj == i时, i ，break, j还是不会越界
            //- 要不然就是n给的太小，导致primes数组还没遍历完，内层循环就结束了，这样也不会越界。

            //总的来看，是筛i的倍数！（并且是用最小质因子去筛掉的）所以无须担心重复筛的问题



            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        get_prime3(n);
        sc.write(cnt);
    }


}
