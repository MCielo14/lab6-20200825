package Daos;

import Beans.Reproduccion;

import java.sql.*;
import java.util.ArrayList;

public class ReproduccionDao {
    public ArrayList<Reproduccion> listaReproduccion(){
        ArrayList<Reproduccion> listarepro = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "SELECT \n" +
                "c.idcancion as \"id\",\n" +
                "c.nombre_cancion as \"Nombre\",\n" +
                "b.idbanda\n" +
                "FROM reproduccion  r inner join cancion c on (r.cancion_idcancion=c.idcancion) inner join banda b on (c.banda=b.idbanda)\n" +
                "group by cancion_idcancion\n" +
                " having\n" +
                "count(*) >2 \n" +
                "order by count(*) desc";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";
        try (Connection connection = DriverManager.getConnection(url, "root",
                "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){

                Reproduccion reproduccion = new Reproduccion();
                //reproduccion.setIdreproduccion(resultSet.getInt(1));
                reproduccion.setCancion_idcancion(resultSet.getInt(2));
                reproduccion.(resultSet.getString(3));
                listarepro.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listarepro;
    }
}
}
