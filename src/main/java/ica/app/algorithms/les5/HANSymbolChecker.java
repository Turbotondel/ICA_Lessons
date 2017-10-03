package ica.app.algorithms.les5;

public class HANSymbolChecker {
    HANStack stack;

    public HANSymbolChecker() {
        stack = new HANStack<Character>();
    }

    public boolean checkIfBalanced(String s) throws Exception {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ']') {
                if (stack.isEmpty() || stack.top().compareTo('[') != 0) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.top().compareTo('(') != 0) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.top().compareTo('{') != 0) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
