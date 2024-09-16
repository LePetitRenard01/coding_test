import java.util.ArrayDeque;
class Solution {
    public int solution(int[][] board, int[] moves) {
        //board[j][move[i]] != 0이면 뽑아서 stack에
        //peek()해서 같으면 pop(), 다르면 push()
        int answer = 0;
        ArrayDeque<Integer> basket = new ArrayDeque<>();
        for (int m : moves){
            m--;
            for (int h = 0; h < board.length; h++){
                if (board[h][m] != 0){
                    answer += goToBasket(basket, board[h][m]);
                    board[h][m] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    
    int goToBasket(ArrayDeque<Integer> a, int target){
        if(!a.isEmpty() && a.peek() == target){
            a.pop();
            return 2;
        }
        else{
            a.push(target);
            return 0;
        }
    }
}