/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdataperpus;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.dataperpusimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class dataperpusDAO implements dataperpusimplement {
    Connection connection ;
    
    final String select = "SELECT * FROM dataperpus";
    final String insert = "INSERT INTO dataperpus (judul, genre, penulis, penerbit, lokasi, stock) VALUES (?,?,?,?,?,?);" ;
    final String update = "UPDATE dataperpus SET judul = ?, genre = ?, penulis = ?, penerbit = ?, lokasi = ?, stock = ? WHERE id = ?;" ;
    final String delete = "DELETE FROM dataperpus WHERE id=?;";
    final String qSearch = "SELECT * FROM dataperpus WHERE + kolom + LIKE ?";
    
    public dataperpusDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(dataperpus p) {
        PreparedStatement statement = null ;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(6, p.getStock());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
            }
        } catch (SQLException ex){
            ex. printStackTrace();
        } finally{
            try{
                statement.close();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(dataperpus p) {
        PreparedStatement statement = null ;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(6, p.getStock());
            statement.setInt(7, p.getId());
            statement.executeUpdate();
        } catch (SQLException ex){
            ex. printStackTrace();
        } finally{
            try{
                statement.close();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement statement = null ;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<dataperpus> getAll() {
        List<dataperpus> dp = null ;
        try{
            dp = new ArrayList<dataperpus>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select) ;
            while(rs.next()){
                dataperpus perpus = new dataperpus();
                perpus.setId(rs.getInt("id"));
                perpus.setJudul(rs.getString("judul"));
                perpus.setGenre(rs.getString("genre"));
                perpus.setPenulis(rs.getString("penulis"));
                perpus.setPenerbit(rs.getString("penerbit"));
                perpus.setLokasi(rs.getString("lokasi"));
                perpus.setStock(rs.getInt("stock"));
                dp.add(perpus);
            }
        } catch(Exception ex){
            Logger.getLogger(dataperpusDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return dp;
    }
    
    @Override
    public List<dataperpus> search(String kolom, String cari) {
        List<dataperpus> dp = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            String query = "SELECT * FROM dataperpus WHERE " + kolom + " LIKE ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, "%" + cari + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                dataperpus perpus = new dataperpus();
                perpus.setId(rs.getInt("id"));
                perpus.setJudul(rs.getString("judul"));
                perpus.setGenre(rs.getString("genre"));
                perpus.setPenulis(rs.getString("penulis"));
                perpus.setPenerbit(rs.getString("penerbit"));
                perpus.setLokasi(rs.getString("lokasi"));
                perpus.setStock(rs.getInt("stock"));
                dp.add(perpus);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(dataperpusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return dp;
    }


    
}
