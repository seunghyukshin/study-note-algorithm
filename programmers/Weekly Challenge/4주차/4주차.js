const solution = (table, languages, preference) => {
  const scores = [];
  table.map((i) => {
    const [title, ...langs] = i.split(" ");
    const c = i.split(" ");
    console.log(typeof title);
    console.log(langs);
    let score = 0;
    c.map((j, jdex) => {
      languages.filter((l, index) => {
        if (l === j) {
          score += (6 - jdex) * preference[index];
          return true;
        }
        return false;
      });
    });
    scores.push({ name: c[0], score });
  });
  const sort = (array) => {
    return array.sort((a, b) => b.score - a.score - (a.name < b.name));
  };
  return sort(scores)[0].name;
};

// const table = [
//   "SI JAVA JAVASCRIPT SQL PYTHON C#",
//   "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
//   "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
//   "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
//   "GAME C++ C# JAVASCRIPT C JAVA",
// ];
// const languages = ["PYTHON", "C++", "SQL"];
// const preference = [7, 5, 5];

const table = [
  "SI JAVA JAVASCRIPT SQL PYTHON C#",
  "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
  "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
  "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
  "GAME C++ C# JAVASCRIPT C JAVA",
];
const languages = ["JAVA", "JAVASCRIPT"];
const preference = [7, 5];
const answer = solution(table, languages, preference);

console.log(answer);
