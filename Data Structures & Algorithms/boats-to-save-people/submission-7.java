class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // limit = 3 | 1, 2, 2, 3, 3 -> 
        int heaviest = people.length - 1;
        int lightest = 0;
        int boatCounter = 0;

        Arrays.sort(people);

        while (lightest <= heaviest)
        {
            if (people[heaviest] + people[lightest] > limit)
            {
                heaviest--;
                boatCounter++;
            }
            else 
            {
                boatCounter++;
                heaviest--;
                lightest++;
            }
        }


        return boatCounter;
    }
}