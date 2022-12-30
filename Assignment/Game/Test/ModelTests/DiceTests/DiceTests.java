package Game.Test.ModelTests.DiceTests;

import Game.Model.Dice.DirectionDice;
import Game.Model.Dice.MoveDice;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceTests {


    @Test
    public void testMoveDice() {
        // It tests the signature of the method.
        Method[] methods = MoveDice.class.getMethods();
        int count = 0;
        for (Method m : methods)
            if (m.getName().trim().equalsIgnoreCase("Roll"))
                if (m.getReturnType().getSimpleName().equals("int"))
                    count++;

        assertEquals(1, count);
    }


    @Test
    public void testDirectionDice() {
        // It tests the signature of the method.
        Method[] methods = DirectionDice.class.getMethods();
        int count = 0;
        for (Method m : methods)
            if (m.getName().trim().equalsIgnoreCase("Roll"))
                if (m.getReturnType().getSimpleName().equals("int"))
                    count++;

        assertEquals(1, count);
    }


}