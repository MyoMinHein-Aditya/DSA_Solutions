class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int d = 0, t = 0, b = m-1, l = 0, r = n-1;
        if(m==0 || n==0){
            return list;
        }
        else{
            while(t<=b && l<=r){
                if(d==0){
                    for(int i=l;i<=r;i++){
                        list.add(matrix[t][i]);
                    }
                    t++;
                }
                else if(d==1){
                    for(int i=t;i<=b;i++){
                        list.add(matrix[i][r]);
                    }
                    r--;
                }
                else if(d==2){
                    for(int i=r;i>=l;i--){
                        list.add(matrix[b][i]);
                    }
                    b--;
                }
                else if(d==3){
                    for(int i=b;i>=t;i--){
                        list.add(matrix[i][l]);
                    }
                    l++;
                }

                d = (d+1) % 4;
            }
            return list;
        }
    }
}
