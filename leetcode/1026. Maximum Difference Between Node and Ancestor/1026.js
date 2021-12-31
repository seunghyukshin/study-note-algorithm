/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
const maxAncestorDiff = function (root) {
  let v = 0;
  const search = (min, max, node) => {
    min = Math.min(min, node.val);
    max = Math.max(max, node.val);
    v = Math.max(v, max - min);

    if (node.left !== null) search(min, max, node.left);
    if (node.right !== null) search(min, max, node.right);
  };
  search(Infinity, -Infinity, root);
  return v;
};
