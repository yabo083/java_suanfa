package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 这四道题都涉及给并查集带点小属性数组。<br />
 * <hr>
 * 再改造一点三个方法。<br />
 * <hr>
 * 核心逻辑阐述一下。<br />
 * 像是病毒传播的过程。<br />
 * 0号病人可在一开始就传播一人。<br />
 * 然后这两人在第一阶段（同一时刻）的会议中相继传播更多人，<br />
 * 对应并查集的行为就是无条件把更多人拉入他们的集合。<br />
 * <hr>
 * 主要处理逻辑是分阶段进行的，<br />
 * 每个阶段把因开会而划归到同一集合中的人再度分开。<br />
 * 依据是 病毒的或逻辑。<br />
 * <hr>
 * 也就是只要开过会，两个人的属性集合就会或一下，共享状态。<br />
 * 随后只需再度遍历该阶段开过会的人选，<br />
 * 访问他们的属性集合就可以知道到底感染没有。<br />
 * 据此设置或重置每个元素的并查集。<br />
 * <hr>
 * 之后l指针跃迁到r+1的位置，继续下一阶段的判断。<br />
 * <hr>
 * 最后就是遍历all people，<br />
 * 根据其属性数组的值列一个list名单出来。<br />
 * 返回即可。<br />
 *
 * @author Yabo
 * @date 2024/09/02
 */
class lc2092_FindAllPeopleWithSecret {

    public static int MAXN = 100001;

    public static int[] father = new int[MAXN];

    // 集合的标签信息 : 设置集合的一些属性
    // 属性在哪？secret[代表元素] 代表集合的属性
    public static boolean[] secret = new boolean[MAXN];

    public static void build(int n, int first) {
        // 1. 第一步初始化
        for (int i = 0; i < n; i++) {
            father[i] = i;
            secret[i] = false;
        }
        // 2. 第二步初始化，0号专家一开始就知道，然后他又让first也知道了。
        father[first] = 0;
        secret[0] = true;
    }

    // 目的是找i的根
    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
            // 核心逻辑，或一下，状态共享
            secret[fy] |= secret[fx];
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // 1. 初始化并查集结构
        build(n, firstPerson);
        // 2. 按会议时间排序会议
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        // 3. 获取会议数量
        int m = meetings.length;
        // 4. for循环，结束后人群只有知晓秘密或不知晓秘密两种。
        // 这里不要用idea的fori，因为l的步进我们要手动控制！
        for (int l = 0, r; l < m;) {
            r = l;
            // 	1. 用while框定一个阶段，该阶段中会议都是同一时刻进行。
            while (r + 1 < m && meetings[l][2] == meetings[r + 1][2]) {
                r++;
            }
            // 	2. 用for先行合并该阶段中所有参加会议的专家至同一集合。
            // 遍历的范围是[l, r]，包括边界！
            for (int i = l; i <= r; i++) {
                union(meetings[i][0], meetings[i][1]);
            }
            // 	3. 用for分离两种状态的人群。
            // 	不知晓秘密的并查集设置为初始状态。
            for (int i = l; i <= r; i++) {
                int a = meetings[i][0];
                int b = meetings[i][1];
                // 用根来决断，更为保险！
                if (!secret[find(a)]) {
                    father[a] = a;
                }
                if (!secret[find(b)]) {
                    father[b] = b;
                }
            }
            // 	4. l跃迁至r+1。
            l = r + 1;
        }
        // 5. for遍历统计所有人，将知晓秘密者加入list名单。
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (secret[find(i)]) {
                list.add(i);
            }
        }
        return list;

    }
}
