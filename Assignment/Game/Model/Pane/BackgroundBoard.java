package Game.Model.Pane;


/**
 * BackgroundBoard class
 * Provides an BackgroundBoard Instance.
 * Change player rounds
 */


public class BackgroundBoard {
    static BackgroundBoard backgroundBoard = null;

    private int row;

    private int col;

    // Pixel size
    private double cellLength;
    private double startX;
    private double startY;

    private int curPlayer;
    /**
     Construction
     * @param  cellLength Pixel size.
     * @param  row rows.
     * @param  col cols.
     */
    private BackgroundBoard(double cellLength, int row, int col) {
        this.setRow(row);
        this.setCol(col);
        this.setCellLength(cellLength);
        this.setStartX(0);
        this.setStartY(0);
        this.setCurPlayer(0);

    }
    /**
     getInstance method.
     * @param  cellLength Pixel size.
     * @param  row rows.
     * @param  col cols.
     * @return BackgroundBoard.
     */
    public static BackgroundBoard getInstance(double cellLength, int row, int col){
        if(backgroundBoard == null)
            return new BackgroundBoard(cellLength,row,col);
        return backgroundBoard;
    }






    public void setCurPlayer(int curPlayer) {
        this.curPlayer = curPlayer;
    }


    /**
     Change player rounds.
     * @param  size Number of Players.
     * @return Nothing.
     */
    public void changCurPlayer(int size){
        this.setCurPlayer((this.getCurPlayer()+1) % size);
    }


    public int getCurPlayer() {
        return curPlayer;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public double getCellLength() {
        return cellLength;
    }



    public void setCellLength(double cellLength) {
        this.cellLength = cellLength;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }


}