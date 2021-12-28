/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
const middleNode = function (head) {
  const array = [];

  const search = (node) => {
    array.push(node.val);
    if (node.next === null) return;
    search(node.next);
  };
  search(head);

  const mid = Math.floor(array.length / 2);

  let count = 0;
  let answer = null;
  const runToMid = (node) => {
    if (count === mid) {
      answer = node;
      return;
    }
    count++;
    runToMid(node.next);
  };
  runToMid(head);
  return answer;
};
