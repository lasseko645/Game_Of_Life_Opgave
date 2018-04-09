package sample.com.ushulabubko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game{


    //here i make a size to be later used to define the size of my 2d array
private static int Y_AXIS = 25;
private static int X_AXIS = 20;

//this was added after my sick period when i had spend some time troubleshooting my issues
//as far as i understand the resoning behind doing this instead of doing it inside the other big method is that the game can stil run if somthing is wrong with the main part of the program
//so it was my idea that this might help me sort out the problem easier... it ended up being a wrong return statement and a missing semicollon
private Game world;


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

    // i went in after some time with sicness and trouble to get things to work and looked up some help
    // i found that it could work fine do make a game object outside of the main method as follows
    public static Game initialize() {
        Game world = new Game();
        return world;
    }



    // i now take on the part of the assignment that is ment to first run the whole process when the game launches, for the soul purpose of setting the living neighborsfor each unit in the game world
    public Game setupUpdate(){

        int livingNaighbors = 0;
        //i need to set the parameters for this first method to run by the world size

        int x_axis_max = this.worldSize[0].length;
        int y_axis_max = this.worldSize.length;

        for (int y_axis_setup = 0; y_axis_setup < y_axis_max; y_axis_setup++){
            for (int x_axis_setup = 0; x_axis_setup < x_axis_max; x_axis_setup++){

                //checks north
                if (y_axis_setup > 0) {
                    if (worldSize[x_axis_setup][y_axis_setup - 1].isAlive()) {
                        livingNaighbors++;
                    }
                }

                //checks northeast
                if (x_axis_setup < X_AXIS - 1 && y_axis_setup > 0) {
                    if (worldSize[x_axis_setup + 1][y_axis_setup - 1].isAlive()) {
                        livingNaighbors++;
                    }
                }

                //checks east
                if (x_axis_setup < X_AXIS - 1) {
                    if (worldSize[x_axis_setup + 1][y_axis_setup].isAlive()){
                        livingNaighbors++;
                    }
                }

                //checks southeast
                if (x_axis_setup < X_AXIS - 1 && y_axis_setup < Y_AXIS - 1) {
                    if (worldSize[x_axis_setup + 1][y_axis_setup + 1].isAlive()) {
                        livingNaighbors++;
                    }
                }

                //checks south
                if (y_axis_setup < Y_AXIS - 1) {
                    if (worldSize[x_axis_setup][y_axis_setup + 1].isAlive()) {
                        livingNaighbors++;
                    }
                }

                //checks southwest
                if (y_axis_setup < Y_AXIS - 1 && x_axis_setup > 0) {
                    if (worldSize[x_axis_setup - 1][y_axis_setup + 1].isAlive()) {
                        livingNaighbors++;
                    }
                }

                //checks west
                if (x_axis_setup > 0) {
                    if (worldSize[x_axis_setup - 1][y_axis_setup].isAlive()) {
                        livingNaighbors++;
                    }
                }

                //and lastly checks the northwest
                if (x_axis_setup > 0 && y_axis_setup > 0) {
                    if (worldSize[x_axis_setup - 1][y_axis_setup - 1].isAlive()) {
                        livingNaighbors++;
                    }
                }

                //here i set the amount of living naighbors for the any unit that runs trought this set of if statements
                worldSize[x_axis_setup][y_axis_setup].setLivingNaighbours(livingNaighbors);

            }
        }

        //now i have to make it so that after the random generator has done its thing and the amount of living naighbors have been set for each unit in the gameworld, that the game runs the update once for all the units just to make it so that the rules that define the world will take place
        for (int y_update_setup = 0; y_update_setup < y_axis_max; y_update_setup++){
            for (int x_update_setup = 0; x_update_setup < x_axis_max; x_update_setup++){
                worldSize[x_update_setup][y_update_setup].updateGen();
            }
        }
        return world;
    }


}