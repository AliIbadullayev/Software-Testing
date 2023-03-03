package test.company.lab1.util;

import java.util.Arrays;
import java.util.LinkedList;

public class BreadthFirstSearch {

    private int V;
    private LinkedList<Integer>[] adj;

    private int[] parent;

    private boolean[] visited;


    public BreadthFirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();

        visited = new boolean[V];
        parent = new int[V];

        Arrays.fill(parent, -1);
    }


    public void addEdge(int v, int w) {
        adj[v].add(w);
    }


    public void BFS(int s) {


        LinkedList<Integer> queue
                = new LinkedList<Integer>();


        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();


            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    parent[n] = s;
                    queue.add(n);
                }
            }
        }
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public int[] getParent() {
        return parent;
    }

    public boolean[] getVisited() {
        return visited;
    }
}
