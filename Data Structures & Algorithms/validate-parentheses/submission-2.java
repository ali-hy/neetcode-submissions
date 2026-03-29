class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 
        Map<Character, Character> map = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
        );
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.size() > 0 && s.charAt(i) == map.getOrDefault(stack.peek(), '\0')) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
