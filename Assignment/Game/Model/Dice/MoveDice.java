package Game.Model.Dice;

import java.util.Random;
/**
 * Dice throw a move step.
 * */
public class MoveDice implements Dice{

    private Random r;

    // 1:UP 2: DOWN 3: LEFT 4:RIGHT
    private int[] Points = {1,2,3,4};




    /**
     Dice throw a move step.
     * @return a move step
     */
    @Override
    public int Roll() {
        if(r==null)
            r = new Random();
        return this.Points[r.nextInt(Points.length)];
    }


}
