package com.leetcode;

class lc2166 {

    private int[] set;
    private int size;
    private int zeros, ones;
    private boolean reverse;

    public lc2166(int size) {
        set = new int[(size + 31) / 32];
        this.size = size;
        zeros = size;
        ones = 0;
        reverse = false;
    }

    public void fix(int idx) {
        int index = idx / 32;
        int bit = idx % 32;
        if (!reverse){
            if ((set[index] & (1 << bit)) == 0){
                zeros --;
                ones ++;
                set[index] |= (1 << bit);
            }
        } else {
            if ((set[index] & (1 << bit)) != 0){
                zeros --;
                ones ++;
                set[index] ^= (1 << bit);
            }
        }
    }

    public void unfix(int idx) {
        int index = idx / 32;
        int bit = idx % 32;
        if (!reverse){
            if ((set[index] & (1 << bit)) != 0){
                ones --;
                zeros ++;
                set[index] ^= (1 << bit);
            }
        } else {
            if ((set[index] & (1 << bit)) == 0){
                ones --;
                zeros ++;
                set[index] |= (1 << bit);
            }
        }
    }

    public void flip() {
        reverse = !reverse;
        int tmp = ones;
        ones = zeros;
        zeros = tmp;
    }

    public boolean all() {
        return ones == size;
    }

    public boolean one() {
        return ones > 0;
    }

    public int count() {
        return ones;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, k = 0, number, status; i < size; k++) {
            number = set[k];
            for (int j = 0; j < 32 && i < size; j++, i++) {
                status = (number >> j) & 1;
                status ^= reverse ? 1 : 0;
                builder.append(status);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        lc2166 obj = new lc2166(10);
        obj.fix(1);
        obj.fix(2);
        obj.fix(3);
        obj.fix(4);
        obj.fix(5);
        obj.fix(6);
        obj.fix(7);
        obj.fix(8);
        obj.fix(9);
        obj.fix(0);
        System.out.println(obj.toString());
        obj.flip();
        System.out.println(obj.toString());
        obj.unfix(1);
        obj.unfix(2);
        obj.unfix(3);
        obj.unfix(4);
        obj.unfix(5);
        obj.unfix(6);
        obj.unfix(7);
        obj.unfix(8);
        obj.unfix(9);
        obj.unfix(0);
        System.out.println(obj.toString());
        obj.flip();
        System.out.println(obj.toString());
    }
}

/**
 * Your lc2166 object will be instantiated and called as such:
 * lc2166 obj = new lc2166(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
