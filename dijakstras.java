import java.util.ArrayList;
import java.util.PriorityQueue;


public class dijakstras {

        static class Edge{
            int src;
            int dest;
            int w;
            public Edge(int src, int dest, int w) {
                this.src = src;
                this.dest = dest;
                this.w = w;
            }  }
      
        public static void CreateGraph(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                graph[i]= new ArrayList<Edge>();
            }
            graph[0].add(new Edge(0, 1,2));
            graph[0].add(new Edge(0, 2,4));
        
            graph[1].add(new Edge(1, 3,7));
            graph[1].add(new Edge(1, 2,1));

            
            graph[2].add(new Edge(2, 4,3));

        
        
            graph[3].add(new Edge(3, 5,1));
        
            graph[4].add(new Edge(4, 3,2));
            graph[4].add(new Edge(4, 5,5));
        }
          
        public static class Pair implements Comparable<Pair>{// This class will give the distance of the node from src
             int node;
             int dist;
            public Pair(int node, int dist) {
                this.node = node;
                this.dist = dist;
            }
            @Override
            public int compareTo(Pair p2) {

                return this.dist - p2.dist;
            }

        }

            public static void djks(ArrayList<Edge> graph[], int src){
               int V= graph.length;
               int dist[]= new int[V];
               for (int i = 0; i < dist.length; i++) {
                if(i!=src){
                   dist[i]=Integer.MAX_VALUE;
                }
               }
               boolean vis[]= new boolean[V];
               PriorityQueue<Pair> pq= new PriorityQueue<>();
               pq.add(new Pair(src,0));
               while(!pq.isEmpty()){
               Pair p= pq.remove();
               if(!vis[p.node]){

                   vis[p.node]=true;
                   for (int i = 0; i < graph[p.node].size(); i++) {
                    Edge e= graph[p.node].get(i);
                    int u=e.src;
                    int v= e.dest;
                    if(dist[u]+e.w<dist[v]){
                        dist[v]=dist[u]+e.w;
                        pq.add(new Pair(v,dist[v]));
                    }
                    
                   }
               }

            }
            for (int i = 0; i < V; i++) {
                System.out.print(dist[i]+" ");
            }
            System.out.println();

 }



              

            
    public static void main(String[] args) {
         int V =6;
        ArrayList<Edge> graph[]= new ArrayList[V];
        CreateGraph(graph);
        djks(graph, 0);


    }

   
}
