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

        for(int i =0; i < numCourses; i++)
            adjList.add(new ArrayList<Integer>());
        
        
        for(int i = 0; i < preReq​.length; i++)
            adjList.get(preReq[i][0]).add(preReq[i][1]);            

        return sort(preReq, numCourses);
    }
   
    
    
    
    private int[] sort(int[][] preReq, int numCourses){
        for(int i = 0; i <numCourses; i++)
            if(!visited[i])
                sort(i, preReq);
    return result;
    }
    
    private void sort(int node, int[][] preReq){
        visited[node] = true;
        
        for(int i: adjList.get(node))
            if(!visited[i])
                sort(i, preReq);

        result[resIndex] = node;
        resIndex++;
    }
    
}
