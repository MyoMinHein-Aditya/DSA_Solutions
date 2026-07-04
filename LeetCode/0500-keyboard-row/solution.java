class Solution {
    public String[] findWords(String[] words) {
        String a = "qwertyuiopQWERTYUIOP";
        String a1 = "asdfghjklASDFGHJKL";
        String a2 = "zxcvbnmZXCVBNM";

        ArrayList<Character> first = new ArrayList<>();
        ArrayList<Character> second = new ArrayList<>();
        ArrayList<Character> third = new ArrayList<>();

        for(int i = 0; i < a.length(); i++){
            first.add(a.charAt(i));
        }
        for(int i = 0; i < a1.length(); i++){
            second.add(a1.charAt(i));
        }
        for(int i = 0; i < a2.length(); i++){
            third.add(a2.charAt(i));
        }

        StringBuilder name1 = new StringBuilder();
        StringBuilder name2 = new StringBuilder();
        StringBuilder name3 = new StringBuilder();

        ArrayList<String> result = new ArrayList<>();
        
        for(String s : words){
            for(int i = 0; i < s.length(); i++){
                if(first.contains(s.charAt(i))){
                    name1.append(s.charAt(i));
                } else if (second.contains(s.charAt(i))) {
                    name2.append(s.charAt(i));
                } else if (third.contains(s.charAt(i))) {
                    name3.append(s.charAt(i));
                }
            }
            if(s.contentEquals(name1)){
                result.add(String.valueOf(name1));
            }else if(s.contentEquals(name2)){
                result.add(String.valueOf(name2));
            }else if(s.contentEquals(name3)){
                result.add(String.valueOf(name3));
            }
            name1.delete(0,name1.length());
            name2.delete(0,name2.length());
            name3.delete(0,name3.length());
        }
        return result.toArray(new String[0]);
    }
}
