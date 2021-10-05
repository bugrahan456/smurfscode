
public abstract class Karakter {

    private int ID;
    private String Ad;
    private String Tur;

    public Karakter() {
    }

    public Karakter(int ID, String Ad, String Tur) {
        this.ID = ID;
        this.Ad = Ad;
        this.Tur = Tur;
    }

    abstract void enKisaYol();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String Tur) {
        this.Tur = Tur;
    }

}

