package sample.com.ushulabubko;

public class MainTest {

    public static void main(String[] args) {

        Game gol = Game.initialize();

        Unit[][] worldMap = gol.getWorldSize();

        gol.setupUpdate();



    }

}
