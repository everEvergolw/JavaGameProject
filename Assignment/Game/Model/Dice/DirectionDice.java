package Game.Model.Dice;

import java.util.Random;

/**
 * Dice throw a move direction
 */
public class DirectionDice implements Dice {

    private Random r;
    // 1: Forward 2: Backward 0: stay
    private int[] Points = {1,1,2,0};


    /**
     Dice throw a move direction
     * @return a move direction
     */
    @Override
    public int Roll() {
        if(r==null)
            r = new Random();
        return this.Points[r.nextInt(Points.length)];
    }
}
