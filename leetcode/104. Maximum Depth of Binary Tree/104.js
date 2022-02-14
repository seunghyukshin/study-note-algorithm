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
const maxDepth = function (root) {
  if (!root) return 0;
  let answer = 1;

  // bfs
  const queue = [{ node: root, count: 1 }];
  while (queue.length !== 0) {
    const el = queue.shift();
    answer = el.count;
    if (el.node.left) queue.push({ node: el.node.left, count: el.count + 1 });
    if (el.node.right) queue.push({ node: el.node.right, count: el.count + 1 });
  }
  // dfs
  //   const search = (node, count) => {
  //     // console.log(count, node);
  //     answer = Math.max(answer, count);
  //     if (node.left) search(node.left, count + 1);
  //     if (node.right) search(node.right, count + 1);
  //     return;
  //   };
  //   search(root, 1);
  return answer;
};
