const solution = (want, number, discount) => {
  const addElement = (key) => {
    if (map.has(key)) {
      let value = map.get(key);
      map.set(key, value - 1);
    } else {
      map.set(key, -1);
    }
  };
  const removeElement = (key) => {
    if (map.has(key)) {
      let value = map.get(key);
      map.set(key, value + 1);
    } else {
      map.set(key, 1);
    }
  };
  const containsNonZero = () => {
    for (const v of map.values()) {
      if (v !== 0) {
        return true;
      }
    }
    return false;
  };

  const countSum = number.reduce((a, b) => a + b);

  const map = new Map();
  for (let i in want) {
    map.set(want[i], number[i]);
  }
  const startArray = discount.slice(0, countSum);

  for (let key of startArray) {
    addElement(key);
  }
  let result = 0;
  if (!containsNonZero()) {
    result++;
  }

  for (let i = 0; i < discount.length - countSum; i++) {
    removeElement(discount[i]);
    addElement(discount[i + countSum]);
    if (!containsNonZero()) {
      result++;
    }
  }

  return result;
};

const want = ["banana", "apple", "rice", "pork", "pot"];
const number = [3, 2, 2, 2, 1];
const discount = [
  "chicken",
  "apple",
  "apple",
  "banana",
  "rice",
  "apple",
  "pork",
  "banana",
  "pork",
  "rice",
  "pot",
  "banana",
  "apple",
  "banana",
];

const result = solution(want, number, discount);
console.log(result);
