package sample.com.ushulabubko;

public class MainTest {

    public static void main(String[] args) {

        Game gol = Game.initialize();

        Unit[][] worldMap = gol.getWorldSize();

        //gol.debugWorldMethod();

        gol.setupUpdate();
        gol.setupUpdate();
        gol.setupUpdate();
        gol.setupUpdate();



    }

}
