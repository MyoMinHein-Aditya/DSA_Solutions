class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s_b = new StringBuilder(s);
        StringBuilder t_b = new StringBuilder(t);
        for(int i = 0 ; i < s_b.length(); i++){
            if(s_b.charAt(i) == '#'){
                if (i > 0){
                    s_b.deleteCharAt(i - 1);
                    s_b.deleteCharAt(i - 1);  
                    i -= 2; 
                }
                else{
                    s_b.deleteCharAt(i);
                    i--;                     
                }
            }
        }
        for(int i = 0 ; i < t_b.length(); i++){
            if(t_b.charAt(i) == '#'){
                if (i > 0){
                    t_b.deleteCharAt(i - 1);
                    t_b.deleteCharAt(i - 1);  
                    i -= 2; 
                }
                else{
                    t_b.deleteCharAt(i);     
                    i--;                     
                }
            }
        }
        return s_b.toString().equals(t_b.toString());
    }
}
