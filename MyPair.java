/**
 * A pair of X and Y values.
 */
public class MyPair implements Pair {

    private int x;
    private int y;

    @Override
    public int getX( ) {
        return x;
    }

    @Override
    public void setX( int newVal ) {
        x = newVal;
    }

    @Override
    public int getY( ) {
        return y;
    }

    @Override
    public void setY( int newVal ) {
        y = newVal;
    }
}
