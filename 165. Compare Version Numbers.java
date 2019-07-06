class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0; i < v1.length || i < v2.length; i++){
            int child1 = 0, child2 = 0;
            if (i < v1.length) child1 = Integer.parseInt(v1[i]);
            if (i < v2.length) child2 = Integer.parseInt(v2[i]);
            if (child1 > child2) return 1;
            if (child1 < child2) return -1;
            //System.out.println(child1 + ";" + child2);
        }
        return 0;
    }
}