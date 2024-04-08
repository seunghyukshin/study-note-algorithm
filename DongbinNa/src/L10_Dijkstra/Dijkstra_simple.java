package L10_Dijkstra;

import java.util.ArrayList;

public class Dijkstra_simple {
    private class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static final int INF = (int) 1e9; // 10억(무한)

    // 노드갯수(N), 간선갯수(M), 시작노드번호(start)
    public static int N, M, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static Node[][] graph2 = new Node[100001][100001];
    public static boolean[] visited = new boolean[100001];
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int minValue = INF;
        int index = 0;
        for (int i = 1; i <= N; i++) {
            if (d[i] < minValue && !visited[i]) {
                minValue = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        d[start] = 0;
        visited[start] = true;

        for (int i = 0; i < graph.get(start).size(); i++) {
//            d[graph2[start][i].index] = graph2[start][i].distance;
            d[graph.get(start).get(i).index] = graph.get(start).get(i).distance;
        }

        for (int i = 0; i < N - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            for (int j = 0; j < graph.get(now).size(); j++) {
//                int cost = d[now] + graph2[now][j].distance;
                int cost = d[now] + graph.get(now).get(j).distance;

//                if(cost<d[graph2[now][j].index ]){
//                    d[graph2[now][j].index] = cost;
//                }
                if (cost < d[graph.get(now).get(j).index]) {
                    d[graph.get(now).get(j).index] = cost;
                }
            }
        }
    }


    public static void main(String[] args) {

    }
}
