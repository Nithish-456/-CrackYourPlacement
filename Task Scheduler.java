class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Array to count the occurrences of each task
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }
        Arrays.sort(taskCounts);
        int maxCount = taskCounts[25]; // The maximum frequency of any task
        int intervals = (maxCount - 1) * (n + 1);
        // Add the tasks with the same frequency as the most frequent task
        for (int i = 25; i >= 0; i--) {
            if (taskCounts[i] == maxCount) {
                intervals++;
            } else {
                break;
            }
        }
        // 1. If there are no identical tasks, then simply we can return number of tasks (as it doesn't required idle points)
        // 2. we must account for the idle slots to ensure no two identical tasks are closer than n intervals.
        return Math.max(intervals, tasks.length);
        
    }
}
