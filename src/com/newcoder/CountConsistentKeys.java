package com.newcoder;

import java.util.Arrays;

/**
 * 实质上，是找前缀出现了多少次的问题
 *
 * 先把a数组的每行特征值转换成字符串存入前缀树，然后再把b数组的每行特征值转换成字符串，在前缀树中查找。
 *
 * 大概就是这么回事
 *
 * @author Yabo
 * @date 2024/06/13
 */
public class CountConsistentKeys {

    public static int MAXN = 2000001;
    // 之所以是12，还是有说法的
    public static int[][] tree = new int[MAXN][12];
    // 是的，这会只要路过数组
    public static int[] pass = new int[MAXN];
    public static int cnt;

    public static int path(char cha) {
        // 0. 映射器函数，专门用来处理非数字以外的字符该映射到第几位
        // 1. 如果是分隔符，那就是10
        if (cha == '#') {
            return 10;
        }
        // 2. 如果是负数的-号，那就是11
        else if (cha == '-') {
            return 11;
        }
        // 3. 如果是普通的数字字符，那就减‘0’获得实际的ASCII码值
        else {
            return cha - '0';
        }
    }

    public static void insert(String word) {
        // 1. 初始化临时的节点指针
        int cur = 1;
        // 2. 二话不说，先记录路过信息
        pass[cur]++;
        // 3. for循环，把word的每个字符依次扣出，交予path方法，获得其对应的路径，然后看看tree里有没有，没有就新建；
        // 随后临时的节点指针顺势跳至下一节点，同时也记录一手路过信息。（嗯完了，因为没有end要处理
        for (int i = 0; i < word.length(); i++) {
            int path = path(word.charAt(i));
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
    }

    public static int count(String pre) {
        // 1. 初始化临时的节点指针
        int cur = 1;
        // 2. for循环，把word的每个字符依次扣出，交予path方法，获得其对应的路径，然后看看tree里有没有，没有直接返回0；
        // 随后临时的节点指针顺势跳至下一节点，
        for (int i = 0; i < pre.length(); i++) {
            int path = path(pre.charAt(i));
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        // 3. 返回此处的路过信息
        return pass[cur];
    }

    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param b int整型二维数组
     * @param a int整型二维数组
     * @return int整型一维数组
     */
    public int[] countConsistentKeys(int[][] b, int[][] a) {
        // 1. 利用StringBuilder构建a数组的每行对应的字符串
        StringBuilder sb = new StringBuilder();
        for (int[] num : a) {
            sb.setLength(0);
            for (int i = 1; i < num.length; i++) {
                sb.append(num[i] - num[i - 1]).append("#");
            }
            // 2. 插入前缀树中
            insert(sb.toString());
        }
        // 3. 初始化答案数组，长度是b数组的行数
        int[] ans = new int[b.length];
        // 4. 重复利用StringBuilder构建b数组的每行对应的字符串
        for (int i = 0; i < b.length; i++) {
            sb.setLength(0);
            int[] num = b[i];
            for (int j = 1; j < num.length; j++) {
                sb.append(num[j] - num[j - 1]).append("#");
            }
            // 5. 在前缀树中查找
            ans[i] = count(sb.toString());
        }
        // 6. 清理
        clear();
        // 7. 返回答案
        return ans;
    }


}
