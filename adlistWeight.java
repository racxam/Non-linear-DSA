import java.util.ArrayList;

public class adlistWeight {
        static class Edge{
             int src;
             int dest;
             int w;
             Edge(int src ,int dest,int w){
                this.src=src;
                this.dest=dest;
                this.w=w;
             }
        };
        public static void CreateGraph(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                graph[i]= new ArrayList<Edge>();
            }
            graph[0].add(new Edge(0, 2, 2));

            graph[1].add(new Edge(1, 3,0));
            graph[1].add(new Edge(1, 2,10));
            
            graph[2].add(new Edge(2, 0,2));
            graph[2].add(new Edge(2, 1,10));
            graph[2].add(new Edge(2, 3,-1));

            graph[3].add(new Edge(3, 2,-1));
            graph[3].add(new Edge(3, 1,0));

        }
        public static void printNeighbour(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                Edge e1= graph[i].get(0);
                System.out.print("{"+e1.src+"--->");
                for (int j = 0; j < graph[i].size(); j++) {
                        Edge e= graph[i].get(j);
                        if(j!=graph[i].size()-1){
                            System.out.print("["+e.dest+"--|"+e.w+"] ,");

                        }
                        else{
                            System.out.print("["+e.dest+"--|"+e.w+"]");
                        }
                        
                }
                System.out.println("}");
            }
        }

    public static void main(String[] args) {


        int V =4;
        ArrayList<Edge> graph[]= new ArrayList[V];
        CreateGraph(graph);
        //Question 1 print all the neibours 
        printNeighbour(graph);

        
}
}