/**
 * @param {string} word
 * @return {boolean}
 */
const detectCapitalUse = function (word) {
  // const case1 = /[A-Z]+/;
  // const case2 = /[a-z]+/;
  // const case3 = /[A-Z][a-z]+/;
  // return (
  //   word.replace(case1, "") === "" ||
  //   word.replace(case2, "") === "" ||
  //   word.replace(case3, "") === ""
  // );

  // very fast
  return word.replace(/^[A-Z]+$|^[a-z]+$|^[A-Z][a-z]+$/, "") === "";
};

// const word = "USA";
const word = "leetCcode";
// const word = "Google";
const answer = detectCapitalUse(word);
console.log(answer);
