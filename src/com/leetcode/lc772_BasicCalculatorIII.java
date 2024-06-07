package com.leetcode;

import java.util.ArrayList;

class lc772_BasicCalculatorIII {

    public static int where;

    public static int f(char[] s, int i) {
        // 1. 数字寄存器cur
        int cur = 0;
        // 2. 数字栈与符号栈，啊都是ArrayList
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        // 3. while循环，如果没走到负责的区间尾 或 步进指针没指向一个右括号：总之就是没到结束的时候，就得继续循环
        while (i < s.length && s[i] != ')') {
            // 4. 如果是数字，那就寄存到cur里
            if ('0' <= s[i] && s[i] <= '9') {
                cur = cur * 10 + s[i++] - '0';
            } else if (s[i] != '(') {
                // 5. 如果是是运算符，那就压栈（具体是+、-直接压，*、/先算后压，虽然和那种传统的不一样，但也行）
                push(nums, ops, cur, s[i++]);
                cur = 0;
            } else {
                // 6. 最后就只剩遇到左括号的情况了，此时递归调用子函数，获得了子区间的计算总和；随后，步进指针赋值为已经更新的全局变量+1
                cur = f(s, i + 1);
                i = where + 1;
            }
        }
        // 7. while循环结束，随后为了统一，给最后一个数名义上加一个没用的+号
        push(nums, ops, cur, '+');
        // 8. 更新全局变量，返回计算的值
        where = i;
        return compute(nums, ops);
    }

    public static void push(ArrayList<Integer> nums, ArrayList<Character> ops, int cur, char op) {
        // 1. 先看看数字栈中是否有数？
        int n = nums.size();
        // 2. 如果没有或符号栈栈顶为+、-，则直接cur入栈，op入栈即可
        if (n == 0 || ops.get(n - 1) == '+' || ops.get(n - 1) == '-') {
            nums.add(cur);
            ops.add(op);
        } else {
            // 3. 否则，说明符号栈栈顶为*、/，则先和cur计算一下，结果用来重置数字栈栈顶，随后op再入符号栈。
            int topNum = nums.remove(n - 1);
            int topOp = ops.remove(n - 1);
            if (topOp == '*') {
                nums.add(topNum * cur);
            } else {
                nums.add(topNum / cur);
            }
            ops.add(op);
        }
    }

    public static int compute(ArrayList<Integer> nums, ArrayList<Character> ops) {
        // 1. 获取数字栈数字总数
        int n = nums.size();
        // 2. 预计算数字栈栈底
        int ans = nums.get(0);
        // 3. 开始错位计算（符号栈栈顶被舍弃）
        for (int i = 1; i < n; i++) {
            ans += (ops.get(i - 1) == '+' ? nums.get(i) : -nums.get(i));
        }
        // 4. 返回答案
        return ans;
    }

    public int calculate(String s) {
        // 1. 重新初始化全局变量
        where = 0;
        s = s.replaceAll("\\s", "");
        // 2. 返回调用递归函数的结果
        return f(s.toCharArray(), 0);
    }

    public static void main(String[] args) {
        lc772_BasicCalculatorIII lc = new lc772_BasicCalculatorIII();
        System.out.println(lc.calculate("2*3+4"));
    }


}
