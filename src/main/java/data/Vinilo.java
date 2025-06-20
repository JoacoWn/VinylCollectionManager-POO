package data;

import java.util.Objects;

public class Vinilo {
    private String artista;
    private String disco;
    private int ano_lanzamiento;

    public Vinilo(String artista, String disco, int ano_lanzamiento) {
        this.artista = artista;
        this.disco = disco;
        this.ano_lanzamiento = ano_lanzamiento;
    }
    public String getArtista() {
        return artista;
    }
    public String getDisco() {
        return disco;
    }
    public int getAno_lanzamiento() {
        return ano_lanzamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vinilo vinilo = (Vinilo) o;
        return Objects.equals(artista, vinilo.artista) && Objects.equals(disco, vinilo.disco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artista, disco);
    }

    @Override
    public String toString() {
        return "Vinilo{" +
                "artista='" + artista + '\'' +
                ", disco='" + disco + '\'' +
                ", ano_lanzamiento=" + ano_lanzamiento +
                '}';
    }
}
