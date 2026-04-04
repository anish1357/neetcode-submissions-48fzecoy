class MinStack {
public:
    stack<int> values;
    stack<int> minimum;
    MinStack() {
        
    }
    
    void push(int val) {
        if(minimum.empty()){
            values.push(val);
            minimum.push(val);
        }else {
            values.push(val);
            minimum.push(min(minimum.top(),val));
        }
    }
    
    void pop() {
        values.pop();
        minimum.pop();
    }
    
    int top() {
        return values.top();
    }
    
    int getMin() {
        return minimum.top();
    }
};
