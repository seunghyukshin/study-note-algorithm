/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(ListNode node : lists){
            while(node != null){
                pq.add(node.val);
                node = node.next;
            }
        }
        if(pq.size() == 0) return null;
        ListNode answer = new ListNode(pq.poll());
        while(!pq.isEmpty()){
            int value = pq.poll();
            ListNode temp = new ListNode(value);
            temp.next = answer;
            answer = temp;
        }
        return answer;
    }
}