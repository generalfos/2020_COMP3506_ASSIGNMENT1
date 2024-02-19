import java.lang.Math.abs

/**
 * A 2D cartesian plane implemented as with an array. Each (x,y) coordinate can
 * hold a single item of type <T>.
 *
 * @param <T> The type of element held in the data structure
 */
public class ArrayCartesianPlane<T> implements CartesianPlane<T> {

    private int minimumX;
    private int maximumX;
    private int minimumY;
    private int maximumY;
    private T[][] array;
    private int xDim;
    private int yDim;
    private int xShift;
    private int yShift;
    /**
     * Constructs a new ArrayCartesianPlane object with given minimum and
     * maximum bounds.
     *
     * Note that these bounds are allowed to be negative.
     *
     * @param minimumX A new minimum bound for the x values of
     *         elements.
     * @param maximumX A new maximum bound for the x values of
     *         elements.
     * @param minimumY A new minimum bound for the y values of
     *         elements.
     * @param maximumY A new maximum bound for the y values of
     *         elements.
     * @throws IllegalArgumentException if the x minimum is greater
     *         than the x maximum (and resp. with y min/max)
     */
    public ArrayCartesianPlane(int minimumX, int maximumX, int minimumY,
            int maximumY) throws IllegalArgumentException {
        // TODO: implement the constructor
        this.minimumX = minimumX;
        this.maximumX = maximumX;
        this.minimumY = minimumY;
        this.maximumY = maximumY;
        this.xDim = maxX - minX;
        this.yDim = maxY - minY;
        this.array = (T[][])new Object[xDim][yDim];
        this.xShift = -minimumX;
        this.yShift = -maximumY;
    }

    // TODO: you are to implement all of ArrayCartesianPlanes's methods here
    private void add(int x, int y, T element) {
        int posX = abs(x+this.xShift);
        int posY = abs(y+this.yShift);
        this.array[posX][posY] = element;
    }

    private T get(int x, int y) {
        int posX = abs(x+this.xShift);
        int posY = abs(y+this.yShift);
        return this.array[posX][posY];
    }

    private boolean remove(int x, int y) {
        int posX = abs(x+this.xShift);
        int posY = abs(y+this.yShift);
        T element = this.array[posX][posY];
        if (element == null) {
            return false;
        }
        this.array[posX][posY] = null;
        return true;
    }

    private void clear() {
        for (int i = this.xDim - 1; i >= 0; i--) {
            for (int j = this.yDim - 1; j >= 0; j--) {
                this.array[i][j] = null;
            }
        }
    }

    private void resize(int newMinimumX, int newMaximumX, int newMinimumY, int newMaximumY)
            throws IllegalArgumentException {
        if ((!(validate(newMinimumX, newMaximumX, newMinimumY, newMaximumY))) || (!(validate_resize(newMinimumX,
                newMaximumX, newMinimumY, newMaximumY)))) {
            throw IllegalArgumentException;
        }
        int xDim = newMaximumX - newMinimumX;
        int yDim = newMaximumY - newMinimumY;
        T[][] array = (T[][])new Object[xDim][yDim];
        int newXshift = -newMinimumX;
        int newYshift = -newMaximumY;
        """ TODO """
        for (int i = 0; i < this.xDim; i++) {
            for (int j = 0; j < this.yDim; j++) {
                T temp = this.array[i][j];
                int x = abs(i + this.minimumX + newXshift);
                int y = abs(j + this.maximumY + newYshift);
                array[x][y] = temp;
            }
        }
        this.array = array;
    }

    private boolean validate(int minY, int maxX, int minY, int maxY) {
        if ((newMinimumX > newMaximumX) || (newMinimumY > newMaximumY)) {
            return false;
        }
        return true;
    }

    private boolean validate_resize(int newMinimumX, int newMaximumX, int newMinimumY, int newMaximumY) {
        if ((newMinimumX > this.minimumX) || (newMaximumX < this.maximumX) || (newMinimumY > this.minimumY) ||
                (newMaximumY < this.maximumY)) {
            return false;
        }
        return true;
    }





}

