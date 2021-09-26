const solution = (weights, head2head) => {
  const array = new Array(weights.length).fill(0).map((v, i) => (v += i));
  const winrate = head2head
    .map((i) => i.split(""))
    .map(
      (r) =>
        (r =
          r.filter((i) => i === "W").length / r.filter((i) => i !== "N").length)
    );

  const overweight = head2head
    .map((i) => i.split(""))
    .map(
      (r, i) =>
        (r = r.filter((v, j) => v === "W" && weights[j] > weights[i]).length)
    );

  const result = array.sort((a, b) => {
    if (winrate[b] > winrate[a]) return 1;
    else if (winrate[b] < winrate[a]) return -1;
    else if (overweight[b] > overweight[a]) return 1;
    else if (overweight[b] < overweight[a]) return -1;
    else if (weights[b] > weights[a]) return 1;
    else if (weights[b] < weights[a]) return -1;
    else if (b < a) return 1;
    else -1;
  });
  return result;
};

const weights = [50, 82, 75, 120];
const head2head = ["NLWL", "WNLL", "LWNW", "WWLN"];

// const weights = [145, 92, 86];
// const head2head = ["NLW", "WNL", "LWN"];
const answer = solution(weights, head2head);

console.log(answer);

// 1. filter 안에서
// 2. sort 기준이 같을때 두개 이상의 기준 두는 것..
