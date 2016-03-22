import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int s = 0, e = m;
        int row = 0;
        while( s < e){
            int mid = s + (e-s)/2;
            if(matrix[mid][0] <= target && target <= matrix[mid][n] ){
                row = mid;
                break;
            }else if(target < matrix[mid][0] ){
                e = mid-1;
            }else if(target > matrix[mid][n]){
                s = mid+1;
            }
        }
        row = s;
        System.out.println(row);
        s = 0;
        e = n;
        while(s < e){
            int mid = s + (e -s)/2;
            if(matrix[row][mid] < target){
                s = mid+1;
            }else if(matrix[row][mid] == target){
                return true;
            }else{
                e = mid-1;
            }
        }
        System.out.println(matrix[row][s] == target);
        return matrix[row][s] == target;
    }

    public String toReversePolish(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                int sum = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    sum = sum*10 + (s.charAt(i)-'0');
                    i++;
                }
                sb.append(sum).append(" ");
                i--;
            }else{
                if(c == '+' || c== '-'){
                    if(!stack.isEmpty()){
                        char cc = stack.peek();
                        while( !stack.isEmpty() && stack.peek() != '('){
                            sb.append(stack.pop()).append(" ");
                        }
                    }
                    stack.push(c);
                }else if(c == '*' || c == '/'){
                    if(!stack.isEmpty()){
                       char cc = stack.peek();
                       while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                           sb.append(stack.pop()).append(" ");
                       }
                    }
                    stack.push(c);
                }else if(c == '('){
                    stack.push(c);
                }else if(c == ')'){
                    while(!stack.isEmpty() && (stack.peek() != '(')){
                        sb.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        return sb.toString();
    }
}



public class TT{
    public static void main(String args[]){

        Solution ss = new Solution();
        int[][] array = {{1},{3},{5}};
        ss.searchMatrix( array, 3);

        String sb = ss.toReversePolish("9+(3-1)*3+10/2");
        sb.trim().split("\\s+");
        System.out.println(sb);

        System.out.println(ss.maxPoints);
    }
}
