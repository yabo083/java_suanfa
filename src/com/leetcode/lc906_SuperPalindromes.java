package com.leetcode;

import java.util.ArrayList;
import java.util.List;

class lc906_SuperPalindromes {

    public static long[] arr = {1L, 4L, 9L, 121L, 484L, 10201L, 12321L, 14641L, 40804L, 44944L, 1002001L, 1234321L,
        4008004L, 100020001L, 102030201L, 104060401L, 121242121L, 123454321L, 125686521L, 400080004L, 404090404L,
        10000200001L, 10221412201L, 12102420121L, 12345654321L, 40000800004L, 1000002000001L, 1002003002001L,
        1004006004001L, 1020304030201L, 1022325232201L, 1024348434201L, 1210024200121L, 1212225222121L, 1214428244121L,
        1232346432321L, 1234567654321L, 4000008000004L, 4004009004004L, 100000020000001L, 100220141022001L,
        102012040210201L, 102234363432201L, 121000242000121L, 121242363242121L, 123212464212321L, 123456787654321L,
        400000080000004L, 10000000200000001L, 10002000300020001L, 10004000600040001L, 10020210401202001L,
        10022212521222001L, 10024214841242001L, 10201020402010201L, 10203040504030201L, 10205060806050201L,
        10221432623412201L, 10223454745432201L, 12100002420000121L, 12102202520220121L, 12104402820440121L,
        12122232623222121L, 12124434743442121L, 12321024642012321L, 12323244744232321L, 12343456865434321L,
        12345678987654321L, 40000000800000004L, 40004000900040004L, 1000000002000000001L, 1000220014100220001L,
        1002003004003002001L, 1002223236323222001L, 1020100204020010201L, 1020322416142230201L, 1022123226223212201L,
        1022345658565432201L, 1210000024200000121L, 1210242036302420121L, 1212203226223022121L, 1212445458545442121L,
        1232100246420012321L, 1232344458544432321L, 1234323468643234321L, 4000000008000000004L};


    /**
     * 生成只有指定数一半位数的最小数字
     *
     * @param number 数
     * @return int
     */
    public static int generateMinHalfNDigitNumber(long number) {
        // 计算数字的位数
        int numDigits = (int) Math.log10(number) + 1;
        // 计算一半的位数，向上取整
        int halfDigits = (numDigits + 1) / 2;
        // 生成一个1后跟随halfDigits-1个0的数字
        return (int) Math.pow(10, halfDigits - 1);
    }

    /**
     * 扩展偶数或奇数位的回文串
     *
     * @param seed   种子
     * @param isEven 是偶数？
     * @return long
     */
    public static long evenOrOddEnlarge(long seed, boolean isEven) {
        // 1. 先保存一个seed的副本。
        long ans = seed;
        // 2. 随后如果是扩成偶数长度那就不必提前除以进制，使用一个if语句作区分吧
        if (!isEven) {
            seed /= 10;
        }
        // 3. 又一个while循环，如果种子没空，就一直循环
        while (seed > 0) {
            // 4. 总的来说，就是把seed的每个 数位的数，依次添加到副本的尾部，这样就能构造回文串。（形象化描述一下：副本向前挪动，seed割下尾数，两个一加，seed再用除法真正割下）
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        // 5. 返回经过改造的副本
        return ans;
    }

    /**
     * 检查是不是要求的回文数？
     *
     * @param ans 答案
     * @param l   左边界
     * @param r   右边界
     * @return boolean
     */
    public static boolean check(long ans, long l, long r) {
        // 1. 就是判断ans是不是在[l, r]范围的回文串
        // 2. 在不在范围好说，关键是怎么快速判断一个很长的数是不是回文串？
        return l <= ans && ans <= r && isPalindrome(ans);
    }

    /**
     * 是否是回文？
     *
     * @param num 数字
     * @return boolean
     */
    public static boolean isPalindrome(long num) {
        // 1. 一个对齐模具
        long offset = 1;
        // 2. 一个奇特的while循环，让模具与num真正对齐，这里也认知到如果两个数做除法的商只剩一位，那说明，两个数位数一致了。
        while (num / offset >= 10) {
            offset *= 10;
        }
        // 3. 又一个while循环，只要num还不为0就一直循环
        while (num > 0) {
            // 4. 取num首尾，然后比较，如果不等，那就不是回文串（%：像个漏勺，%10的话，你只会获得从0落下的数；/：像个刀，/10的话，会果断地切掉0所对应的那一位，返回之前的所有数字）
            if (num % 10 != num / offset) {
                return false;
            }
            // 5. 随后真把num首尾削掉，模具也削两位（而且因为模具数就高位是1，所以直接每次除100得了）
            num = (num % offset) / 10;
            offset /= 100;
        }
        // 6. 能完成第5步，就可以返回true了。
        return true;
    }


    public static List<Long> collect() {
        // 1. 打表也学一学，感觉自己不会打表，打出来也不会用。
        // 2. 因为这个题的巧合性，超级回文串在整个long范围都没几个，所以就人为设定好l=1（是的，我们不要0），r = Long.MAX_VALUE，随后根据上面的superpalindromesInRange()改写过程就行了，这回不是统计个数，而是实实在在的记录具体的num，存到一个List里，排个序后输出就行了。
        long l = 1;
        long r = Long.MAX_VALUE;
        // 3. 初始化一个List
        List<Long> list = new ArrayList<>();
        // 4. 初始化一个种子
        long seed = 1;
        // 5. 初始化一个num
        long num = 0;
        // 6. 初始化一个limit
        long limit = (long) Math.sqrt((double) r);
        // 7. while循环，探索所有的超级回文串
        while (num < limit) {
            // 7.1 先探索偶数长度回文数
            num = evenOrOddEnlarge(seed, true);
            if (check(num * num, l, r)) {
                list.add(num * num);
            }
            // 7.2 再探索奇数长度回文数
            num = evenOrOddEnlarge(seed, false);
            if (check(num * num, l, r)) {
                list.add(num * num);
            }
            // 7.3 种子递进
            seed++;
        }
        list.sort(Long::compareTo);
        // 8. 返回List
        return list;
    }

    public static int superPalindromesInRange2(String left, String right) {
        // 0. 由collect()可以获取所有的super回文串，事先执行一遍，事先记录到一个静态数组里，力求最快调用速度
        // 1. 随后，l、r记录转成long的left和right
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        // 2. l从左向右遍历，r从右向左遍历，直到各自的分界点停止，随后统计i和j之间的数字个数，返回答案。

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= l) {
                l = i;
                break;
            }
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] <= r) {
                r = j;
                break;
            }
        }
        // 3. l、r可能就是super回文数，也可能不是，但以他们为界可以划出一个大于l，小于r的部分，这段区间就是我们要的，而且更进一步，退出的时候正好肯定两个局部变量正好在[l, r]之内。
        return (int) (r - l + 1);
    }

    public static void main(String[] args) {
//        // 1. 打表
//        List<Long> list = collect();
//        // 打印list
//        for (Long aLong : list) {
//            System.out.println(aLong+"L,");
//        }
//        // 2. 初始化一个数组
//        arr = new long[list.size()];
//        // 3. 把list里的元素放到数组里
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = list.get(i);
//        }
        // 4. 测试
        System.out.println(new lc906_SuperPalindromes().superPalindromesInRange("4","1000"));
    }

    /**
     * 求指定范围内的超级回文数
     *
     * @param left  左边界
     * @param right 右边界
     * @return int  有几个？
     */
    public int superPalindromesInRange(String left, String right) {
        // 1. 因为left和right尚在long可以容纳的范围内，所以就先转成long
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        // 2. 获取右端点开方后的值，这将作为真正使用的限制。
        long rlimit = (long) Math.sqrt(r);
        long llimit = (long) Math.sqrt(l);
        // 3. 种子从1开始
        long seed = generateMinHalfNDigitNumber(llimit);
        // 4. 初始化一个num，这将作为真正数开方后的值
        long num = 0;
        // 5. 初始化计数器
        int ans = 0;
        // 6. while循环，依次先探索由种子生成的偶数长度回文数是否满足要求？然后探索由种子生成的奇数长度回文数是否满足要求？满足就计数器加加。
        //     随后种子按1的步履递进
        //     直到生成的奇数长度的回文数超出限制，才结束循环
        while (num < rlimit) {
            // 6.1 先探索偶数长度回文数
            num = evenOrOddEnlarge(seed, true);
            if (check(num * num, l, r)) {
                ans++;
            }
            // 6.2 再探索奇数长度回文数
            num = evenOrOddEnlarge(seed, false);
            if (check(num * num, l, r)) {
                ans++;
            }
            // 6.3 种子递进
            seed++;
        }
        // 7. 返回答案
        return ans;
    }
}
