/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
const wordPattern = function (pattern, s) {
  const n = pattern.length;
  const sp = s.split(" ");

  if (sp.length !== n) return false;
  const makePattern = (str) => {
    const result = [];
    for (let i = 0; i < str.length; i++) {
      result.push(str.indexOf(str[i]));
    }
    return result.join("");
  };
  return makePattern(pattern) === makePattern(sp);
};
const pattern = "abba",
  s = "dog cat cat dog";
// s = "dog dog dog dog";
// s = "b a a b b";
const answer = wordPattern(pattern, s);
console.log(answer);
``;
