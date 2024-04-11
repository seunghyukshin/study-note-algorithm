package L13_UnionFind;

public class UnionFind {
    private static int v, e;
    private static int[][] edges = new int[e][3];
    private static int[] parent = new int[100001];

    public static int find(int x) {
//        if (x == parent[x]) return x;
//        return find(parent[x]);

        // 경로압축 ver
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }


    private static boolean isCycle() {
        boolean cycle = false;
        for (int i = 0; i < e; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (find(a) == find(b)) {
                cycle = true;
                break;
            } else {
                union(a, b);
            }
        }
        return cycle;
    }

    public static void main(String[] args) {

        boolean cycle = isCycle();

        if (cycle) {
            System.out.println("사이클 발생");
        } else {
            System.out.println("사이클 발생X");
        }

    }

}
