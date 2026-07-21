class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();
        for (int row = nums.size() - 1; row >= 0; row--) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                int diagonal = row + col;
                while (diagonals.size() <= diagonal) {
                    diagonals.add(new ArrayList<>());
                }
                diagonals.get(diagonal).add(nums.get(row).get(col));
            }
        }
        int count = 0;
        for (ArrayList<Integer> diagonal : diagonals) {
            count += diagonal.size();
        }
        int[] answer = new int[count];
        int index = 0;
        for (ArrayList<Integer> diagonal : diagonals) {
            for (int value : diagonal) {
                answer[index++] = value;
            }
        }
        return answer;
    }
}

