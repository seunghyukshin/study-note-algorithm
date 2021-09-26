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

  const result = array
    .sort(
      (a, b) =>
        winrate[b] - winrate[a] ||
        overweight[b] - overweight[a] ||
        weights[b] - weights[a] ||
        a - b
    )
    .map((i) => i + 1);
  return result;
};
