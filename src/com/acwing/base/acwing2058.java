package com.acwing.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class acwing2058 {
//将以下每行代码都写上注释
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   //读入
        char[] a = in.readLine().toCharArray();  //读入
        char[] b = in.readLine().toCharArray(); //读入
        
        Set<Integer> set = new HashSet<>();     //创建一个set集合

        int index = 0;  //创建一个index变量
        if (a[index] == '1' && a.length > 1) {
            index++;
        }   //如果a[index] == '1' && a.length > 1,则index++


        for(int i = index; i < a.length; i++){  //遍历a
            a[i] ^= 1;  //将a[i]的值取反
            set.add(get(a, 2)); //将a[i]的值取反后的值加入set集合
            a[i] ^= 1;  //将a[i]的值取反
        }

        for(int i = 0; i < b.length; i++){ //遍历b
            char tmp = b[i];    //将b[i]的值赋给tmp
            for (int j = 0; j < 3; j++){    //遍历0-2
                b[i] = (char) ('0' + j);   //将j转换为字符类型后赋给b[i]
                if(b[i] != tmp){   //如果b[i]不等于tmp
                    int x = get(b, 3); //将b[i]的值转换为十进制后赋给x
                    if(set.contains(x)){   //如果set集合中包含x
                        System.out.println(x); //输出x
                        return;     //结束程序
                    }
                }
            }
            b[i] = tmp; //将tmp赋给b[i]
        }
    }

    private static int get(char[] c, int b) { //将b进制转换为十进制后返回
        int res = 0;
        for (char x : c) {
            res = res * b + x - '0'; //将c转换为b进制后赋给res
        }
        return res;
    }
}
