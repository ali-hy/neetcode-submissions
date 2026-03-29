class Solution {
    class Pair {
        int index;
        int value;

        Pair(int i, int v) {
            index = i;
            value = v;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int res[] = new int[temperatures.length];
    
        stack.push(new Pair(0, temperatures[0]));

        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek().value) {
                res[stack.peek().index] = i - stack.peek().index; 
                stack.pop();
            }

            stack.push(new Pair(i, temperatures[i]));
        }

        return res;
    }
}
