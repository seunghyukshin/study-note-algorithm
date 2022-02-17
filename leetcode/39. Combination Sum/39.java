class Solution {
    Set<List<Integer>> set = new HashSet<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        dfs(candidates, target, target);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> li : set){
            ans.add(li);
        }
        return ans;
    }
    
    private void dfs(int[] candidates, int target, int rest) {
        if(rest == 0){
            List<Integer> temp = new ArrayList<>();
            for(int i : list){
                temp.add(i);
            }
            Collections.sort(temp);
            set.add(temp);
            return;
        }
        
        for(int i = 0; i < candidates.length; i++){
            if(rest - candidates[i] >= 0){
                // System.out.println(rest +" "+ i + " " + list.toString());

                list.add(candidates[i]);
                dfs(candidates, target, rest - candidates[i]);  
                list.removeLast();
            } 
        }
        
    }
}