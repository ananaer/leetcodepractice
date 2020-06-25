//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计

package design;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
      public static void main(String[] args) {
          LRUCache cache = new LRUCache(2);
          cache.put(1,1);
          cache.put(2,2);
          cache.put(3,3);
          cache.get(1);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      static class LRUCache {
          // 容量
          private int capacity;
          // Map结构帮助在O(1)时间内找到元素
          Map<Integer, Node> map;
          // 双向链表结构帮助在O（1）时间内加入、删除元素
          DoubleList doubleList;
          // 当前元素个数
          int count;
          class Node{
              public int key,val;
              public Node pre,next;
              public Node(int k, int v) {
                  this.key = k;
                  this.val = v;
              }
          }

          class DoubleList{
              Node head,tail;
              public  DoubleList(){
                  head = new Node(0,0);
                  tail = new Node(0,0);
                  head.next = tail;
                  tail.pre = head;
              }
              // 加入节点到头部
              public void addFirst(Node n){

                  n.pre = head;
                  n.next = head.next;

                  head.next.pre = n;
                  head.next = n;


              }
              // 删除某个元素
              public void remove(Node n){
                  Node pre = n.pre;
                  Node next = n.next;

                  pre.next = next;
                  next.pre = pre;
              }

              public void moveToHead(Node n){
                  remove(n);
                  addFirst(n);
              }
              // 删除最后一个元素,并返回
              public Node removeLast(){
                  Node last = tail.pre;
                  remove(last);
                  return last;
              }
          }

          public LRUCache(int capacity) {
              this.capacity = capacity;
              this.map = new HashMap();
              this.doubleList = new DoubleList();
              this.count = 0;
          }

          public int get(int key) {
              Node node = map.get(key);
              if(node == null){
                  return -1;
              }
              doubleList.moveToHead(node);
              return node.val;
          }

          public void put(int key, int value) {
              Node node = map.get(key);

              if(node != null){
                  node.val=value;
                  doubleList.moveToHead(node);
              }else{

                  node = new Node(key,value);
                  doubleList.addFirst(node);
                  map.put(key,node);
                  count++;
                  if(count > capacity){
                      Node last = doubleList.removeLast();
                      map.remove(last.key);
                      count--;
                  }
              }
          }

      }
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }