class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        int[] par = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 0; i < n; i++)
        {
            par[i] = i;
        }

        Arrays.fill(rank, 1);
        
        for (int[] edge : edges)
        {
            if (find(par, edge[0]) != find(par, edge[1]))
            {
                union(edge[0], edge[1], par, rank);
            
            }
            else
            {
                return new int[] {edge[0], edge[1]};
            }

        }
        return new int[0];
    }

    private void union(int n1, int n2, int[] par, int[] rank)
    {
        int p1 = find(par, n1);
        int p2 = find(par, n2);

        if (p1 == p2) return;

        if (rank[p1] > rank[p2])
        {
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else
        {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
    }

    private int find(int[] par, int node)
    {
        while (node != par[node])
        {
            par[node] = par[par[node]];
            node = par[node];
        }

        return node;
    }

    
}
