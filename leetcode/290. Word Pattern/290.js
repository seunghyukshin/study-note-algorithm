/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
// abba, dog dog dog dog
const wordPattern = function (pattern, s) {
  const n = pattern.length;
  const sp = s.split(" ");

  if (sp.length !== n) return false;

  const map = new Map();
  const map2 = new Map();
  for (let i = 0; i < n; i++) {
    const value = map.get(pattern[i]);
    const value2 = map2.get(sp[i]);
    console.log(pattern[i], sp[i], value, value2);
    if ((!value && value2) || (value && !value2)) return false;
    else if (value && value2) {
      if (value2 !== pattern[i] || value !== sp[i]) return false;
    } else {
      //!value && !value2
      map.set(pattern[i], sp[i]);
      map2.set(sp[i], pattern[i]);
    }
  }
  return true;
};
