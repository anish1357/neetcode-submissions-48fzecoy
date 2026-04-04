class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int n = strs.size();
        vector<vector<int>> freq(26, vector<int> (n,0));
        vector<vector<string>> ans;
        unordered_map<string,vector<string>> mp;
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < strs[i].size();j++){
                freq[strs[i][j]-'a'][i]++;
            }
            string s ="";
            for(int j = 0; j < 26;j++){
                s+= to_string(freq[j][i]) + '_';
            }
            cout<<s<<endl;
            mp[s].push_back(strs[i]); 
        }
        for( auto entry : mp){
         ans.push_back(entry.second);
        }

        return ans; 
    }
};
