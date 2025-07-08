class Solution {
    public boolean isBipartite(int[][] adj) {
        int V=adj.length;
        int[] color = new int[V];
        Arrays.fill(color, -1); 
        
        
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                color[i] = 0;
                q.offer(i);

                while (!q.isEmpty()) {
                    int u = q.poll();

                    for (int v : adj[u]) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        } else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}