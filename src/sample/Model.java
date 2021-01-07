package sample;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Model {
    public static List<Integer> res  = new ArrayList<>();
    private int [][] board = new int[9][9];
    private boolean [][] boardRow = new  boolean[9][9];
    private  boolean [][] boardCol = new boolean[9][9];
    private boolean [][][] subBoard = new  boolean [3][3][9];

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    public void result(){
        for (int i = 0; i <9; i++)
            for(int j =0 ; j < 9;j++){
                int number = board[i][j];
                if(number != 0) {
                    boardRow[i][number-1] = true;
                    boardCol[j][number -1] = true;
                    subBoard[i/3][j/3][number-1] = true;
                }
        }
        solver(0,0);
    }

    public void solver(int i, int j) {
        if (i < 9 && j < 9) {
            if (board[i][j] == 0) {
                for (int z = 1; z <= 9; z++) {
                    if (!boardRow[i][z - 1] && !boardCol[j][z - 1] && !subBoard[i / 3][j / 3][z - 1]) {
                        boardRow[i][z - 1] = true;
                        boardCol[j][z - 1] = true;
                        subBoard[i / 3][j / 3][z - 1] = true;
                        board[i][j] = z;
                        solver(i, j + 1);
                        boardRow[i][z - 1] = false;
                        boardCol[j][z - 1] = false;
                        subBoard[i / 3][j / 3][z - 1] = false;
                        board[i][j] = 0;
                    }
                }

            } else solver(i, j + 1);
        } else if (i < 9 && j >= 9) {
            solver(i + 1, 0);
        }else
            for (int t =0; t < 9;t++){
                System.out.println( Arrays.toString(board[t]));
               for(int k = 0 ; k < 9; k++ )
               {
                   res.add(board[t][k]);
               }

            }



    }


}