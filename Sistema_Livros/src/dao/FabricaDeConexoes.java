package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class FabricaDeConexoes {
    // Design Pattern / Padrão de Projetos
    // Fabrica / Factory
    // Único / Singleton
    private static FabricaDeConexoes instance;

    // Esconder o construtor
    private FabricaDeConexoes(){}

    // Padrão Singleton
    public final static FabricaDeConexoes getInstance(){
        if(instance == null){
            instance = new FabricaDeConexoes();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        var url = "jdbc:sqlite:meu_banco.db";
        Connection con = DriverManager
                .getConnection(url);
        return con;
    }

}
