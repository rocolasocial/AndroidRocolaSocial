package domain;

/**
 * Created by Salvador on 09/08/2015.
 */
public class GuestModel {

    private int idImage;
    private int idName;


    public GuestModel(int idImage, int idName) {
        this.idImage = idImage;
        this.idName = idName;
    }


    public int getIdImage() {
        return idImage;
    }

    public int getIdName() {
        return idName;
    }

}
