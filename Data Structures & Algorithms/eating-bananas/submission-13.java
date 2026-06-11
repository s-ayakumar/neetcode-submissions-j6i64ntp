class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++)
        {
            max = Math.max(piles[i], max);
        }   

        return kokobanana(piles, h, 1, max, max);
    }

    private int kokobanana(int[] piles, int h, int start, int end, int res)
    {
        if (start > end) return res;
        if (piles.length == 0) return 0;
        int k = (end + start) / 2;
        long hours = 0;
        

        for (int i = 0; i < piles.length; i++)
        {
            hours += (piles[i] + k - 1) / k;
        }       

        if (hours <= h)
        {
            res = Math.min(k, kokobanana(piles, h, start, k - 1, res));
        }
        else
        {
            return kokobanana(piles, h, k + 1, end, res);
        }

        return res;

    }
}
