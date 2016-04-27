import java.io.Serializable;

/**
 * Created by szpar on 27.04.2016.
 */
public class Brania implements Serializable {
    private int id;
    private String gatunek;
    private String nazwa;

    public Brania() {}

    public Brania(String gatunek, String nazwa) {
        super();
        this.gatunek = gatunek;
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Ryba: [id=" + id + ", gatunek=" + gatunek + ", nazwa=" + nazwa + "]";
    }

    public String getGatunek() { return gatunek; }
    public String getNazwa() { return nazwa; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
