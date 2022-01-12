// Runtime : 116ms, 95.2%
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
  const newNode = new TreeNode(val);
  if (!root) {
    return newNode;
  }
  if (root.val < val) {
    if (!root.right) {
      root.right = newNode;
      return root;
    } else {
      insertIntoBST(root.right, val);
    }
  } else {
    if (!root.left) {
      root.left = newNode;
      return root;
    } else {
      insertIntoBST(root.left, val);
    }
  }

  return root;
};
