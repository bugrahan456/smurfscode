
public class Dusman extends Karakter {

    private int DusmanID;
    private String DusmanAdi;
    private boolean DusmanTur;
    private int lokasyon;
    public Dusman(int ID, String Ad, String Tur) {
        super(ID, Ad, Tur);
    }
    public Dusman()
    {
        
    }

    public Dusman(int DusmanID, String DusmanAdi, boolean DusmanTur, int ID, String Ad, String Tur) {
        super(ID, Ad, Tur);
        this.DusmanID = DusmanID;
        this.DusmanAdi = DusmanAdi;
        this.DusmanTur = DusmanTur;
        this.lokasyon=lokasyon;
    }

    public int getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(int lokasyon) {
        this.lokasyon = lokasyon;
    }

    @Override
    void enKisaYol() {

    }

    public int getDusmanID() {
        return DusmanID;
    }

    public void setDusmanID(int DusmanID) {
        this.DusmanID = DusmanID;
    }

    public String getDusmanAdi() {
        return DusmanAdi;
    }

    public void setDusmanAdi(String DusmanAdi) {
        this.DusmanAdi = DusmanAdi;
    }

    public boolean getDusmanTur() {
        return DusmanTur;
    }

    public void setDusmanTur(boolean DusmanTur) {
        this.DusmanTur = DusmanTur;
    }

    public class Gargamel {

    }

    public class Azman {

    }
}