/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import graph.Grapher;
import graph.SimpleSparseGraph;
import hw.Prims;
import graph.SimpleWeightedGraph;
import hw.Ch4n6;
import hw.Kruskals;
import java.util.Arrays;

/**
 *
 * @author Connor
 */
public class GraphLauncher {
    
    public static void main(String[] args) {
/*        Graph g = new Graph(2);
        System.out.println(g.1));*/
       prims();
       //connected();
       kruskals();
    }
    
    public static void ch3() {
        
        /*int[][] W = {{0,8,13,18,20},
                     {3,0,7,8,10},
                     {4,11,0,10,7},
                     {6,6,7,0,11},
                     {10,6,2,1,0}
        };
        int[][] edges = Ch4n2.getMSTPrims(W);        


        //int[][] edges = ProblemsCGraph.getOptimalCircuit(W);
        System.out.println(Arrays.deepToString(edges));
        System.out.println(Grapher.getMSTWeight(edges));*/
    }
    
    // Chapter 4, no 2, 6
    public static void prims() {
        SimpleWeightedGraph g = new SimpleWeightedGraph(10);
        g.addEdge(0,1,32);
        g.addEdge(0,3,17);
        g.addEdge(3,2,18);
        g.addEdge(2,6,5);
        g.addEdge(6,7,59);
        g.addEdge(7,3,3);
        g.addEdge(3,4,10);
        g.addEdge(4,1,45);
        g.addEdge(4,5,28); 
        g.addEdge(4,8,25);        
        g.addEdge(8,9,12);        
        g.addEdge(9,5,6);        
        g.addEdge(7,8,4);
        System.out.println(Arrays.deepToString(g.getEdges()));
        int[][] F = Prims.getMST(g);
        System.out.println(Arrays.deepToString(F));
        System.out.println("Is connected?: " + Prims.isConnected(F));
        System.out.println("Total cost: " + Grapher.getMSTWeight(F));
        
    }
    public static void kruskals() {
        SimpleSparseGraph g = new SimpleSparseGraph(13);
        g.addEdge(0,1,32);
        g.addEdge(0,3,17);
        g.addEdge(3,2,18);
        g.addEdge(2,6,5);
        g.addEdge(6,7,59);
        g.addEdge(7,3,3);
        g.addEdge(3,4,10);
        g.addEdge(4,1,45);
        g.addEdge(4,5,28); 
        g.addEdge(4,8,25);        
        g.addEdge(8,9,12);        
        g.addEdge(9,5,6);        
        g.addEdge(7,8,4);
        int[][] F = Kruskals.getMST(g, 10);
        System.out.println(Arrays.deepToString(F));        
        System.out.println("Total cost: " + Grapher.getMSTWeight(F));
    }
        


}
