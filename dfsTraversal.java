import java.util.ArrayList;

public class dfsTraversal {
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
    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 3));
    
    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 4));


    graph[3].add(new Edge(3, 1));
    graph[3].add(new Edge(3, 4));
    graph[3].add(new Edge(3, 5));

    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));

    graph[5].add(new Edge(5, 3));
    graph[5].add(new Edge(5, 4));
    graph[5].add(new Edge(5, 6));

    graph[6].add((new Edge(6, 5)));


}
    public static void dfs(ArrayList<Edge> graph[],boolean vis[],int curr){
        int V=graph.length;
        System.out.print(curr+"  ");
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e= graph[curr].get(i);
            if(vis[e.dest]==false){

                dfs(graph, vis, e.dest);
            }
        }


        }




     public static void dfsAll(ArrayList<Edge> graph[], boolean vis[],int curr,String path,int tar){
            if(curr==tar){
                System.out.println(path);
                return ;
            }
            for(int i =0;i<graph[curr].size();i++){
                Edge e= graph[curr].get(i);
                if(!vis[e.dest]){
                    vis[curr]=true;
                    dfsAll(graph, vis, e.dest, path+e.dest, tar);
                    vis[curr]=false;
                }
            }



     }

            
        

        

    public static void main(String[] args) {
        //BFS
         int V =7;
        ArrayList<Edge> graph[]= new ArrayList[V];
        CreateGraph(graph);
        
        // sometimes we do have dis-connected graphs so neeed to  apply a different strategy
        boolean vis[]= new boolean[V];
        for (int i = 0; i < vis.length; i++) {
            if(vis[i]==false){
                dfs(graph,vis,i);
                
            }
         }
         System.out.println();
         dfsAll(graph, new boolean[V], 0, "0", 5);

        System.out.println();
    }
}