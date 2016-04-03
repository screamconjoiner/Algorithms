package graph;

/**
 * Prim's algorithm for minimum spanning tree.
 * Every case: O(n^2)
 * T(n) = 2(n-1)(n-1)
 * @author Connor
 */
public class Prims {
    
    public Prims() {
        
    }
    
    
    /**
     * startEdge, endEdge, weight
     * @param W
     * @return int[][] where int[i][0] = startNode // node
     *                       int[i][1] = endNode // vertex
     *                       int[i][2] = weight
     */
    public static int[][] getMST(int[][] W) {
        // TODO: Check if W is a matrix
          
        
        int n = W[0].length;
        int[][] F = new int[W[0].length-1][3]; // list of edges to be returned.
        // Y is the set of nodes, which I guess is contained in F.
        int numEdges = 0;
                
        // Edge is startEdge, endEdge, weight (a[0], a[1], a[2])
        int vnear = 0; // index of nearest node
        double min = Double.POSITIVE_INFINITY; // value // thanks book for infinity
        int[] nearest = new int[W[0].length]; // index
        int[] distance = new int[W[0].length]; // value
        
        // Grab the edge values for v1, our starting vertex.
        for (int i = 1; i < n; i++) {
            nearest[i] = 0; // 0 is our starting index 
            distance[i] = W[0][i];
        }
        for (int i = 0; i < n-1; i++) { // repeat n-1 times
            min = Double.POSITIVE_INFINITY; // value // thanks book for infinity
            
            for (int j = 1; j < n; j++) { // Check each vertex for being nearest
                                           // to Y (current vertex)
                if (0 <= distance[j] && distance[j] < min) {
                    min = distance[j];
                    vnear = j;
                }                
            }
            // Add this edge to F
            F[numEdges] = new int[]{vnear,nearest[vnear],W[vnear][nearest[vnear]]}; 
            numEdges++;
            distance[vnear] = -1;
            
            // Add vertex indexed by vnear to Y.
            // For each vertex not in Y, update it's distance from Y.
            for (int j = 1; j < n; j++) {
                if (W[j][vnear] < distance[j]) {
                    distance[j] = W[j][vnear];
                    nearest[j] = vnear;
                }
            }            
        }
        return F;
    }
    
    public static int getTotalWeight(int[][] edges) {
        
        int weight = 0;
        for (int[] e : edges) {
            weight += e[2];
        }
                
        return weight;
    }
    
}