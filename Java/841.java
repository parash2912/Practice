class Solution {
    private Set<Integer> visited = new HashSet<Integer>();
    private boolean visitRooms(List<List<Integer>> rooms, int currRoom) {
        visited.add(currRoom);
        for(Integer room : rooms.get(currRoom)) {
            if(!visited.contains(room)) {
                visited.add(room);
                if(visitRooms(rooms, room)) {
                    return true;
                }
            }
        }
        return (visited.size() == rooms.size());
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return visitRooms(rooms, 0);
    }
}
