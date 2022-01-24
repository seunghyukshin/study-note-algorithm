/**
 * @param {string} word
 * @return {boolean}
 */
const detectCapitalUse = function (word) {
  const isLowerCase = (c) => {
    return c >= "a" && c <= "z";
  };
  const isUpperCase = (c) => {
    return c >= "A" && c <= "Z";
  };

  let answer = true;
  if (isLowerCase(word[0])) {
    word.split("").map((v) => isUpperCase(v) && (answer = false));
  } else {
    for (let i = 1; i < word.length - 1; i++) {
      if (
        (isLowerCase(word[i]) && isLowerCase(word[i + 1])) ||
        (isUpperCase(word[i]) && isUpperCase(word[i + 1]))
      )
        continue;

      return false;
    }
  }

  return answer;
};

const word = "USA";
// const word = "LeeCtcode";
const answer = detectCapitalUse(word);
console.log(answer);
