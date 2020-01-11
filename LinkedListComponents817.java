/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinkedListComponents817 {
    public int numComponents(ListNode head, int[] G) {
        if (head == null || G == null) return 0;
        Set<Integer> set = new HashSet<>();
        
        for (int g: G) {
            set.add(g);
        }
        
        int count = 0;
        while (head != null) {
            // we do not want to calculate the duplicate count incase the head.next != null
            // so we ignore the current node and not increment, if the head.val and head.next.val
            // are both in the HashSet. When we move to the next node untill we hit a case where
            // we encounter the end of the element in the connected component and then increment
            // for example 0->1->2->3->4->5->6->null is the LList and G = {0, 1, 2, 3, 6}. The 
            // connected components are [0, 1, 2, 3] & [6]. So when we start at 0 we need to go all
            // the way to 3 before incrementing our connected component.
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                count++;
            }
            head = head.next;
        }
        
        return count;
    }
}