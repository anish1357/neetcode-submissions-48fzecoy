class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
       vector<int> ans;
       int n = nums.size();
       unordered_map<int,int> freq;
       priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
       for(auto i : nums){
           freq[i]++;
       }

       for(auto i : freq){
           if(pq.size() < k ) {
             pq.push({i.second,i.first});
           }else {
             if(pq.top().first < i.second){
                pq.pop();
                pq.push({i.second,i.first});
             }
           }
        //    cout<<pq.size()<<endl;
       }

       while(!pq.empty()){
        ans.push_back(pq.top().second);
        pq.pop();
       }
       return ans; 
    }
};
