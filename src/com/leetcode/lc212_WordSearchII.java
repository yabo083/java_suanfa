package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class lc212_WordSearchII {

    // 试出来的，tmd
    public static int MAXN = 10001;
    public static int[][] tree = new int[MAXN][26];
    public static int[] pass = new int[MAXN];
    // 唯一值得说的就是尾数组的意义：这道题存的是以此结尾的字符串，想想看，很方便吧？
    public static String[] end = new String[MAXN];
    public static int cnt;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void build(String[] words) {
        // 1. md，cnt初始化的工作挪到这儿了
        cnt = 1;
        // 2. for循环，依次吧单词表里的字符串录进去
        for (String word : words) {
            // 3. 具体来说，先来个局部变量，作为每个节点的临时指针
            int cur = 1;
            pass[cur]++;
            // 4. 再来个for循环，把每个字符串的每个字符抠出来，然后放进路径信息数组里看看指向哪个节点，如果没有那就新建，然后转移过去，记得记录路过信息。
            for (int j = 0, path; j < word.length(); j++) {
                path = word.charAt(j) - 'a';
                if (tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path];
                pass[cur]++;
            }
            // 5. inner for 完了，把这回的字符串存入尾数组里。
            end[cur] = word;
        }
    }

    public static int dfs(char[][] board, int i, int j, int t, List<String> ans) {
        // 1. 经典递归，先确定边界条件：如果作为矩阵坐标的i和j越界，或者指向了重复的坐标，那就返回0（意义是这一次探索，收集到了0个字符串）
        if (i < 0 || j < 0 || i == board.length || j == board[i].length || board[i][j] == 0) {
            return 0;
        }
        // 2. 经过了上面的考验，用char类型的变量取出当前坐标的字符
        char tmp = board[i][j];
        // 3. 随后将其放置到先前构建好的前缀树上，尝试是否可从当前递归层特定的前缀树节点向下延伸？
        t = tree[t][tmp - 'a'];
        // 4. 如果放入路过数组的结果为0，那说明此路不通，返回0
        if (pass[t] == 0) {
            return 0;
        }
        // 5. 如果有值，继续：初始化fix变量，准备记录从当前递归层的i和j坐标一共可收集多少个字符串？
        int fix = 0;
        // 6. 如果放入尾数组的结果不是空（字符串对象当然是拿空不空来衡量啦），那就fix++（这应该懂了吧？），同时贯穿所有递归层的ans收集此时的end，最后end再手动置空（总不能重复收集吧？？）
        if (end[t] != null) {
            fix++;
            ans.add(end[t]);
            end[t] = null;
        }
        // 7. 为了之后的递归不再再次经过此递归层的i和j坐标，手动给矩阵的（i，j）处置零（这里对应的实际字符应该是空字符）。
        board[i][j] = 0;
        // 8-11. 向上下左右四个方向递归（总觉得用有更优雅的写法？向量！）fix要连续记录每个递归返回来的值
        for (int k = 0; k < 4; k++) {
            fix += dfs(board, i + dx[k], j + dy[k], t, ans);
        }
        // 12. 路过信息数组要不要减去fix呢？（收集到了，尾数组都置空了，你路过不删说不过去了，本质是一种主动遗忘。）
        pass[t] -= fix;
        // 13. 四个方向的递归结束后，矩阵（i，j）处要恢复（幸好之前记了）（此举是为了符合题目要求：同一个单元格内的字母在一个单词中不允许被重复使用。）（但在不同的单词中，应该是可以重复使用的！这也是为什么要恢复原值的原因，别妨碍下一次单词寻找啊！）（而且虽然不同的单词查找可能会经过同样的坐标，但某个位置的尾数组早已被之前的取走，这次的只能望洋兴叹，含恨而终）
        board[i][j] = tmp;
        // 14. 返回fix喽。
        return fix;

    }

    public static void clear() {
        // 1. 呃呃呃……用了多少清多少，不多说了
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
            end[i] = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        // 1. 根据words构建前缀树，（tmd昏昏沉沉的才看出来
        build(words);
        // 2. 初始化答案数组ans
        List<String> ans = new ArrayList<>();
        // 3. 最简单的遍历二维数组，对每个元素进行dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, 1, ans);
            }
        }
        // 4. 清理，以便下一组用例正常
        clear();
        // 5. 返回答案
        return ans;
    }
}
