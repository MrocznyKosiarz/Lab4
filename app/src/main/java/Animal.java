import java.io.Serializable;

/**
 * Created by szpar on 27.04.2016.
 */
public class Animal implements Serializable {
    private int id;
    private String gatunek;
    private String kolor;
    private float wielkosc;
    private String opis;

    public Animal() {}

    public Animal(String gatunek, String kolor, float wielkosc, String opis) {
        super();
        this.gatunek = gatunek;
        this.kolor = kolor;
        this.wielkosc = wielkosc;
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Zwierze: [id=" + id + ", gatunek=" + gatunek + ", kolor=" + kolor + "]";
    }

    public String getGatunek() { return gatunek; }
    public String getKolor() { return kolor; }
    public float getWielkosc() { return wielkosc; }
    public String getOpis() { return opis; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
