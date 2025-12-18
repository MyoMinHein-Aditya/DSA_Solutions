class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int a=0, b=0;
        for(String t:tokens){
            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")){
                b =s.pop();
                a = s.pop();
                try{
                    switch(t){
                        case "+" : s.push(a + b); break; 
                        case "-" : s.push(a - b); break;
                        case "*" : s.push(a * b); break;
                        case "/" : s.push(a / b); break;
                    }
                }catch(Exception ex){
                    System.out.println("Error!");
                }
            }
            else{
                int x = Integer.parseInt(t);
                s.push(x);
            }
        }
        return s.peek();
    }
}
