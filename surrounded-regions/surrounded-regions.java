class Solution {
    public void solve(char[][] board) {
        
        if(board == null || board.length <= 0){
            return ;
        }
        for(int i=0;i<board.length;i++){
            if(board[i][0] == 'O')helper(board,i,0);
            if(board[i][board[0].length-1]=='O') helper(board,i,board[0].length-1);
        }
        
        //for columns;
        for(int i=0;i<board[0].length;i++){
            if(board[0][i] == 'O')helper(board,0,i);
            if(board[board.length-1][i]=='O') helper(board,board.length-1,i);
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                //Converting all the boundary connected regions back to 'O';
                else if(board[i][j] == '*'){
                    board[i][j] ='O';
                }
            }
        }
        
    }
    
    public void helper(char[][] board,int row,int col){
        
        if(row < 0 || row > board.length - 1 || col < 0 || col > board[0].length -1 || board[row][col] == 'X'){
            return ;
        }
        if(board[row][col] == '*'){
            return;
        }
        
        board[row][col]='*';
        
        helper(board,row+1,col);
        helper(board,row-1,col);
        helper(board,row,col+1);
        helper(board,row,col-1);
    }   
    }
