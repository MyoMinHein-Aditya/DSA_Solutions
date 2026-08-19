class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int result = 2 * n;
        int i = 0;
        
        while (i < reservedSeats.length) {
            int row = reservedSeats[i][0];
            boolean[] seats = new boolean[11];
            
            while (i < reservedSeats.length && reservedSeats[i][0] == row) {
                seats[reservedSeats[i][1]] = true;
                i++;
            }
            
            boolean left = true;
            for (int seat = 2; seat <= 5; seat++) {
                if (seats[seat]) {
                    left = false;
                    break;
                }
            }
            
            boolean right = true;
            for (int seat = 6; seat <= 9; seat++) {
                if (seats[seat]) {
                    right = false;
                    break;
                }
            }
            
            if (!left && !right) {
                boolean middle = true;
                for (int seat = 4; seat <= 7; seat++) {
                    if (seats[seat]) {
                        middle = false;
                        break;
                    }
                }
                if (middle) {
                    result -= 1;
                } else {
                    result -= 2;
                }
            } else if (!left || !right) {
                result -= 1;
            }
        }
        
        return result;
    }
}

