package com.leetcode;

import java.util.HashMap;

class lc146_LRUCache {

  private HashMap<Integer, DoubleNode> map;
  private DoubleList nodeList;
  private int cap;

  public lc146_LRUCache(int capacity) {
    // 1. map初始化
    map = new HashMap<>();
    // 2. nodeList初始化
    nodeList = new DoubleList();
    // 3. cap = capacity;
    cap = capacity;
  }

  public int get(int key) {
    // 1. 如果key存在
    // 2. 从map拿到
    // 3. 同时调moveNodeToTail方法
    // 4. 返回其值
    // 5. 不在返回-1就好
    if (map.containsKey(key)) {
      DoubleNode ans = map.get(key);
      nodeList.moveNodeToTail(ans);
      return ans.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    // 1. 如果已经在
    // 2. 先拿到
    // 3. 更新值
    // 4. 调用moveNodeToTail方法
    // 5. 如果不在，先看看缓存满没满？
    // 6. 满了，先从双向链表中移除，然后再从map中移除
    // 7. 总之到了这一步，LRU有了足够的空间，
    // 8. 新建node
    // 9. map存入
    // 10. 链表添加
    if (map.containsKey(key)) {
      DoubleNode node = map.get(key);
      node.val = value;
      nodeList.moveNodeToTail(node);
    } else {
      if (map.size() == cap) {
        map.remove(nodeList.removeHead().key);
      }
      DoubleNode newNode = new DoubleNode(key, value);
      map.put(key, newNode);
      nodeList.addNode(newNode);
    }
  }

  static class DoubleNode {
    // 1. 存值的val
    public int val;
    // 2. 存键的key
    public int key;
    // 2. 前向指针l
    public DoubleNode l;
    // 3. 后向指针r
    public DoubleNode r;

    // 4. 构造函数

    public DoubleNode(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  static class DoubleList {
    // 1. 头指针
    public DoubleNode head;
    // 2. 尾指针
    public DoubleNode tail;

    // 3. 构造方法

    public DoubleList() {
      this.head = null;
      this.tail = null;
    }

    // 4. 用于将节点添加至双向链表的末尾
    public void addNode(DoubleNode newNode) {
      // 1. 如果新节点为空，则直接返回
      if (newNode == null) return;
      // 2. 如果头指针为空，则头和尾指针一并定位到这个新节点上
      //     否则，就是一般情况了：
      //     将新节点插入尾部，涉及原始尾节点与新尾节点的互联和尾指针的移动
      if (head == null) {
        head = newNode;
        tail = newNode;
      } else {
        tail.r = newNode;
        newNode.l = tail;
        tail = newNode;
      }
    }

    // 5. 实现LRU的核心
    public void moveNodeToTail(DoubleNode node) {
      // 1. 如果本次访问节点就是尾节点，那么直接返回
      if (node == tail) {
        return;
      }
      // 2. 如果本次访问节点就是头节点，那么想办法把头节点插入尾节点后，
      //     这里先断开前缘：涉及头指针的移动，以及指使头指针所指节点的前向指针为空；
      //     如果本次访问节点是一般节点，则就是一般的双向链表的节点删除过程
      if (head == node) {
        head = head.r;
        head.l = null;
      } else {
        node.l.r = node.r;
        node.r.l = node.l;
      }
      // 3. 这里才是接后世因：涉及本次访问节点前向与后向指针的设置和尾指针的指使动作与移动。
      node.r = null;
      node.l = tail;
      tail.r = node;
      tail = node;
    }

    // 6. 实现LRU的核心二！
    public DoubleNode removeHead() {
      // 1. 如果头指针为空，那么也直接返回空
      if (head == null) return null;
      // 2. 暂存头节点
      DoubleNode ans = head;
      // 3. 如果头尾节点相等，则说明只有一个节点(此时等效的LRU缓存只有一个格子哈哈)
      //     头尾节点同时指空就好
      if (head == tail) {
        head = null;
        tail = null;
      } else {
        // 4. 否则，头指针移动到紧接着的下一个节点，将互联的关系断开
        head = head.r;
        head.l = null;
        ans.r = null;
      }
      // 5. 返回答案
      return ans;
    }
  }
}
