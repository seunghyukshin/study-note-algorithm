// 2 pointer
/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
const checkInclusion = function (s1, s2) {
  if (s1.length > s2.length) return false;
  const map = new Map();

  const isSubstring = () => {
    for (const [key, value] of map) {
      if (value !== 0) return false;
    }
    return true;
  };

  for (let i = 0; i < s1.length; i++) {
    map.set(s1[i], map.get(s1[i]) ? map.get(s1[i]) + 1 : 1);
  }
  let left = 0,
    right = 0;

  while (right !== s1.length) {
    map.set(s2[right], map.get(s2[right]) ? map.get(s2[right]) - 1 : -1);
    right++;
  }
  if (isSubstring()) return true;
  while (right !== s2.length) {
    map.set(s2[right], map.get(s2[right]) ? map.get(s2[right]) - 1 : -1);
    map.set(s2[left], map.get(s2[left]) + 1);
    // console.log(map);
    if (isSubstring()) return true;
    left++;
    right++;
  }
  return false;
};

// const s1 = "abc",
//   s2 = "bbbca";
const s1 = "aab",
  s2 = "eaacaab";

const ans = checkInclusion(s1, s2);
console.log(ans);
