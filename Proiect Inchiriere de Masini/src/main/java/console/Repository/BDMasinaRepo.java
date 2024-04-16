package console.Repository;

import console.Domain.masina;
import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static console.Domain.carFactory.generateMasinaList;

public class BDMasinaRepo extends MemoryRepo<masina> {

    private String JDBC_URL = "jdbc:sqlite:masini.sqlite";
    Connection connection;

    Connection c;
    public BDMasinaRepo(){
        openConnection();
        createTable();
        //initialData(); //baga date
    }

    private void openConnection(){
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl(JDBC_URL);

        try{
            if( connection == null || connection.isClosed()){
                connection = ds.getConnection();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable(){

        try(final Statement st = connection.createStatement()){
            st.execute("CREATE TABLE IF NOT EXISTS masini(id int, marca varchar(255), model varchar(255));");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void initialData(){
        try( PreparedStatement st = connection.prepareStatement("INSERT INTO masini VALUES (?,?,?)")){
            List<masina> masinaList = generateMasinaList(100);

            // Print the generated list
            for (masina masina : masinaList) {
                st.setInt(1, masina.getId());
                st.setString(2, masina.getMarca());
                st.setString(3, masina.getModel());
                st.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<masina> getAll(){
        ArrayList<masina> masini = new ArrayList<>();
        try( PreparedStatement st = connection.prepareStatement("SELECT * FROM masini;")){
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                masini.add(new masina(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return masini;
    }

    public void add(masina masina){
        //super.add(masina);
        try( PreparedStatement st = connection.prepareStatement("INSERT INTO masini VALUES (?,?,?)")){
            // Print the generated list
            st.setInt(1,masina.getId());
            st.setString(2,masina.getMarca());
            st.setString(3,masina.getModel());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(masina masina){
        try( PreparedStatement st = connection.prepareStatement("UPDATE masini SET marca=?, model=? WHERE id=?;")){
            // Print the generated list
            st.setInt(3,masina.getId());
            st.setString(1,masina.getMarca());
            st.setString(2,masina.getModel());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try( PreparedStatement st = connection.prepareStatement("DELETE FROM masini WHERE id=?;")){
            st.setInt(1,id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}