package L16_TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_TopologicalSorting {
    static int N, E;
    static ArrayList[] graph;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        inDegree = new int[N + 1];

        for (int i = 0; i < E; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            graph[a].add(b);
            inDegree[b]++;
        }

        queue.add(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);

            List<Integer> list = graph[node];
            for (int nextNode : list) {
                inDegree[nextNode]--;
                if (inDegree[nextNode] == 0){
                    queue.offer(nextNode);
                }
            }

        }


    }
}
/**
 * 7
 * 8
 * 1 2
 * 1 5
 * 2 3
 * 3 4
 * 5 6
 * 2 6
 * 6 4
 * 4 7
 */