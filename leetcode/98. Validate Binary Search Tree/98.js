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
 * @return {boolean}
 */
var isValidBST = function (root) {
  let isvalid = true;

  const find = (root, min, max) => {
    if (!isvalid) return;
    if (root === null) return;

    if (min < root.val && root.val < max) {
    } else {
      isvalid = false;
      return;
    }
    find(root.left, min, Math.min(max, root.val));
    find(root.right, Math.max(min, root.val), max);
  };
  find(root, -Infinity, Infinity);
  return isvalid;
};
