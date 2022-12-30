package Game.Model.SpecialSites;
/**
 * FireSite class
 * Blocking players
 *
 */
public class FireSite extends SpecialSites{
    private  final String url ;

    public FireSite(int row, int col, String url) {
        super(row, col);
        this.url = url;
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
