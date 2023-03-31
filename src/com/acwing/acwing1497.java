package com.acwing;

import java.util.*;

public class acwing1497 {

    static int N = 35;
    static int[] inorder = new int[N];
    static int[] postorder = new int[N];
    static Map<Integer, Integer> l = new HashMap<>(), r = new HashMap<>(), pos = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            postorder[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            inorder[i] = scanner.nextInt();
            pos.put(inorder[i], i);
        }

        int root = build(0, n - 1, 0, n - 1);

        bfs(root);
    }

    private static void bfs(int root) {
        Deque<Integer> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()){
            int t = bfs.pop();
            System.out.println(t + " ");
            if(l.containsKey(t))
                bfs.add(l.get(t));
            if(r.containsKey(t))
                bfs.add(r.get(t));
        }
    }

    private static int build(int il, int ir, int pl, int pr) {
        int root = postorder[pr];
        int k = pos.get(root);
        if(il < k ){
            l.put(root, build(il, k - 1, pl, pl + k - il - 1));
        }
        if(k < ir){
            r.put(root, build(k + 1, ir, pl + k - il - 1 + 1, pr - 1));
        }

        return root;
    }

}
