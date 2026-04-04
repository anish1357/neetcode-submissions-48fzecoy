class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> s(nums.begin(),nums.end());
        int ml = 0;
        for(auto i : nums){
            if(s.count(i)){
                int t= 0 , j = i ;
                while(s.count(++j)){
                    t++;
                    s.erase(j);
                }
                j = i;
                while(s.count(--j)){
                    s.erase(j);
                    t++;
                }
                ml = max(ml,t+1);
            }
        }
        return ml;
    }
};
