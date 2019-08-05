package it.unibo.bmbman.model.utilities;
/**
 * Class to manage the position.
 */
public class Position {
    private int x;
    private int y;
    /**
     * Create a new position in the specified coordinate.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Method to get the x coordinate.
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }
    /**
     * Method to set the x coordinate of the position.
     * @param x the new x coordinate
     */
    public void setX(final int x) {
        this.x = x;
    }
    /**
     * Method to get the y coordinate.
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }
    /**
     * Method to set the y coordinate of the position.
     * @param y the new y coordinate
     */
    public void setY(final int y) {
        this.y = y;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Position [x=" + this.getX() + "y=" + this.getY() + "]";
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        return true;
    }
}
