package com.leetcode;

/**
 * 题目比喻：
 * <br>
 * 联合国做平衡：
 * <br>
 * 先给大家现在拥有的资源做个序列，
 * <br>
 * 然后按序把资源所有权拿到自己手里，
 * <br>
 * 如果每种资源都达到标准啦，
 * <br>
 * 则说明可以通过合理分配给大家再分，使各家平衡。
 * <br>
 * 拓展：
 * <br>
 * 如果资源的种类不止4种，比例也不是平均，也能做！
 *
 * @author Yabo
 * @date 2024/06/26
 */
class lc1234_ReplaceTheSubstringForBalancedString {

    public static boolean ok(int[] cnts, int require) {
        for (int i = 0; i < 4; i++) {
            if (cnts[i] > require) {
                return false;
            }
        }
        return true;
    }

    public int balancedString(String s) {
        // 1. 获取序列长度
        int n = s.length();
        // 2. 创建值映射数组，长度就是序列长度
        int[] map = new int[n];
        // 3. 创建窗口外资源频数数组
        int[] cnts = new int[4];
        // 4. for循环，开始填装上面两个数组
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map[i] = c == 'W' ? 1 : c == 'E' ? 2 : c == 'R' ? 3 : 0;
            cnts[map[i]]++;
        }
        // 5. 创建“标准”
        int require = n / 4;
        // 6. 创建答案变量，初始化为序列长度，
        // 毕竟在题目已经保证标准和序列长度的关系后，
        // 改全部一定能达标！
        int ans = n;
        // 7. for循环，主要流程：
        //     1. while循环，在未将所有资源拿到手的情况下，
        //     凭此时窗口的资源数量，能不能做主？
        //     不能就继续按序列吃资源，能就可以退出了
        //     2. 再if二次确定下，确保不是吃光所有资源还没平衡的那种情况，
        //     如果不是，更新ans；如果是的话，可以直接break了，至于原因：
        //     这就是绝对不平衡的情况。
        //     3. 归还窗口左端点的资源，到这儿，
        //     你应该能看出来这是主打一个全遍历的过程。
        for (int l = 0, r = 0; l < n; l++) {
            while (r < n && !ok(cnts, require)) {
                cnts[map[r++]]--;
            }
            if (ok(cnts, require)) {
                // 额，区间是[l, r)，你想想就知道了
                ans = Math.min(ans, r - l);
            } else {
                break;
            }
            cnts[map[l]]++;
        }
        // 8. 返回答案
        return ans;
    }


}
