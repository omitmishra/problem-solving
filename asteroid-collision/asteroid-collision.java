class Solution {
    public int[] asteroidCollision(int[] asteroids) {
             if (asteroids == null || asteroids.length == 0) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);   // if positive push to stack
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()) { 
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) { 
                    stack.push(asteroid);
                } else if (asteroid + stack.peek() == 0) {    
                    stack.pop();
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {  
            result[i] = stack.pop();
        }
        return result;   
    }
}