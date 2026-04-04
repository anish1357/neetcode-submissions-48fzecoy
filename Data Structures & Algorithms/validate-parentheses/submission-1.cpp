class Solution {
public:
    bool isValid(string s) {
       stack<char> p;
       for(char c : s){
        if(c == '(' || c == '{' || c == '['){
            p.push(c);
        }else if ((c == '}' && p.size() > 0 && p.top() == '{') || 
                  ( c == ')' && p.size() > 0 && p.top() == '(') ||
                  (c == ']' && p.size() > 0 && p.top() == '[') ){
                  p.pop();
                  }
                  else {
                    p.push(c);
                  }
       } 

       return p.empty();
    }
};
