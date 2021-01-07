package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller implements Initializable {
    @FXML
    private   Pane pane;


    private int[][] board = new int[9][9];
    private Model model = new Model();
    private Button[][] arrButton = new Button[9][9];


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i =1; i <=9; i++){
            for(int j = 1; j <=9;j++){
                Button button = new Button();
                arrButton[i -1][j -1] = button;
                button.setId("x");
                button.setLayoutX(i*40+1);
                button.setLayoutY(j*40+1);
                button.setPrefSize(40,40);
                button.setText("0");
                final int[] count = {Integer.parseInt(button.getText())};
                int finalI = i;
                int finalJ = j;
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(final MouseEvent event) {


                        if (event.getButton() == MouseButton.PRIMARY) {
                            count[0]++;
                            button.setText(String.valueOf(count[0]));

                        }
                        else if (event.getButton() == MouseButton.SECONDARY) {
                           count[0]--;
                            button.setText(String.valueOf(count[0]));
                        }
                        board[finalI -1][finalJ -1] = Integer.parseInt(button.getText()) ;
                    }
                });


                pane.getChildren().add(button);
            }
        }
    }
   public void start(){
//       int[][] board = {
//               {9,0,3,0,0,8,4,0,0},
//               {0,5,0,1,0,7,0,0,3},
//               {6,8,7,3,0,2,9,0,0},
//               {0,0,0,6,0,0,0,0,0},
//               {5,3,8,2,0,0,0,0,0},
//               {1,0,2,0,0,4,0,9,0},
//               {3,0,0,9,0,6,0,7,0},
//               {7,2,6,8,5,1,0,4,0},
//               {0,0,0,4,0,3,2,5,0}};
       model.setBoard(board);
       for(int[] i : board){
           System.out.println(Arrays.toString(i));
       }
       System.out.println("-------------------------");
       model.result();
       System.out.println("-------------------------");
      List<Integer>result = Model.res;
      int count =0;
       int [][] r = new int [9][9];
      int k =0;
      for(int i = 0; i < result.size(); i++){
           r[k][count] = result.get(i);
           count++;
           if(count ==9){
              k++;
              count=0;
           }
      }
          for(int[] i : r){
              System.out.println(Arrays.toString(i));
          }
       for(int i =0; i <9; i++){
           for(int j = 0; j < 9;j++){
           arrButton[i][j].setText(String.valueOf(r[j][i]));
           }
       }
   }
}
