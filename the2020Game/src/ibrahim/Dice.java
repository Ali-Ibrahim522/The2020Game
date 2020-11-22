package ibrahim;

import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author caveb
 */
public class Dice {
    private static int diceNum;
    
    
    public static int roll() {
        Random dice = new Random();
        diceNum = dice.nextInt(6) + 1;
        return diceNum;
    }   

    public static int getDiceNum() {
        return diceNum;
    }
    
    public static String setDiceIcon(int roll) {
        if (roll == 1) {
            return "/images/d1.png";
        } else if (roll == 2) {
            return "/images/d2.png";
        } else if (roll == 3) {
            return "/images/d3.png";
        } else if (roll == 4) {
            return "/images/d4.png";
        } else if (roll == 5) {
            return "/images/d5.png";
        } else if (roll == 6) {
            return "/images/d6.png";
        }
        return "broken";
    }
}
