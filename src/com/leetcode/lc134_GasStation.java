package com.leetcode;

class lc134_GasStation {

    /**
     * 题意理解：
     * <br>
     * 1. 净里程>0，才可作为起点，
     * <br>
     * 2. 如果中途失败，则可直接跳转失败节点+1的位置
     * <br>
     * 3. 每次失败，必然len从0和r要从l开始重新走
     * <br>
     * 4. 注意避免死循环，只要确保l只走一次全程，不能让l借着可以跳转的机会，
     * <br>
     * 开始反复执行。
     *
     * @param gas  气
     * @param cost 成本
     * @return int
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 1. 获取几个节点
        int n = gas.length;
        // 2. for循环，
        // 流程简述：
        //     1. 其实在测试以每个节点做起点能走完全程。
        //     2. while循环，如果净里程>=0，就视作合法，
        //     如果len此时已经达标，就直接返回起点
        //     r到下一个，
        //     len自增，
        //     净里程也相应改变（我测别说你不会）
        //     3. 是在净里程<0时，才做的操作：
        //     len归0，sum归0，l直接跳到r+1处，
        //     感觉可以写在for循环里。
        //     tmd特别注意：你得想办法让l只能走一遍全程，不然就是死循环！！
        for (int l = 0, r = 0, sum = 0, len = 0; l < n; l = r + 1, len = 0, sum = 0) {
            while (sum >= 0) {
                if (len == n) {
                    return l;
                }
                r = (l + (len++)) % n;
                sum += gas[r] - cost[r];
            }
            // 姑且这么限制住了，对于当时我举的两种情况到能满足，
            // 不过不知道为啥可以通用？
            // 总感觉限制了排除了一些情况，但事实告诉我，那些情况还真就不可能出现？！
            if (l + len >= n) {
                return -1;
            }
        }
        // 3. 如果上述过程完了，也没返回，请返回代表失败的-1
        return -1;
    }

    public static void main(String[] args) {
        //  测试：gas [2,3,4] cost [3,4,3]
        lc134_GasStation obj = new lc134_GasStation();
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(obj.canCompleteCircuit(gas, cost));

    }
}
