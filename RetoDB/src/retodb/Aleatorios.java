package retodb;

public class Aleatorios {

    private String cedulaAleatorios;
    private String nombreAleatorios;
    private String apellidosAleatorios;
    private String telefonoAleatorios;
    private int edadAleatorios;

    public String getCedulaAleatorios() {
        String[] cedula = {"1040123456", "1017423628", "1040123123", "1017423456", "1040123789", "1017423012", "1040123345",
            "1017423678", "1040123901", "1017423234", "1040123567"};
        cedulaAleatorios = cedula[(int) (Math.floor(Math.random() * ((cedula.length - 1) - 0 + 1) + 0))];
        return cedulaAleatorios;
    }

    public void setCedulaAleatorios(String cedulaAleatorios) {
        this.cedulaAleatorios = cedulaAleatorios;
    }

    public String getNombreAleatorios() {
        String[] nombres = {"Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
            "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
            "Caritina", "Carlota", "Baltazar"};
        nombreAleatorios = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))];
        return nombreAleatorios;
    }

    public void setNombreAleatorios(String nombreAleatorios) {
        this.nombreAleatorios = nombreAleatorios;
    }

    public String getApellidosAleatorios() {
        String[] apellidos = {"Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
            "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
            "Grigalva"};
        apellidosAleatorios = apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];

        return apellidosAleatorios;
    }

    public void setApellidosAleatorios(String apellidosAleatorios) {
        this.apellidosAleatorios = apellidosAleatorios;
    }

    public String getTelefonoAleatorios() {
        String[] telefono = {"1234567", "8904567", "14784567", "1524567", "1256567", "19858527", "12344267", "12524167",
            "1252121567", "12358217", "1453285", "124211257", "1289567", "15820147"};
        telefonoAleatorios = telefono[(int) (Math.floor(Math.random() * ((telefono.length - 1) - 0 + 1) + 0))];
        return telefonoAleatorios;
    }

    public void setTelefonoAleatorios(String telefonoAleatorios) {
        this.telefonoAleatorios = telefonoAleatorios;
    }

    public int getEdadAleatorios() {
        int[] edad = {25, 48, 58, 45, 90, 101, 58, 45, 54, 62, 65, 85, 78, 60, 32, 28};
        edadAleatorios = edad[(int) (Math.floor(Math.random() * ((edad.length - 1) - 0 + 1) + 0))];
        return edadAleatorios;
    }

    public void setEdadAleatorios(int edadAleatorios) {
        this.edadAleatorios = edadAleatorios;
    }

}
