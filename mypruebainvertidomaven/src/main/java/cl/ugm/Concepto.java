package cl.ugm;

/**
 * Created by hernanBeiza on 6/12/17.
 */
public class Concepto {
    private int idDocumento;
    private String palabra;

    public Concepto(int idDocumento, String palabra) {
        this.idDocumento = idDocumento;
        this.palabra = palabra;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public String toString() {
        return "Concepto{" +
                "idDocumento=" + idDocumento +
                ", palabra='" + palabra + '\'' +
                '}';
    }
}
