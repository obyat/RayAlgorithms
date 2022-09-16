package Chapter4.Graphs;
import java.util.ArrayList;
import java.util.List;
public class CourseSchedule {
    
    int[] result;
    List<List<Integer>> adjList;
    boolean[] visited;
    int resIndex;
    
    public int[] findOrder(int numCourses, int[][] preReq) {
        adjList = new ArrayList<>(numCourses + 1);
        result = new int[numCourses];
        resIndex = 0;
        visited = new boolean[numCourses];
        boolean[] cvisited = new boolean[numCourses];

        for(int i =0; i < numCourses; i++){
            adjList.add(new ArrayList<Integer>());
            
        }
        
        for(int i = 0; i < preReq.length; i++){
            adjList.get(preReq[i][0]).add(preReq[i][1]);            
        }
        
        boolean[] cycleArr = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            // System.out.println("sending node: " + i);
            // System.out.println("returned: " + hasCycle(i, i, cvisited, cycleArr));
            // System.out.println("");
            
            if(hasCycle(i, i, cvisited, cycleArr));
               return new int[] {};
        }

        visited = new boolean[numCourses];
        return sort(preReq, numCourses);
    }
   
    
    
    private boolean hasCycle(int self, int node,boolean[] cvisited, boolean[] cycleArr){
    if(self == node) return true;
        
        for(int i : adjList.get(node)){
            if(hasCycle(self, i, cvisited, cycleArr)){
                return true;
                
            }

        }


        return false;
    }
    
    
    
    private int[] sort(int[][] preReq, int numCourses){
        for(int i = 0; i <numCourses; i++)
            if(!visited[i])
                sort(i, preReq);
    return new int[] {1,2};
    }
    
    private void sort(int node, int[][] preReq){
        visited[node] = true;
        
        for(int i: adjList.get(node))
            if(!visited[i])
                sort(i, preReq);

        result[resIndex] = node;
        resIndex++;
    }

    public static void main(String[] args) {
         CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.findOrder(4, new int[][] {{1,0},{2,0},{3,1},{3,2}}).toString());
    }
    
}
