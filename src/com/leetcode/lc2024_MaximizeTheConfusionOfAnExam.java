package com.leetcode;

/**
 * 先后统计两次，一次只统计T，一次只统计F<br />
 * 每次的数组值只用视为T或非T、F或非F（之后拿T举例）<br />
 * 而在子函数里，主要流程就是遍历数组一次。<br />
 * 每次检查字符是否为T，如果不是，就动用修改次数同时窗口右端点右移。<br />
 * 而当修改的次数过多，则使窗口左窗口端点右移。<br />
 * 每次循环要做的事还有max一次之前和当前的窗口长度。<br />
 * <hr>
 * 做后感受：<br />
 * 虽然清楚的主要逻辑，但对左右指针的更新时机还是不清楚，导致反复修改了好多，<br />
 * 以至于最后退化到了一种效率最低的debug模式。<br />
 * <hr>
 * 教训：多想多练，思考谨慎！<br />
 *
 * @author Yabo
 * @date 2024/09/02
 */
class lc2024_MaximizeTheConfusionOfAnExam {

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        // 1. 返回调用子函数的结果
        return Math.max(maxConsecutiveAnswers(answerKey, k, 'T'), maxConsecutiveAnswers(answerKey, k, 'F'));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k, char ch) {
        // 1. 获取字符串长度
        int n = answerKey.length();
        // 2. 设置答案变量
        int ans = 0;
        // 3. for循环，结束后即得ans最大值
        for (int l = 0, r = 0, counts = 0; r < n; r++) {
            // 	1. 如果可以通过修改来使当前字符为ch，那就改（其实是一种假改）！
            // 	同时修改次数++
            //  并不是在这里修改r！
            if (answerKey.charAt(r) != ch) {
                counts++;
            }
            // 	2. 检查修改次数是否超过k，
            // 	如超，则窗口左指针右移（无论如何！而且是l，不是r！）、看实际是否是ch来觉得是否要恢复修改次数。
            while (counts > k) {
                if (answerKey.charAt(l) != ch) {
                    counts--;
                }
                l++;
            }
            // 	3. 计算当前窗口长度，和之前的ans取个max。
            ans = Math.max(ans, r - l + 1);
        }
        // 4. 返回ans
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFF", 2));
    }
}
