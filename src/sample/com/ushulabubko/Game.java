package sample.com.ushulabubko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game{


    //here i make a size to be later used to define the size of my 2d array
private static int Y_AXIS = 25, X_AXIS = 20;

private Unit [][] worldSize = new Unit[X_AXIS][Y_AXIS];

//i will here make my contructor for the game to eventually be used when game launches to build the world for this game to take place based on the 2d arrays inputs
    private Game(){
        for (int y_axis = 0; y_axis < Y_AXIS; y_axis ++){
            for (int x_axis = 0; x_axis < X_AXIS; x_axis ++){
                Random alive_Or_Dead = new Random();
                int a_o_d = alive_Or_Dead.nextInt(2);
                Unit unit = new Unit();
                if (a_o_d == 0){
                    unit.setAlive(false);
                } else if (a_o_d == 1){
                    unit.setAlive(true);
                } else {
                    System.out.println("a big mistak has happened");
                }
                //here i make it build the world one step at a time with a random generator to determine the alive of dead variable in each unit... there could be a better and more efficient way to do this but this is what i was able to do at the time
                worldSize [x_axis][y_axis] = unit;
            }
        }
    }


}