package com.vivekasu;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){

                    char n = board[i][j];

                    for(int k=i+1;k<9;k++)
                        if(board[k][j]==n)
                            return false;

                    for(int k=j+1;k<9;k++)
                        if(board[i][k]==n)
                            return false;

                    for(int k=i;k<=(i/3) * 3 + 2;k++){
                        for(int l=(j/3) * 3;l<=(j/3) * 3 + 2;l++){
                            if(!(k==i && l==j) && board[k][l] == n)
                                return false;
                        }
                    }

                }

            }
        }

        return true;

    }
}
