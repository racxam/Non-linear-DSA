import java.util.ArrayList;
import java.util.Scanner;



public class adlist {
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

            graph[1].add(new Edge(1, 2));
            graph[1].add(new Edge(1, 3));
            
            graph[2].add(new Edge(2, 0));
            graph[2].add(new Edge(2, 1));
            graph[2].add(new Edge(2, 3));

            graph[3].add(new Edge(3, 2));
            graph[3].add(new Edge(3, 1));

        }
        public static void printNeighbour(ArrayList<Edge> graph[]){
            for (int i = 0; i < graph.length; i++) {
                Edge e1= graph[i].get(0);
                System.out.print("{"+e1.src+"--->");
                for (int j = 0; j < graph[i].size(); j++) {
                        Edge e= graph[i].get(j);
                        if(j!=graph[i].size()-1){
                            System.out.print(e.dest+",");

                        }
                        else{
                            System.out.print(e.dest);
                        }
                        
                }
                System.out.println("}");
            }
        }

    public static void main(String[] args) {
        System.out.println("Enter the size of the Vertex");// enter 4 for this example
        Scanner o= new Scanner(System.in);
        int V =o.nextInt();
        ArrayList<Edge> graph[]= new ArrayList[V];
        CreateGraph(graph);
        //Question 1 print all the neibours 
        printNeighbour(graph);

        
}
}