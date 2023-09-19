import java.util.ArrayList;

public class cycleUn {
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
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 4));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));
    graph[1].add(new Edge(1, 4));
    
    graph[2].add(new Edge(2, 1));
    graph[2].add(new Edge(2, 3));


    graph[3].add(new Edge(3, 2));

    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));
    graph[4].add(new Edge(4, 5));


    graph[5].add(new Edge(5, 4));





}
    public static boolean dfs(ArrayList<Edge> graph[],boolean vis[],int curr,int parent){
        int V=graph.length;
        vis[curr]=true;
        // System.out.print(curr+"  ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e= graph[curr].get(i);
            if(vis[e.dest]==true && e.dest!= parent){
                return true;
            }
            else if(!vis[e.dest]){
              if (dfs(graph, vis, e.dest, curr)){
                  return true ;
              }

            }
        }

       return false ;
        }



            
        

        

    public static void main(String[] args) {
        //BFS
         int V =7;
        ArrayList<Edge> graph[]= new ArrayList[V];
        CreateGraph(graph);
        
        // sometimes we do have dis-connected graphs so neeed to  apply a different strategy
        boolean vis[]= new boolean[V];
        boolean ans;
       
        ans=dfs(graph,vis,0,-1);
        System.out.println("Cycle in undirected graph is : "+ ans);

        System.out.println();
    }
}