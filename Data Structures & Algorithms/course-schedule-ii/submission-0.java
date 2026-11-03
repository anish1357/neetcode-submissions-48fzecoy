class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer,List<Integer>> dependencies = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i< prerequisites.length; i++){
            dependencies.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>()).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> TopoSort = new ArrayList<>();
        while(!q.isEmpty()){
            Integer top = q.peek();
            q.poll();
            TopoSort.add(top);
            for(Integer i :  dependencies.getOrDefault(top, new ArrayList<>())){
                indegree[i]--;
                if(indegree[i] == 0)
                 q.offer(i);
            }
        }

        return TopoSort.size() == numCourses ? TopoSort.stream()
                     .mapToInt(Integer::intValue)
                     .toArray() : new int[0];

    }
}
