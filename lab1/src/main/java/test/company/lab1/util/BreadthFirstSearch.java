package test.company.lab1.util;

import java.util.Arrays;
import java.util.LinkedList;

public class BreadthFirstSearch {

    private int V; // No. of vertices
    private LinkedList<Integer>[] adj; // Adjacency Lists

    private int[] parent;

    private boolean[] visited;

    // Constructor
    public BreadthFirstSearch(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) { adj[v].add(w); }

    // prints BFS traversal from a given source s
    public void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        visited = new boolean[V];
        parent = new int[V];
        Arrays.fill(parent,-1);

        // Create a queue for BFS
        LinkedList<Integer> queue
                = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued
            // vertex s If a adjacent has not been visited,
            // then mark it visited and enqueue it
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    parent[n]=s;
                    queue.add(n);
                }
            }
        }
//        System.out.println();
//        System.out.println("visited:");
//        for (boolean b : visited) {
//            System.out.print(b+" ");
//        }
//        System.out.println();
//        System.out.println("parents:");
//        for (int i : parent) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
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
