
package com.mycompany.windows;

import com.mycompany.windows.DBConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class CariAdmin implements Initializable {
    
    @FXML 
    private TextField nim;
    @FXML 
    private TextField output;   
    @FXML
    private TextField output2;   
    @FXML
    private Label notifikasi;
    @FXML
    private Button laporan;

    @FXML    
    public void CariAdmin(ActionEvent event) throws SQLException, IOException {
        
        String inputnim;
        inputnim = nim.getText();   
        String tampil1 = null;
        String tampil2 = null;
        String t = null;
       
        XYChart.Series setData = new XYChart.Series<>();
        
        Connection connection = DBConnect.getInstance().getConnection();        
        Statement statement = connection.createStatement();  
        String sql = "SELECT * FROM mahasiswa WHERE nim = '" + inputnim + "';";
        ResultSet resultset = statement.executeQuery(sql);        
      
        while(resultset.next()){
            t = resultset.getString("nim");
            tampil1 = resultset.getString("nama");
            tampil2 = resultset.getString("poin");
            
        }
        output.setText(null);
        output2.setText(null);
        
        if(inputnim.equals(t) == true ){
            output.setText(tampil1);
            output2.setText(tampil2);
            
           //setData.getData().add(new XYChart.Data(tampil1, tampil2));
           //grafik.getData().addAll(setData);
        } else {             
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Info");
             alert.setHeaderText(null);
             alert.setContentText("Data Anda Belum Tersimpan");
             alert.show();
        }
    }
    
        @FXML
    public void buttoncari(ActionEvent event) throws IOException{
        Parent p;
        p = FXMLLoader.load(getClass().getResource("cariadmin.fxml"));
        Scene cari = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(cari);
        w.show();
    }
    @FXML
    public void buttoncatat(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("catat.fxml"));
        Scene catat = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(catat);
        w.show();
    }
    @FXML
    public void buttonedit(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Scene edit = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(edit);
        w.show();
    }
    @FXML
    public void buttonhapus(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("hapus.fxml"));
        Scene hapus = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(hapus);
        w.show();
    }
    @FXML
    public void buttonvalidasi(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("validasiadmin.fxml"));
        Scene va = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(va);
        w.show();
    }
    @FXML 
    public void buttonback(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("halamanawaladmin.fxml"));
        Scene back = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(back);
        w.show();
    }
    
    @FXML
    void lihatLaporan(ActionEvent event) throws IOException {
        Parent p;
        p = FXMLLoader.load(getClass().getResource("Tabelseluruhmahasiswa.fxml"));
        Scene cari = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(cari);
        w.show();
    }
    
    @FXML 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // XYChart.Series setData = new XYChart.Series<>();
       // setData.getData().add(new XYChart.Data("Edon", 2000));
       // grafik.getData().addAll(setData);
    }

    
}
