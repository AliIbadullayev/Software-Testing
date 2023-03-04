package test.company.lab1.util;

import java.util.Arrays;
import java.util.LinkedList;

public class BreadthFirstSearch {

    private int V;
    private LinkedList<Integer>[] adj;

    private int[] parent;

    private boolean[] visited;

    private BreadCrumbs breadCrumbs;




    public BreadthFirstSearch(int v, BreadCrumbs breadCrumbs) {
        V = v;
        this.breadCrumbs = breadCrumbs;
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
        breadCrumbs.addQueueCrumb(s);

        while (queue.size() != 0) {
            s = queue.poll();
            breadCrumbs.pollQueueCrumb(s);



            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    parent[n] = s;
                    queue.add(n);
                    breadCrumbs.addQueueCrumb(n);

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

    public BreadCrumbs getBreadCrumbs() {
        return breadCrumbs;
    }
}
