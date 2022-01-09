class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int d = 0;
    int[] point = {0,0};
    public boolean isRobotBounded(String instructions) {
        boolean answer = false;
        for(int i = 0; i < 4; i++){
            for(char c : instructions.toCharArray()){
                if(c=='G'){
                    point[0] = point[0] + dx[d];
                    point[1] = point[1] + dy[d];
                }else if(c == 'L'){
                    d--;
                    if(d < 0) d=3;
                }else{
                    d++;
                    if(d==4) d=0;
                }
            }
            if(point[0] == 0 && point[1] == 0) return true;
        }
        return answer;
    }
}