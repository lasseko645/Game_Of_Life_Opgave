package sample.com.ushulabubko;


public class Unit {

    private boolean alive;
    private int livingNaighbours = 0;


    public Unit(){



    }


    public String updateGen(){

        String check = "its working maybe";

        if (isAlive() == false && getLivingNaighbours() == 3){

            setAlive(true);

            System.out.println("unit is born :D ");

        } else if ((getLivingNaighbours() == 2 || getLivingNaighbours() ==3) && isAlive() == true){

            //nothing will happen here as acording to the mathmatical properties desired by the program im making
            System.out.println("unit survived :) ");


        } else {
            setAlive(false);

            System.out.println("unit is ded :( ");
        }

        System.out.println(check);
        return check;
        // til test (

        //  )

    }


    public boolean isAlive() {
        return alive;
    }

    public  void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getLivingNaighbours() {
        return livingNaighbours;
    }

    public void setLivingNaighbours(int livingNaighbours) {
        this.livingNaighbours = livingNaighbours;
    }


}
