package Game.Model.Player;
/**
 *Enum provides the image URL of the players
 *
 */
public enum PlayerType {
    B("Game/Img/Player/B.jpg"),
    T("Game/Img/Player/T.jpg"),

    BS("Game/Img/Player/BS.jpg"),
    MA("Game/Img/Player/MA.jpg"),
    CAT("Game/Img/Player/CAT.jpg"),
    PEI("Game/Img/Player/PEI.jpg"),
    TOM("Game/Img/Player/TOM.jpg"),
    JERRY("Game/Img/Player/JERRY.jpg"),
    JZP("Game/Img/Player/JZP.jpg"),
    AM("Game/Img/Player/AM.jpg");



    private String Url;

    private PlayerType(String url) {
        this.Url = url;
    }

    public String getUrl() {
        return Url;
    }
}
