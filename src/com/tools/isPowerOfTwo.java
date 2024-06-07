package com.tools;

class isPowerOfTwo {

    /**
     * 是否是2的幂？
     *
     * @param num 数字
     * @return boolean
     */
    public static boolean isPowerOfTwo(int num) {
        // 检查 num 是否大于 0 且 (num & (num - 1)) 是否等于 0
        return num > 0 && (num & (num - 1)) == 0;
    }
}
