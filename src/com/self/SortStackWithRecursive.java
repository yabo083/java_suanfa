package com.self;

import java.util.Stack;

/**
 * 使用递归对堆栈进行排序
 * <br/>
 * 注：除了deep是以stack是否为空，其他都是依靠deep，所以deep只算一次。
 * 如果都改为以stack是否为空，那就不能隔离后续操作对之前排好的数的影响。
 * 注意！！
 * @author Yabo
 * @date 2024/06/04
 */
public class SortStackWithRecursive {

    public static void sort(Stack<Integer> stack) {
        // 1. 获取深度
        int deep = deep(stack);
        // 2. 开始while循环
        while (deep > 0) {
            // 2.1. 先获取最大值
            int max = max(stack, deep);
            // 2.2. 再获取出现次数
            int k = times(stack, deep, max);
            // 2.3. 然后把这出现k次的max沉江
            down(stack, deep, max, k);
            // 2.4. 遗忘这k个最大值
            deep -= k;
        }
    }

    public static int deep(Stack<Integer> stack) {
        // 1. 如果栈为空，那就直接返回0
        if (stack.isEmpty())
            return 0;
        else {
            // 2. 除去栈顶
            int num = stack.pop();
            // 3. 众所周知：栈深=除去栈顶的栈深+1
            int deep = deep(stack) + 1;
            // 4. 给人放回去
            stack.push(num);
            // 5. 返回存好的深度
            return deep;
        }
    }

    public static int max(Stack<Integer> stack, int deep) {
        // 1. 如果栈为空，那就返回极小值
        if (deep == 0)
            return Integer.MIN_VALUE;
        else {
            // 2. 除去栈顶
            int num = stack.pop();
            // 3. 众所周知：栈元素最大值=Max（栈顶，剩下栈元素最大值）
            int max = Math.max(num, max(stack, deep - 1));
            // 4. 给人放回去
            stack.push(num);
            // 5. 返回存好的最大值
            return max;
        }
    }

    public static int times(Stack<Integer> stack, int deep, int max) {
        // 1. 如果栈为空，那就返回0次
        if (deep == 0)
            return 0;
        else {
            // 2. 除去栈顶
            int num = stack.pop();
            // 3. 众所周知：最大值出现次数=栈顶 == max ？1:0+ 剩余栈元素中最大值出现次数
            int k = (num == max ? 1 : 0) + times(stack, deep - 1, max);
            // 4. 给人放回去
            stack.push(num);
            // 5. 返回存好的最大值出现次数
            return k;
        }
    }

    public static void down(Stack<Integer> stack, int deep, int max, int k) {
        // 1. 如果栈为空，那就给我狠狠地沉k次max啊！！
        if (deep == 0)
            for (int i = 0; i < k; i ++)
                stack.push(max);
        else {
            // 2. 如果不空，那就先除去栈顶
            int num = stack.pop();
            // 3. 众所周知：栈没空，就不能沉！所以要给我把阻碍都掀开啊啊！！
            down(stack, deep - 1, max, k);
            // 4. 如果先前的栈顶不是最大值，那我还能发发慈悲（下次再收拾你！）
            if (num != max)
                stack.push(num);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.add(1);
        test.add(5);
        test.add(4);
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(3);
        test.add(1);
        test.add(4);
        test.add(2);
        sort(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

        // 随机测试
        int N = 20;
        int V = 20;
        int testTimes = 20000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * N);
            Stack<Integer> stack = randomStack(n, V);
            sort(stack);
            if (!isSorted(stack)) {
                System.out.println("出错了!");
                break;
            }
        }
        System.out.println("测试结束");
    }

    public static boolean isSorted(Stack<Integer> stack) {
        int step = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            if (step > stack.peek()) {
                return false;
            }
            step = stack.pop();
        }
        return true;
    }

    public static Stack<Integer> randomStack(int n, int v) {
        Stack<Integer> ans = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            ans.add((int) (Math.random() * v));
        }
        return ans;
    }

}
