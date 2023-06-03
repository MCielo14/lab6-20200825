package Daos;

import Beans.Cancion;
import Beans.Reproduccion;

import java.sql.*;
import java.util.ArrayList;

public class CancionesDao {
    public ArrayList<Cancion> listarecomendados(){
        ArrayList<Cancion> listarecomendados1 = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "SELECT \n" +
                "c.idcancion ,\n" +
                "c.nombre_cancion ,\n" +
                "c.banda\n" +
                "FROM reproduccion  r inner join cancion c on (r.cancion_idcancion=c.idcancion) \n" +
                "group by cancion_idcancion\n" +
                "having\n" +
                "count(*) >2 \n" +
                "order by count(*) desc";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";
        try (Connection connection = DriverManager.getConnection(url, "root",
                "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()){

                Cancion cancion = new Cancion();
                //reproduccion.setIdreproduccion(resultSet.getInt(1));
                cancion.setIdcancion(resultSet.getInt(1));
                cancion.setNombre_cancion(resultSet.getString(2));
                cancion.setBanda(resultSet.getString(3));
                listarecomendados1.add(cancion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listarecomendados1;
    }
    public ArrayList<Cancion> listaidBanda(String banda){
        ArrayList<Cancion> listaidBanda = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "SELECT *FROM cancion where banda =? ";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, banda);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    Cancion cancion = new Cancion();
                    cancion.setIdcancion(rs.getInt(1));
                    cancion.setNombre_cancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaidBanda;
    }

}

