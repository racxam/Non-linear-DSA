import java.util.ArrayList;
import java.util.Stack;

public class topo {
    static class Edge{
        int src;
        int dest;
        Edge(int src ,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
       

       
        topUtil(graph,V);

        
       


    }
    

    private static void topUtil(ArrayList<topo.Edge>[] graph, int V) {
         Stack<Integer> st= new Stack<>();
         boolean vis[]=new boolean[V];
          for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topSort(graph, vis, st, i);
            }
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop()+" ");
        }

    }


    private static void topSort(ArrayList<Edge> graph[], boolean[] vis, Stack<Integer> st,int curr) {
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, vis, st, e.dest);

            }


        }
        st.push(curr);
    }

    private static void createGraph(ArrayList<topo.Edge>[] graph) {
            for (int i = 0; i < graph.length; i++) {
                graph[i]= new ArrayList<>();

            }

            //entering the data
            graph[2].add(new Edge(2, 3));
            
            graph[3].add(new Edge(3, 1));
            
            graph[4].add(new Edge(4, 0));
            
            graph[5].add(new Edge(5, 0));



        }
}
