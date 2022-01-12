// Runtime : 252ms, 5%..
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
 * @param {number} val
 * @return {TreeNode}
 */
const insertIntoBST = function (root, val) {
  if (!root) return new TreeNode(val);
  const insert = (node, val) => {
    if (node.val > val) {
      if (node.left === null) node.left = new TreeNode(val);
      else insert(node.left, val);
    } else {
      if (node.right === null) node.right = new TreeNode(val);
      else insert(node.right, val);
    }
  };
  insert(root, val);
  return root;
};
