package com.self;

import java.util.Stack;

/**
 * 利用递归逆序堆栈
 *
 * @author Yabo
 * @date 2024/06/04
 */
public class ReverseStackWithRecursive {
    public static void reverse(Stack<Integer> stack) {
        // 1. 如果为空，你逆个什么序？
        if (stack.isEmpty())
            return;
        // 2. 如果不为空，那么逆序后的栈=把栈底元素抽取出来记下+逆转剩下的+把栈底元素再push回去
        int num = bottomOut(stack);
        reverse(stack);
        stack.push(num);
    }

    public static int bottomOut(Stack<Integer> stack) {
        // 1. 先pop栈顶元素
        int ans = stack.pop();
        // 2. 如果栈就此为空，那说明刚才的栈顶就是栈底，就直接返回答案就好
        if (stack.isEmpty())
            return ans;
        else {
            // 3. 如果不为空，那就代表找错了，继续bottomOut（栈），把获得的栈底记下来
            int last = bottomOut(stack);
            // 4. 把栈定物归原位
            stack.push(ans);
            // 5. 返回记下的栈底
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
