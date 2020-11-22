/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibrahim;

/**
 *
 * @author caveb
 */
public class boardSlot {
    private String effect;
    private String plusOrMinus;
    private int xPosition;
    private int yPosition;

    public boardSlot(String effect, String plusOrMinus, int xPosition, int yPosition) {
        this.effect = effect;
        this.plusOrMinus = plusOrMinus;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getEffect() {
        return effect;
    }

    public String getPlusOrMinus() {
        return plusOrMinus;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
}
