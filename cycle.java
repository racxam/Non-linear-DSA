import java.util.ArrayList;

public class cycle {
     static class Edge{
        int src;
        int dest;

        Edge(int src ,int dest){
           this.src=src;
           this.dest=dest;

        }

   };
   public static void CreateGraph(ArrayList<Edge> graph[]){
    for (int i = 0; i < graph.length; i++) {
        graph[i]= new ArrayList<Edge>();
    }

    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 0));

    
    graph[2].add(new Edge(2, 3));



    graph[3].add(new Edge(3, 0));


}
public static boolean dfsCycle(ArrayList<Edge> graph[], boolean vis[], boolean rec[],int curr){
   vis[curr]=true;
   rec[curr]=true;

   for (int i = 0; i < graph[curr].size(); i++) {
    Edge e= graph[curr].get(i);
    if(!rec[e.dest]){
        return true;
    }
    else if(!vis[e.dest]){
        dfsCycle(graph, vis, rec, e.dest);
    }
   }
   rec[curr]=false;
   return false;



}
    public static void main(String[] args) {
        int V =4;
        ArrayList<Edge> graph[]= new ArrayList[V];
        CreateGraph(graph);
       boolean ans= dfsCycle(graph, new boolean[V], new boolean[V], 0);
       System.out.println(ans);

        
    }
}
