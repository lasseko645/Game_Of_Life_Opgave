package sample.com.ushulabubko.front_end;
import javafx.scene.control.*;
import sample.com.ushulabubko.back_end.*;
import javafx.fxml.*;


public class Controller {

    @FXML
    public TextArea textPrintArea;

    public Button updateButton;

    private Game goi = Game.world;

    private int Y_AXIS = goi.Y_AXIS;
    private int X_AXIS = goi.X_AXIS;

    private Unit [][] worldSizeControl = Game.worldSize;

    public TextArea getTextPrintArea() {
        return textPrintArea;
    }

    public  void setTekstPrint(String n){
        textPrintArea.setText(n);
    }

    public void handleButtonClick() {

        //goi.setupUpdate();
        //textPrintArea.setText("hej");
        printResultsetToTextArea();
        //buttonUpdateAction();
    }

    public String buttonUpdateAction(){
        String resultset = "";



            int x_axis_max = this.worldSizeControl[0].length;
            int y_axis_max = this.worldSizeControl.length;
            //Controller console = new Controller();

            //Controller.getTextPrintArea().setText("debug");

            for (int y_axis_setup = 0; y_axis_setup < y_axis_max; y_axis_setup++){
                resultset = resultset + "\n";
                //System.out.println("");
                //Controller.getTextPrintArea().setText("\n");
                for (int x_axis_setup = 0; x_axis_setup < x_axis_max; x_axis_setup++){

                    //console.getTextPrintArea().setText(" ");
                    resultset = resultset + " ";
                    //System.out.print(" ");
                    //Controller console = new Controller();


                    if (worldSizeControl[x_axis_setup][y_axis_setup].isAlive() == false){
                        resultset = resultset + "Ø";
                        //System.out.print("Ø");
                        //console.setTekstPrint("Ø");
                        //console.getTextPrintArea().setText(" Ø ");

                    }else if (worldSizeControl[x_axis_setup][y_axis_setup].isAlive() == true){
                        resultset = resultset + "O";
                        //System.out.print("O");
                        //console.setTekstPrint("O");
                        //console.getTextPrintArea().setText(" O ");
                    }

                    int livingNaighborssetup = 0;

                    //for test
                    //System.out.print("f");

                    //checks north
                    if (y_axis_setup > 0) {
                        if (worldSizeControl[x_axis_setup][y_axis_setup - 1].isAlive()) {
                            livingNaighborssetup++;
                        }
                    }

                    //checks northeast
                    if (x_axis_setup < X_AXIS - 1 && y_axis_setup > 0) {
                        if (worldSizeControl[x_axis_setup + 1][y_axis_setup - 1].isAlive()) {
                            livingNaighborssetup++;
                        }
                    }

                    //checks east
                    if (x_axis_setup < X_AXIS - 1) {
                        if (worldSizeControl[x_axis_setup + 1][y_axis_setup].isAlive()) {
                            livingNaighborssetup++;
                        }
                    }

                    //checks southeast
                    if (x_axis_setup < X_AXIS - 1 && y_axis_setup < Y_AXIS - 1) {
                        if (worldSizeControl[x_axis_setup + 1][y_axis_setup + 1].isAlive()) {
                            livingNaighborssetup++;
                        }
                    }

                    //checks south
                    if (y_axis_setup < Y_AXIS - 1) {
                        if (worldSizeControl[x_axis_setup][y_axis_setup + 1].isAlive()) {
                            livingNaighborssetup++;
                        }
                    }

                    //checks southwest
                    if (y_axis_setup < Y_AXIS - 1 && x_axis_setup > 0) {
                        if (worldSizeControl[x_axis_setup - 1][y_axis_setup + 1].isAlive()) {
                            livingNaighborssetup++;
                        }
                    }

                    //checks west
                    if (x_axis_setup > 0) {
                        if (worldSizeControl[x_axis_setup - 1][y_axis_setup].isAlive()) {
                            livingNaighborssetup++;
                        }
                    }

                    //and lastly checks the northwest
                    if (x_axis_setup > 0 && y_axis_setup > 0) {
                        if (worldSizeControl[x_axis_setup - 1][y_axis_setup - 1].isAlive()) {
                            livingNaighborssetup++;
                        }
                    }



                    worldSizeControl[x_axis_setup][y_axis_setup].updateGen();


                    //here i set the amount of living naighbors for the any unit that runs trought this set of if statements
                    worldSizeControl[x_axis_setup][y_axis_setup].setLivingNaighbours(livingNaighborssetup);
                    worldSizeControl[x_axis_setup][y_axis_setup].updateGen();



                }
            }

            //now i have to make it so that after the random generator has done its thing and the amount of living naighbors have been set for each unit in the gameworld, that the game runs the update once for all the units just to make it so that the rules that define the world will take place
            for (int y_update_setup = 0; y_update_setup < y_axis_max; y_update_setup++){
                //for test
                //System.out.println("\n");
                for (int x_update_setup = 0; x_update_setup < x_axis_max; x_update_setup++){
                    //for test
                    //System.out.print("f");
                    worldSizeControl[x_update_setup][y_update_setup].updateGen();
                }
            }

            // i ran into an issue in the console with the world to be rendered right after the old one when i tried to show multiple iterations, and i can solve it easyly like this
            //System.out.println("\n");
            resultset = resultset + "\n";
            System.out.println(resultset);
            return resultset;


    }

    public void printResultsetToTextArea(){
        //buttonUpdateAction();
        textPrintArea.setText(buttonUpdateAction());
    }


}
