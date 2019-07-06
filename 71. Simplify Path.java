class Solution {
    public String simplifyPath(String path) {
        String [] dir = path.split("/");
        List<String> list = new ArrayList<>();
        for (String s : dir){
            if (s.equals("") || s.equals(".")) continue;
            if(s.equals("..")){
                if (list.size() > 0)
                    list.remove(list.size()-1);
            } else {
                list.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list){
            sb.append("/" + s);
        }
        if (sb.length() == 0)
            sb.append("/");
        return sb.toString();
    }
}