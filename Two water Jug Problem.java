
class Solution {
    static class State {
        int x, y; 
        State(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return x == state.x && y == state.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n) || d % gcd(m, n) != 0) {
            return -1; 
        }
        Set<State> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0));
        visited.add(new State(0, 0));
        int steps = 0;
        // BFS to explore all possible states
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                State current = queue.poll();
                int x = current.x;
                int y = current.y;
                // If either jug contains exactly d liters
                if (x == d || y == d) {
                    return steps;
                }
                List<State> nextStates = Arrays.asList(
                    new State(0, y),        // Empty Jug 1
                    new State(x, 0),        // Empty Jug 2
                    new State(m, y),        // Fill Jug 1
                    new State(x, n),        // Fill Jug 2
                    new State(Math.max(0, x - (n - y)), Math.min(n, y + x)), // Pour Jug 1 -> Jug 2
                    new State(Math.min(m, x + y), Math.max(0, y - (m - x)))  // Pour Jug 2 -> Jug 1
                );

                for (State nextState : nextStates) {
                    if (!visited.contains(nextState)) {
                        queue.add(nextState);
                        visited.add(nextState);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
