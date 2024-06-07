package com.leetcode;

class lc52_NQueens {

    /**
     * 统计所有n皇后的解法总数
     *
     * @param n 皇后个数
     * @return int 解法总数
     */
    // 数组实现（虽然左神不推荐，但我还是学一下）
    public int totalNQueens1(int n) {
        // 1. 如果n < 1, 无解，直接返回0；
        if (n < 1)
            return 0;
        // 2. 否则返回调用子函数的值
        return f1(0, new int[n], n);
    }

    /**
     * 方法一
     *
     * @param i    代表行数
     * @param path 一个一维数组，下标代表行数，值代表列数，两者组合是个坐标哦！
     * @param n    恒定不变的皇后个数
     * @return int 答案数
     */
    public static int f1(int i, int[] path, int n) {
        // 1. 每种可能最后都会遇到的条件，也是最先应该考虑的递归退出条件：如果i行都各归其位，说明找到一种摆放方法。
        if (i == n)
            return 1;
        // 2. 如果不是就继续向下看呗
        // 3. 初始化答案寄存器
        int ans = 0;
        // 4. 开始对每列的for循环，至于行的步进在递归中体现，用不着特殊处理
        for (int j = 0; j < n; j ++) {
            // 5. 检查这个坐标能不能放？能就放，然后在能放的基础上递归
            if (check(path, i, j)) {
                path[i] = j;
                ans += f1(i + 1, path, n);
            }
            // 6. 不能就什么也不做，继续下一次for循环呗
        }
        // 7. 循环结束，返回答案寄存器的值
        return ans;
    }

    /**
     * 用于检查能不能放的辅助函数
     *
     * @param path 存储已经找到位置坐下的诸皇后的坐标
     * @param i    当前行数（准备放的）
     * @param j    当前列数
     * @return boolean
     */
    public static boolean check(int[] path, int i, int j) {
        // 1. 直接接一个for循环，检查的内容是：当前列有没有放？与每个已经找到位置坐下的皇后坐标两点联立得到的斜率绝对值是不是1？以上凡是有一个对那就返回false就行。
        for (int k = 0; k < i; k ++){
            if (j == path[k] || Math.abs(i - k) == Math.abs(j - path[k]))
                return false;
        }
        return true;
        // 2. 所有的都通过，才返回true。
    }

    public static int totalNQueens2(int n) {
        // 1. 如果n < 1, 无解，直接返回0；（tmd，其实是小于4都无解的，但是你架不住1皇后自己一个就行啊！）
        if (n < 1)
            return 0;
        // 2. 否则先预创建一个n皇后都各司其位的情况
        int limit = (1 << n) - 1;
        // 3. 随后返回调用递归子函数的值
        return f2(limit, 0, 0, 0);
    }

    /**
     * 方法二
     *
     * @param limit 应该有的皇后数量
     * @param col   列ban
     * @param md    主对角ban (\)
     * @param ad    反对角ban (/)(应该能懂？)
     * @return int  答案数
     */
    public static int f2(int limit, int col, int md, int ad) {
        // 1. 如果所有的col（列）都处理，那就意味着处理了整个棋盘（因为是个正方形），那就意味着我们得到了一种处理方法，返回1
        if (col == limit)
            return 1;
        // 2. 将三座大山以“|”联合，化作联BAN，这就是总限制（此时0代表空位可放，1代表已满不可放）
        int ban = col | ad | md;
        // 3. 将BAN的信息反转，再与limit“&”，除去不必要的指示信息，再存入一个局部变量，则其的二进制信息可以理解为1可放，0不可放（每个栈帧因为联ban的影响是不一样的）
        int can = limit & (~ban);
        // 4. 创建一个局部变量，象征“插入信标”（就是代表一个皇后被放置的位置）
        int place = 0;
        // 5. 初始化答案寄存器
        int ans = 0;
        // 6. while循环，目的在于尝试尽所有可放的位置
        while (can != 0){
            // 7. lowbit1算法，记得把取走的1归0，随后开始递归
            place = can & (-can);
            can ^= place;
            ans += f2(limit, col | place, (md | place) << 1, (ad | place) >> 1);
        }
        // 8. 返回答案寄存器
        return ans;
    }






}
