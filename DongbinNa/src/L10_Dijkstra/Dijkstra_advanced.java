package L10_Dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra_advanced {
    static int[] d = new int[10];
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {

    }

    private static class Node {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int dist = node.dist;

            if (d[index] < dist) continue;

            ArrayList<Node> list = graph.get(index);
            for (Node nextNode : list) {
                int nextIndex = nextNode.index;
                int nextDist = nextNode.dist;

                if (nextDist < d[nextIndex]) {
                    d[nextIndex] = nextDist;
                    pq.offer(new Node(nextIndex, nextDist));
                }
            }

//            for (int i = 0; i < graph.get(now).size(); i++) {
//
//                int index = graph.get(now).get(i).index;
//                int cost = graph.get(now).get(i).dist;
//
//                if (cost < d[index]) {
//                    d[index] = cost;
//                    pq.offer(new Node(index, cost));
//                }
//            }
        }

    }


}
