const solution = (word) => {
  const WORDS = ["A", "E", "I", "O", "U"];
  const array = [];
  const dfs = (i, string, finish) => {
    if (i == 5 || finish) {
      array.push(string);
      return;
    }

    for (let j = 0; j < 5; j++) {
      if (i != 4) {
        dfs(i + 1, string + WORDS[j], true);
      }
      dfs(i + 1, string + WORDS[j], false);
    }
  };

  dfs(0, "", false);
  array.sort((a, b) => a - b);
  return array.findIndex((el) => el === word) + 1;
};

const word = "I";
console.log(solution(word));
