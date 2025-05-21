/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;

import java.util.List;
import model.*;

/**
 *
 * @author ASUS
 */
public interface dataperpusimplement {

    public void insert(dataperpus p);
    public void update(dataperpus p);
    public void delete(Integer id);
    public List<dataperpus> getAll();
    public List<dataperpus> search(String kolom, String cari);
    
}
