package Graph;

public class CountingNoOfGraph {
    public static int countingGraphs(int N) {
        // Write your code here.
        return (int)Math.pow(2, (N*(N-1))/2);
    }
}
