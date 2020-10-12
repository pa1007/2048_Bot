package dev.pa1007.java2048bot;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Case {

    /**
     * y.
     *
     * @since 1.0
     */
    private int y;

    /**
     * case x.
     *
     * @since 1.0
     */
    private int posx;

    /**
     * case y.
     *
     * @since 1.0
     */
    private int posy;

    /**
     * x.
     *
     * @since 1.0
     */
    private int  x;
    private Type type;

    public Case(int x, int y, int posx, int posy) {
        this.x = x;
        this.y = y;
        this.posx = posx;
        this.posy = posy;
        this.type = Type.NULL;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public List<Case> getNearCasesPos() {
        return null;
    }

    public static Type getType(int r, int g, int b) {
        Stream<Type> typeStream = Arrays.stream(Type.values()).filter((predicate) -> predicate.c.equals(new Color(
                r,
                g,
                b
        )));
        Optional<Type> first = typeStream.findFirst();

        if (first.isEmpty()) {
            System.err.printf(
                    "Error while collecting the color, rgb %s, %s, %s not found in the types %s" + "\n",
                    r,
                    g,
                    b,
                    typeStream
            );
            return Type.NULL;
        }
        else {
            return first.get();
        }

    }


    public enum Type {


        EMPTY(new Color(205, 192, 180), 0),
        TWO(new Color(238, 228, 218), 2),
        FOUR(new Color(237, 224, 200), 4),
        EIGHT(new Color(242, 177, 121), 8),
        SIXTEEN(new Color(245, 149, 99), 16),
        THIRTY_TWO(new Color(246, 124, 95), 32),
        SIXTY_FOUR(new Color(246, 94, 59), 64),
        ONE_TWENTY_EIGHT(new Color(237, 207, 114), 128),
        TWO_FIFTY_SIX(new Color(237, 204, 97), 256),
        FIVE_TWELVE(new Color(237, 200, 80), 512),
        HUNDRED_TWENTY_FOUR(new Color(237, 197, 63), 1024),
        TWO_FORTY_EIGHT(new Color(237, 194, 46), 2048),
        SUPER(new Color(60, 58, 50), 4086),
        NULL(new Color(0, 0, 0), -1);

        private Color c;

        private int val;

        Type(Color c, int val) {
            this.c = c;
            this.val = val;
        }

        public Color getC() {
            return c;
        }

        public int getVal() {
            return val;
        }
    }
}
