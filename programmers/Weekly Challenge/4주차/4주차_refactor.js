const solution = (table, languages, perference) => {
  return table
    .map((r) => r.split(" "))
    .map((r) => [
      r[0],
      r
        .map((u, i) =>
          languages.includes(u) ? perference[languages.indexOf(u)] * (6 - i) : 0
        )
        .reduce((a, b) => a + b),
    ])
    .sort((a, b) => b[1] - a[1] - (a[0] < b[0]))[0][0];
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
