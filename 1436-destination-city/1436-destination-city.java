class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> source = new HashSet<>();
        HashSet<String> dest = new HashSet<>();
        
        for(List<String> str : paths){
            source.add(str.get(0));
            dest.add(str.get(1));
        }
        
        for (String destination : dest) {
            if (!source.contains(destination)) {
                return destination;
            }
        }
        
        return "";
    }
}