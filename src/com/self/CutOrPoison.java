package com.self;

/**
 * 题意理解：<br />
 * 在指定回合，直伤还是毒伤，这是一个收益问题<br />
 * 但无论如何回合到了都得死，<br />
 * 这就限制了你不能说在开始几个回合打出高额毒伤，<br />
 * 怪得数个回合才能死，而你说怪已经在这回合“死”了，<br />
 * 虽然实质上是这样的，但不符合题目要求啊。<br />
 * 要求的是真死！<br />
 * <hr>
 * 好在，我经过思考，确认了实际上不存在这种情况哈哈。<br />
 * <hr>
 * 1. 欲求：至少多少回合——一个点<br />
 * 2. 扩展：[0, n+hp+1]<br />
 * 理论上你在任意回合打出毒伤，随后就算不攻击，<br />
 * 怪也会在n+hp+1回合之前死去，而实际必不可能如此，<br />
 * 所以确实是一个笼罩了可能回合的范围<br />
 * 3. 判断：在指定回合数下，怪能被干掉吗？<br />
 * 能？尝试更少的回合数！史官记这个<br />
 * 不能？遗憾增大回合数<br />
 * <hr>
 * 4. f函数：在指定回合数下，怪能被干掉吗？<br />
 * 算法：for循环指定回合数，在直伤和毒伤中取最大，<br />
 * 何时hp归0，则立即返回true、<br />
 * for循环结束，则返回false。<br />

 *
 * @author Yabo
 * @date 2024/06/28
 */
public class CutOrPoison {

    // 动态规划方法(只是为了验证)
    // 目前没有讲动态规划，所以不需要理解这个函数
    // 这个函数只是为了验证二分答案的方法是否正确的
    // 纯粹为了写对数器验证才设计的方法，血量比较大的时候会超时
    // 这个方法不做要求，此时并不需要理解，可以在学习完动态规划章节之后来看看这个函数
    public static int fast1(int[] cuts, int[] poisons, int hp) {
        int sum = 0;
        for (int num : poisons) {
            sum += num;
        }
        int[][][] dp = new int[cuts.length][hp + 1][sum + 1];
        return f1(cuts, poisons, 0, hp, 0, dp);
    }

    // 不做要求
    public static int f1(int[] cuts, int[] poisons, int i, int r, int p, int[][][] dp) {
        r -= p;
        if (r <= 0) {
            return i + 1;
        }
        if (i == cuts.length) {
            if (p == 0) {
                return Integer.MAX_VALUE;
            } else {
                return cuts.length + 1 + (r + p - 1) / p;
            }
        }
        if (dp[i][r][p] != 0) {
            return dp[i][r][p];
        }
        int p1 = r <= cuts[i] ? (i + 1) : f1(cuts, poisons, i + 1, r - cuts[i], p, dp);
        int p2 = f1(cuts, poisons, i + 1, r, p + poisons[i], dp);
        int ans = Math.min(p1, p2);
        dp[i][r][p] = ans;
        return ans;
    }

    // 二分答案法
    // 最优解
    // 时间复杂度O(n * log(hp))，额外空间复杂度O(1)
    public static int fast2(int[] cuts, int[] poisons, int hp) {
        // 1. 创建答案变量（因为找最小，所以初始化为最大值
        int ans = Integer.MAX_VALUE;
        // 2. for循环二分
        for (int l = 0, r = hp + 1 , mid; l <= r; ) {
            mid = l + ((r - l) >> 1);
            if (f(cuts, poisons, hp, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 3. 返回答案
        return ans;
    }

    // cuts、posions，每一回合刀砍、毒杀的效果
    // hp：怪兽血量
    // limit：回合的限制
    public static boolean f(int[] cuts, int[] posions, long hp, int limit) {
        // 1. 综合手牌数和实际限制数，确定到底出招几回合
        int n = Math.min(cuts.length, limit);
        // 注意这并不是怪实际死亡的回合，可以有等待轮空的回合，
        // 等着怪毒死就行
        // 2. for循环，流程简述：
        //     1. hp减去直伤和毒伤最大者
        //     2. 每轮检查hp是否归0，归0即返回true
        for (int i = 0, j = 1; i < n; i++, j ++) {
            hp -= Math.max(cuts[i], (long)(limit - j) * (long) posions[i]);
            if (hp <= 0) {
                return true;
            }
        }
        // 3. 请返回false
        return false;
    }

    // 对数器测试
    public static void main(String[] args) {
        // 随机测试的数据量不大
        // 因为数据量大了，fast1方法会超时
        // 所以在数据量不大的情况下，验证fast2方法功能正确即可
        // fast2方法在大数据量的情况下一定也能通过
        // 因为时间复杂度就是最优的
        System.out.println("测试开始");
        int N = 30;
        int V = 20;
        int H = 300;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] cuts = randomArray(n, V);
            int[] posions = randomArray(n, V);
            int hp = (int) (Math.random() * H) + 1;
            int ans1 = fast1(cuts, posions, hp);
            int ans2 = fast2(cuts, posions, hp);
            if (ans1 != ans2) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    // 对数器测试
    public static int[] randomArray(int n, int v) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (Math.random() * v) + 1;
        }
        return ans;
    }

}
