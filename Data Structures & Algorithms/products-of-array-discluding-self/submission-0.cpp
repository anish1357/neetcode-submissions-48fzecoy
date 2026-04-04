class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
     vector<int> ans(nums.size(), 0);
     int prod = 1, zc = 0; 
     for(auto i : nums){
        if(i == 0)
        zc++;
        else 
        prod *= i;
     }
     if(zc >1 )
     return ans;
     for(int i = 0; i< nums.size() ;i++){
      if(nums[i] == 0)
      ans[i] = prod;
      else if(zc == 1)
      ans[i] = 0;
      else 
      ans[i] = prod/nums[i];
     }
     return ans;
    }
};
