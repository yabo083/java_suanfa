package com.leetcode;

import java.util.Arrays;

/**
 * 这题逻辑性很强。<br /> 属于是该怎样就怎样，给你安排得明明白白。<br /> 先算不嗑药情况下田忌赛马式一个工人能完成多少任务。<br /> 一个就算成了。<br /> 随后如果有人卡住，暂时没有他能干的活，那就得嗑药了。<br
 * /> 磕了药能干就按上面的规则继续干。<br /> 不能干或者药丸嗑完了直接就宣告这次预定的计划无法完成。<br />
 * <hr>
 * 涉及：二分做法+贪心的思想+单调队列的结构<br />
 *
 * @author Yabo
 * @date 2024/08/28
 */
class lc2071_MaximumNumberOfTasksYouCanAssign {

    public static int[] ts;

    public static int[] ws;

    public static int MAXN = 50001;

    public static int[] deque = new int[MAXN];

    public static int h, t;

    /**
     * f
     *
     * @param tl    强度最低的几个任务左端点
     * @param tr    强度最低的几个任务右端点
     * @param wl    强度最高的几个工人左端点
     * @param wr    强度最高的几个工人右端点
     * @param s     药的效果
     * @param pills 药的数量
     * @return boolean
     */
    public static boolean f(int tl, int tr, int wl, int wr, int s, int pills) {
        // 1. 单调队列结构参数初始化
        h = t = 0;
        // 2. 设置已使用的药丸数量
        int cnt = 0;
        // 3. for循环，负责循环工人
        for (int i = wl, j = tl; i <= wr; i++) {
            //     1. 内层for循环，负责循环任务，并接着把任务加进队列
            for (; j <= tr && ts[j] <= ws[i]; j++) {
                deque[t++] = j;
            }
            //     2. 挑一个完成，如果可以，头指针顺利++
            if (h < t && ts[deque[h]] <= ws[i]) {
                h++;
            } else {
                //     3. 如果不可以，就在接下来的for里吃药再审视任务一遍，把变得可以的任务加进队列
                for (; j <= tr && ts[j] <= ws[i] + s; j++) {
                    deque[t++] = j;
                }
                //     4. 如果队列中有了可完成的任务，用药数++，且尾指针左移以示服药者主动承担责任，做要求较高的任务。
                if (h < t) {
                    cnt++;
                    t--;
                    //     5. 如果不可以，直接失败！
                } else {
                    return false;
                }
            }
        }
        // 5.循环结束，检查用药数是否大于原药丸数。
        return cnt <= pills;

    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // 1. 工人和任务数组全局变量化
        ts = tasks;
        ws = workers;
        // 2. 排序
        Arrays.sort(ts);
        Arrays.sort(ws);
        // 3. 分别获取长度
        int tsize = ts.length;
        int wsize = ws.length;
        // 4. 设置答案变量
        int ans = 0;
        // 5. for循环，二分得出最后答案。
        //     1. 范围[0, min(工人数量，任务数量)]
        for (int l = 0, r = Math.min(tsize, wsize), m; l <= r; ) {
            //     2. 中点m，意味着这次计划是完成m个任务
            m = (l + r) / 2;
            //     3. f函数(从头选任务，从尾选工人，药丸效果，药丸数量)
            if (f(0, m - 1, wsize - m, wsize - 1, strength, pills)) {
                // 成功！
                ans = m;
                l = m + 1;
            } else {
                // 失败！
                r = m - 1;
            }
        }
        // 6. 返回答案
        return ans;
    }


}
