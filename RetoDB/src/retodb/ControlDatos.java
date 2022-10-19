package retodb;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ControlDatos {

    private RetoDB retoDB;
    private ModeloDatos modeloDatos;
    private Connection connection;
    private Aleatorios aleatorios;
    private DatosSerializables datosSerializables;

    public ControlDatos() {
        retoDB = new RetoDB();
        modeloDatos = new ModeloDatos();
        aleatorios = new Aleatorios();
        datosSerializables = new DatosSerializables();
    }

    public void insertar() {

        PreparedStatement ps;
        String sql;

        try {
            connection = retoDB.getConnection();
            sql = "INSERT INTO persona(cedula, nombres, apellido, telefono, edad) VALUES (?,?,?,?,?)";

            ps = connection.prepareStatement(sql);
            ps.setString(1, aleatorios.getCedulaAleatorios());
            ps.setString(2, aleatorios.getNombreAleatorios());
            ps.setString(3, aleatorios.getApellidosAleatorios());
            ps.setString(4, aleatorios.getTelefonoAleatorios());
            ps.setInt(5, aleatorios.getEdadAleatorios());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión de datos:" + e.getMessage());
        }
    }

    public void consulta() {
        PreparedStatement ps;
        String sql;

        try {

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("select * from persona");

            while (rs.next()) {
                datosSerializables.setCedula(rs.getString(1));
                datosSerializables.setNombres(rs.getString(2));
                datosSerializables.setApellido(rs.getString(3));
                datosSerializables.setTelefono(rs.getString(4));
                datosSerializables.setEdad(rs.getInt(5));
                System.out.println(json());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión de datos:" + e.getMessage());
        }
    }

    public Map<String, String> json() {
        HashMap<String, String> map = new HashMap<>();
        map.put("cedula", datosSerializables.getCedula());
        map.put("nombres", datosSerializables.getNombres());
        map.put("apellido", datosSerializables.getApellido());
        map.put("telefono", datosSerializables.getTelefono());
        map.put("edad", String.valueOf(datosSerializables.getEdad()));
        return map;
    }
    
}
