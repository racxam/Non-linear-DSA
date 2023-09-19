import java.util.ArrayList;

public class bellman {
     static class Edge{
        int src;
        int dest;
        int w;
        public Edge(int src, int dest, int w) {
            this.src = src;
            this.dest = dest;
            this.w = w;
        }
        
     }
     
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        bell(graph,0);
    }
/// main method Ended

    private static void bell(ArrayList<Edge>[] graph,int src) {
        int V= graph.length;
        boolean vis[]=  new boolean[V];
        int dist[]= new int[V];
        for (int i = 0; i < dist.length; i++) {
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;

            }
        }
        for (int j = 0; j < V-1; j++) {
            for (int k = 0; k < V; k++) {
                for (int z = 0; z < graph[k].size(); z++) {
                    
                    Edge e= graph[k].get(z);
                    int u= e.src;
                    int v = e.dest;
                    if(dist[u]+e.w<dist[v]){
                        dist[v]= dist[u]+e.w;

                    }
                }
            }
            
        }


      
        boolean show=true;
        // This is for the detection of the negative weight cycle

        for (int k = 0; k < V; k++) {
                for (int z = 0; z < graph[k].size(); z++) {
                    
                    Edge e= graph[k].get(z);
                    int u= e.src;
                    int v = e.dest;
                    if(dist[u]+e.w<dist[v]){
                        System.out.println("The negative cycle detected");
                        show=false;


                    }
                }
            }
            // this is for the printing of the distances;
            if(show){

            for (int i = 0; i < V; i++) {
              System.out.print(dist[i]+" ");
            }
            System.out.println();
        }

    }

    private static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i]= new ArrayList<>();

        }
       graph[0].add(new Edge(0, 1, 2));
       graph[0].add(new Edge(0, 2, 4));
       
       graph[0].add(new Edge(1, 2, -4));
       
       graph[0].add(new Edge(2, 3, 2));
       
       graph[0].add(new Edge(3, 4, 4));
       
       graph[0].add(new Edge(4, 1, -1));// change -1 to 10 to detect negative edge cycle
       

    }
}