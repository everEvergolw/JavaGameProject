package Game.Model.Player;

/**
 *
 * Player class.
 * Override toString to facilitate recording player information
 * The properties are current position , step id,
 * player picture url, score , and whether the player wins.
 *
 */

public class Player  {

    private int curX;
    private int curY;
    private String Url;
    private int id;

    private String name;

    private int score;
    private int CurScore;

    private boolean Winning;

    private int steps;


    private boolean stay;

    /**
     Construction

     * @param  curX Player's position X.
     * @param  curY Player's position Y.
     * @param  url Player's image URL.
     * @param  id Player's id.
     * @param  name Player's name.

     */


    public Player(int curX, int curY,String url,int id,String name) {
      this.setCurX(curX);
      this.setCurY(curY);
      this.setUrl(url);
      this.setId(id);
      this.setWinning(false);
      this.setStay(false);
      this.setName(name);
      this.setScore(0);
      this.setCurScore(0);
      this.setSteps(0);
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStay(boolean stay) {
        this.stay = stay;
    }

    public boolean isStay() {
        return stay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurX(int curX) {
        this.curX = curX;
    }

    public void setCurY(int curY) {
        this.curY = curY;
    }

    public int getCurX() {
        return curX;
    }

    public int getCurY() {
        return curY;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        this.Url = url;
    }

    public boolean isWinning() {
        return Winning;
    }

    public void setWinning(boolean winning) {
        this.Winning = winning;
    }

    public int getCurScore() {
        return CurScore;
    }

    public void setCurScore(int curScore) {
        CurScore = curScore;
    }

    /**
     Player's information
     * @return Player's information
     */
    @Override
    public String toString() {
        return "Player: " +this.getName() + ", Score - "+this.getScore();
    }

}
