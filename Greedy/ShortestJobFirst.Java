import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestJobFirst {
    public static float sjf(int n, int []arrivalTime, int []burstTime)
    {
        int[] waitingTime = new int[n];
        int[] completionTime = new int[n];
        boolean[] visited = new boolean[n];

        // Priority queue to store processes based on burst time
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // Initialize variables
        int currentTime = 0;
        int totalWaitingTime = 0;
        int processed = 0;

        // Process each job
        while (processed < n) {
            for (int i = 0; i < n; i++) {
                if (!visited[i] && arrivalTime[i] <= currentTime) {
                    priorityQueue.add(new int[]{i, burstTime[i]});
                    visited[i] = true;
                }
            }
            if (!priorityQueue.isEmpty()) {
                int[] currentProcess = priorityQueue.poll();
                int processIndex = currentProcess[0];
                completionTime[processIndex] = currentTime + burstTime[processIndex];
                waitingTime[processIndex] = currentTime - arrivalTime[processIndex];
                totalWaitingTime += waitingTime[processIndex];
                currentTime = completionTime[processIndex];
                processed++;
            } else {
                currentTime++;
            }
        }
        float averageWaitingTime = (float) totalWaitingTime / n;
        return averageWaitingTime;
        
    }
}