import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {
    static int V;
    static Vertex[] vertices;
    static List<Edge> edges = new ArrayList<Edge>();
    static List<Edge> mst = new ArrayList<Edge>();
    private static double mstValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        vertices = new Vertex[V];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            vertices[i] = new Vertex(x, y);
        }

        _initEdges();
        _kruskal();

//        System.out.println(mst.toString());
        System.out.printf("%.2f", mstValue);


    }

    private static void _kruskal() {
        Collections.sort(edges);
//        System.out.println(edges.toString());
        UnionFind uf = new UnionFind();
        for (Edge e : edges) {
            if (uf.union(e.from, e.to)) {
                mst.add(e);
                mstValue += e.weight;
            }
        }
    }

    private static void _initEdges() {
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                edges.add(new Edge(i, j, _calcWeight(vertices[i], vertices[j])));
            }
        }
    }

    private static double _calcWeight(Vertex v1, Vertex v2) {
        return Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));
    }

    private static class Vertex {
        double x, y;

        public Vertex(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight > o.weight) {
                return 1;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    private static class UnionFind {
        int[] parent;

        public UnionFind() {
            parent = new int[V];
            for (int i = 0; i < V; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int a, int b) {
            int pa = _find(a);
            int pb = _find(b);

            if (pa == pb) return false;

            parent[pa] = pb;
            return true;
        }

        private int _find(int x) {
            if(parent[x] != x) parent[x] = _find(parent[x]) ;
            return parent[x];
        }
    }
}
