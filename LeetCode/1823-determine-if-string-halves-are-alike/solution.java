class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        s = s.toLowerCase();
        String first_half = s.substring(0,mid);
        String second_half = s.substring(mid);
        char[]ch_1 = first_half.toCharArray();
        char[]ch_2 = second_half.toCharArray();
        int ch1_count = 0, ch2_count = 0;
        for(int i = 0; i < mid; i++){
            if(ch_1[i] == 'a' || ch_1[i] == 'e' || ch_1[i] == 'i' || ch_1[i] == 'o' || ch_1[i] == 'u'){
                ch1_count++;
            }
            if(ch_2[i] == 'a' || ch_2[i] == 'e' || ch_2[i] == 'i' || ch_2[i] == 'o' || ch_2[i] == 'u'){
                ch2_count++;
            }
        }

        if(ch1_count == ch2_count){
            return true;
        }
        else{
            return false;
        }

    }
}
