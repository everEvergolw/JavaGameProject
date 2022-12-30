package Game.Model.SpecialSites;
/**
 * BlackHoll class
 * Blocking players
 *
 */
public class BlackHoll extends SpecialSites{
    private final String url = Type.Black.getUrl();

    public BlackHoll(int row, int col) {
        super(row, col);
    }


    public String getUrl() {
        return url;
    }

    /**
     Will not block players
     * @return true or false
     */
    public boolean isBlock(){
        return true;
    }

}
