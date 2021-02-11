/**
 * @param {number[]}
 *            nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    // numbs.sort() : 오름차순 아니다.
    nums.sort((a,b) => a-b);
    var list = [];
    if(nums.length < 3) return list;
    var p = 0;
    while(true){       
        var l = p + 1;
        var r = nums.length - 1;
        if(l == r) break;
        while(true){
            if(l == r) break;
            var sum = nums[p] + nums[l] + nums[r];
            if(sum > 0){
                r--;
            }else if(sum < 0){
                l++;
            }else{
                var temp = [nums[p], nums[l], nums[r]];
                list.push(temp);
                l++;
            }
        }
        p++;
    }
    
    // console.log(list);
    const result = list.filter((item, i) =>{
        return (
            list.findIndex((item2, j) => {
                return item.toString() === item2.toString();
            }) === i
        );
    });
    // console.log(result);
    
    return result;
};