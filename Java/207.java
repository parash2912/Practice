class Solution {
    private Map<Integer, ArrayList<Integer>> prereq = new HashMap<Integer, ArrayList<Integer>>();
    
    private boolean hasCycle(int course, boolean[] visited) {
        if(visited[course]) {
            return true;
        }
        visited[course] = true;
        ArrayList<Integer> pre = prereq.get(course);
        if(pre == null) {
            return false;
        }
        for(int c : pre) {
            boolean[] vis_tmp = Arrays.copyOf(visited, visited.length);
            if(hasCycle(c, vis_tmp)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < prerequisites.length; ++i) {
            if(prereq.containsKey(prerequisites[i][0])) {
                ArrayList<Integer> l_tmp = prereq.get(prerequisites[i][0]);
                l_tmp.add(prerequisites[i][1]);
                prereq.put(prerequisites[i][0], l_tmp);
            } else {
                ArrayList<Integer> l_tmp = new ArrayList<Integer>();
                l_tmp.add(prerequisites[i][1]);
                prereq.put(prerequisites[i][0], l_tmp);
            }
        }
        
        for(int i = 0; i < numCourses; ++i) {
            boolean[] visited = new boolean[numCourses];
            if(hasCycle(i, visited)) {
                return false;
            }
        }
        return true;
    }
}
