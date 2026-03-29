class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>(); 
        Integer n2;

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
            case "+":
                s.push(s.pop() + s.pop());
                break;
            case "-":
                n2 = s.pop();
                s.push(s.pop() - n2);
                break;
            case "/":
                n2 = s.pop();
                s.push(s.pop() / n2);
                break;
            case "*":
                s.push(s.pop() * s.pop());
                break;
            default:
                s.push(Integer.parseInt(tokens[i]));
            }
        }

        return s.pop();
    }
}
