

public class GozlukluSirin extends Karakter{
    
    private int oyuncuID;
    private String oyuncuAdi;
    private boolean oyuncuTur;
    private int skor;
    private int lokasyon;
    
    public GozlukluSirin(int oyuncuID, String oyuncuAdi, boolean oyuncuTur, int ID, String Ad, String Tur,int lokasyon,int skor) {
        super(ID, Ad, Tur);
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuTur = oyuncuTur;
        this.lokasyon=lokasyon;
        this.skor=skor;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public boolean isOyuncuTur() {
        return oyuncuTur;
    }

    public void setOyuncuTur(boolean oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public int getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(int lokasyon) {
        this.lokasyon = lokasyon;
    }


    @Override
    void enKisaYol() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}