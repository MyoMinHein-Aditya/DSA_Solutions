class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<int> freq(26,0);

        for(auto &e : s){
            int i=e-'a';
            freq[i]++;
        }

        for(auto &e : t){
            int i=e - 'a';
            freq[i]--;
        }

        for(auto &val : freq){
            if(val!=0) return false;
        }

        return true;
    }
};
