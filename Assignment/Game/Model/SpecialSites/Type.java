package Game.Model.SpecialSites;


/**
 *  Enum provides the image URL of the obstacle
 *
 */

public enum Type {
    Fire1("Game/Img/SS/Fire1.png"),
    Fire2("Game/Img/SS/Fire2.png"),
    Black("Game/Img/SS/BlackHoll.png"),

    stay("Game/Img/SS/Stop.png"),
    Tp("Game/Img/SS/Tp.png"),
    Gold("Game/Img/SS/Gold.png");
    private String Url;

    private Type(String url) {
        this.Url = url;
    }

    public String getUrl() {
        return Url;
    }
}
