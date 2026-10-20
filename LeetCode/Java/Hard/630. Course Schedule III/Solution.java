class Solution {
    public int scheduleCourse(int[][] courses) {
        sortCourses(courses, 0, courses.length - 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int total = 0;
        
        for (int i = 0; i < courses.length; i++) {
            int d = courses[i][0];
            int last = courses[i][1];
            
            if (total + d <= last) {
                total += d;
                pq.offer(d);
            } else if (!pq.isEmpty() && pq.peek() > d) {
                total -= pq.poll();
                total += d;
                pq.offer(d);
            }
        }
        
        return pq.size();
    }
    
    private void sortCourses(int[][] courses, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(courses, low, high);
            sortCourses(courses, low, pivotIndex - 1);
            sortCourses(courses, pivotIndex + 1, high);
        }
    }
    
    private int partition(int[][] courses, int low, int high) {
        int pivot = courses[high][1];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (courses[j][1] <= pivot) {
                i++;
                int[] temp = courses[i];
                courses[i] = courses[j];
                courses[j] = temp;
            }
        }
        int[] temp = courses[i + 1];
        courses[i + 1] = courses[high];
        courses[high] = temp;
        return i + 1;
    }
}
