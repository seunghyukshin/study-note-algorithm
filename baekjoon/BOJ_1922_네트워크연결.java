import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ_1922_네트워크연결 {
    static int V, E;
    static List<Edge> edges = new ArrayList<Edge>();
    static List<Edge> mst = new ArrayList<Edge>();
    static int mstValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(x == v) continue;
            edges.add(new Edge(x, v, w));
        }

        _kruskal();
        //System.out.println(mst.toString());
        System.out.println(mstValue);
    }

    private static void _kruskal() {
        Collections.sort(edges);

        UnionFind uf = new UnionFind();
        for(Edge e : edges) {
            if(uf.union(e.from, e.to)) {
                mst.add(e);
                mstValue += e.weight;
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static class UnionFind {
        int[] parent;
        public UnionFind() {
            parent = new int[V + 1];

            for (int i = 1; i < V + 1; i++) {
                parent[i] = i;
            }
        }


        public boolean union(int a, int b) {
            int pa = _find(a);
            int pb = _find(b);

            if(pa == pb ) return false;
            parent[pa] = pb;
            return true;
        }

        private int _find(int x) {
            if(parent[x] != x) parent[x] = _find(parent[x]);
            return parent[x];
        }
    }
}
