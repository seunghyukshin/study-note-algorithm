/**
 * @param {string} word
 * @return {boolean}
 */
const detectCapitalUse = function (word) {
  return (
    word === word.toUpperCase() ||
    word === word[0] + word.substring(1).toLowerCase()
  );
};

// const word = "USA";
const word = "leetCcode";
// const word = "Google";
const answer = detectCapitalUse(word);
console.log(answer);
