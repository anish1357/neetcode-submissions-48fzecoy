class Solution {
public:
string result(string a, string b, string o) {
    int x = stoi(a);
    int y = stoi(b);
    string ans;

    if (o == "+") {
        ans = to_string(x + y);
    } 
    else if (o == "-") {
        ans = to_string(x - y);
    } 
    else if (o == "*") {
        ans = to_string(x * y);
    } 
    else if (o == "/") {
        ans = to_string(x / y);   // integer division
    }

    return ans;
}
    int evalRPN(vector<string>& tokens) {
        stack<string> s;
        for(string &c : tokens ){
            if(isdigit(c.back())){
                s.push(c);
            }else {
                string first = s.top();
                s.pop();
                string second = s.top();
                s.pop();
                s.push(result(second,first,c));
                
            }
        }
        return stoi(s.top());
    }
};
