package com.leetcode;

/**
 * 利用二维前缀和信息迅速得到二维区域和
 * <br>
 * 流程还是先构建，再使用。
 * <br>
 * 只不过因为多了“添0行和添0列”，所以多了一些步骤
 * <br>
 * 公式很好理解：
 * <br>
 * 1. 明白求的当前位置的前缀和具体对应什么意义？
 * <br>
 * cur += 左一 + 上一 - 左上角
 * <br>
 * 2. 如何使用前缀和来获取指定区域的和？
 * <br>
 * 区域右下 - 区域左下偏1 - 区域右上偏1 + 左上角偏2
 * <br>
 * （注：偏1的意思是行或列向指定方向缩1）
 *
 * @author Yabo
 * @date 2024/06/24
 */
class NumMatrix {

	public int[][] sum;

    public NumMatrix(int[][] matrix) {
    	// 1. 获取原矩阵行数
        int n = matrix.length;
    	// 2. 获取原矩阵列数
        int m = matrix[0].length;
    	// 3. 创建一个添0行和0列后的前缀专用矩阵
        sum = new int[n + 1][m + 1];
    	// 4. 一个for循环，解决转移拷贝和前缀和的构造
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
            	// 5. 逐个元素赋值
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	// 0. 多说一句，这里的形参都是对应原矩阵的，但某种意义上，也是可以利用的
    	// 1. 给row2和col2++，使映射到我们前缀和矩阵正确的位置
        row2++;
        col2++;
    	// 2. 随后就是用公式返回正确的值的时间了
        return sum[row2][col2] - sum[row1][col2] - sum[row2][col1] + sum[row1][col1];

    }
}
