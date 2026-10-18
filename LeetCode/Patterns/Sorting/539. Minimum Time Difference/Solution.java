class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (int i = 0; i < timePoints.size(); i++) {
            String str = timePoints.get(i);

            int hours = Integer.parseInt(str.substring(0, 2));
            int minute = Integer.parseInt(str.substring(3, 5));
            int totalminutes = hours * 60 + minute;
            minutes.add(totalminutes);
        }
        Collections.sort(minutes);

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.size() - 1; i++) {
            int diff = minutes.get(i + 1) - minutes.get(i);
            mini = Math.min(mini, diff);
        }
        int lastdiff = minutes.get(0) + 1440 - minutes.get(minutes.size() - 1);
        mini = Math.min(mini, lastdiff);
        return mini;
    }
}