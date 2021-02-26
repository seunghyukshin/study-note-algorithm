/**
 * @param {string} s
 * @return {string}
 */
//1044. Longest Duplicate Substring
var longestDupSubstring = function(s) {
	let max = 0;
	let result = "";
	for (let i = 0; i < s.length - max; i++) {
		for (let j = i; j < s.length;) {
			const sub = s.substring(i, j + max + 1);
			const index = s.indexOf(sub, i + 1);
			if (index === -1)
				break;
			if (max < sub.length) {
				max = sub.length;
				result = sub;
			} else {
				j++;
			}
		}
	}

	return result;
};