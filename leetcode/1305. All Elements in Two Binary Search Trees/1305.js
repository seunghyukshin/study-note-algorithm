/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {number[]}
 */
const getAllElements = function (root1, root2) {
  const answer = [];
  const search = (node) => {
    if (node === null) return;
    answer.push(node.val);

    if (node.left !== null) {
      search(node.left);
    }
    if (node.right !== null) {
      search(node.right);
    }
  };
  search(root1);
  search(root2);
  return answer.sort((a, b) => a - b);
};
