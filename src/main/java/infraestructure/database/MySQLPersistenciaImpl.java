package infraestructure.database;

import domain.model.Usuario;
import infraestructure.IPersistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLPersistenciaImpl implements IPersistencia {

    private Connection conexion;

    public MySQLPersistenciaImpl() {
        this.conexion = DatabaseConnection.getConnection();
    }

    @Override
    public void setUser(Usuario user) {
        String sql = "INSERT INTO user (username, password, email) VALUES(?,?,?)";

        try {
            PreparedStatement preparador = this.conexion.prepareStatement(sql);
            preparador.setString(1, user.getUsername());
            preparador.setString(2, user.getPassword());
            preparador.setString(3, user.getEmail());
            preparador.executeUpdate();
            preparador.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
