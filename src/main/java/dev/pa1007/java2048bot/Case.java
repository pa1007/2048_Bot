package dev.pa1007.java2048bot;

import java.awt.Color;

enum Type {


    Empty(new Color(119, 110, 101)),
    TWO(new Color(238, 228, 218)),
    FOUR(new Color(237, 224, 200)),
    EIGHT(new Color(242, 177, 121)),
    SIXTEEN(new Color(245, 149, 99)),
    THIRTY_TWO(new Color(246, 124, 95)),
    SIXTY_FOUR(new Color(246, 94, 59)),
    ONE_TWENTY_EIGHT(new Color(237, 207, 114)),
    TWO_FIFTY_SIX(new Color(0, 237, 204)),
    FIVE_TWELVE(new Color(237, 200, 80)),
    HUNDRED_TWENTY_FOUR(new Color(237, 197, 63)),
    TWO_FORTY_EIGHT(new Color(237, 194, 46)),
    SUPER(new Color(60, 58, 50));

    private Color c;

    Type(Color c) {
        this.c = c;
    }

    public Color getC() {
        return c;
    }
}

public class Case {

    /**
     * y.
     *
     * @since 1.0
     */
    private int y;
    /**
     * x.
     *
     * @since 1.0
     */
    private int x;

    public Case(int y, int x) {
        this.y = y;
        this.x = x;
    }

    /**
     * @return y.
     * @since 1.0
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the <code>y</code> field.
     *
     * @param y y.
     * @since 1.0
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return x.
     * @since 1.0
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the <code>x</code> field.
     *
     * @param x x.
     * @since 1.0
     */
    public void setX(int x) {
        this.x = x;
    }


}
