class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;
        long res = 0;
        int[] left = new int[n];   // Distance to previous less element
        int[] right = new int[n];  // Distance to next less element

        // Monotonic increasing stack for left
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        // Monotonic increasing stack for right
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // Calculate result
        for (int i = 0; i < n; i++) {
            res = (res + (long)arr[i] * left[i] * right[i]) % mod;
        }
        return (int)res;
    }
}
