class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] par = new int[n];

        for (int i = 0; i < n; i++)
        {
            par[i] = i;
        }

        int[] rank = new int[n];
        Arrays.fill(rank, 1);
        int result = n;

        for (int[] edge : edges)
        {
            result -= union(edge[0], edge[1], par, rank);
        }

        return result;
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

    private int union(int n1, int n2, int[] par, int[] rank)
    {
        int p1 = find(par, n1);
        int p2 = find(par, n2);

        if (p1 == p2) return 0;

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
        
        return 1;
    }
}
