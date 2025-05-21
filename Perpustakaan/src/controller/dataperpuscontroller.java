/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdataperpus.dataperpusDAO;
import DAOImplement.dataperpusimplement;
import model.*;
import view.MainView;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class dataperpuscontroller {
    MainView frame ;
    dataperpusimplement impldataperpus;
    List<dataperpus> dp ;
    
    public dataperpuscontroller(MainView frame){
        this.frame = frame ;
        impldataperpus = new dataperpusDAO();
        dp = impldataperpus.getAll();
    }
    
    public void isitabel(){
        dp = impldataperpus.getAll();
        modeltabeldataperpus mp = new modeltabeldataperpus(dp);
        frame.getTabelDataperpus().setModel(mp);
    }
    
    public void insert(){
        dataperpus dp = new dataperpus();
        dp.setJudul(frame.getJTxtjudul().getText());
        dp.setGenre(frame.getJTxtgenre().getText());
        dp.setPenulis(frame.getJTxtpenulis().getText());
        dp.setPenerbit(frame.getJTxtpenerbit().getText());
        dp.setLokasi(frame.getJTxtlokasi().getText());
        dp.setStock(Integer.parseInt(frame.getJTxtstock().getText()));
        impldataperpus.insert(dp);
    }
    
    public void update(){
        dataperpus dp = new dataperpus();
        dp.setJudul(frame.getJTxtjudul().getText());
        dp.setGenre(frame.getJTxtgenre().getText());
        dp.setPenulis(frame.getJTxtpenulis().getText());
        dp.setPenerbit(frame.getJTxtpenerbit().getText());
        dp.setLokasi(frame.getJTxtlokasi().getText());
        dp.setStock(Integer.parseInt(frame.getJTxtstock().getText()));
        dp.setId(Integer.parseInt(frame.getJTxtid().getText()));
        impldataperpus.update(dp);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJTxtid().getText());
        impldataperpus.delete(id);
    }
    
    public void search(String kolom, String cari) {
        List<dataperpus> results = impldataperpus.search(kolom, cari);
        
        modeltabeldataperpus mp = new modeltabeldataperpus(results);
        frame.getTabelDataperpus().setModel(mp);
    }


}
