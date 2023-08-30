package com.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 高精度计算工具类
 */

public class HPCUtils {

    /**
     * 默认的小数位数
     */
    private static final int DEFAULT_SCALE = 10;

    /**
     * 高精度加法运算
     *
     * @param a 加数
     * @param b 被加数
     * @return 和
     */
    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    /**
     * 高精度减法运算
     *
     * @param a 减数
     * @param b 被减数
     * @return 差
     */
    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    /**
     * 高精度乘法运算
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 积
     */
    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    /**
     * 高精度除法运算
     *
     * @param a 除数
     * @param b 被除数
     * @return 商
     */
    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        return a.divide(b, DEFAULT_SCALE, RoundingMode.HALF_UP);
    }

    /**
     * 高精度除法运算，同时返回商和余数
     *
     * @param a 除数
     * @param b 被除数
     * @return 商和余数数组，第一个元素是商，第二个元素是余数
     */
    public static BigDecimal[] divideAndRemainder(BigDecimal a, BigDecimal b) {
        return a.divideAndRemainder(b);
    }
}

