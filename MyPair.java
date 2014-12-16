/**
 * A pair of X and Y values.
 */
public class MyPair implements Pair {

    private int x;
    private int y;

    /**
     * @return the x location of this pair 
     */
    @Override
    public int getX( ) {
        return x;
    }

    /**
     * sets x to the newVal
     * @param the new x for MyPair
     */
    @Override
    public void setX( int newVal ) {
        x = newVal;
    }

    /**
     * @return the y location of this pair 
     */
    @Override
    public int getY( ) {
        return y;
    }

    /**
     * sets y to the newVal
     * @param the new y for MyPair
     */
    @Override
    public void setY( int newVal ) {
        y = newVal;
    }
}
