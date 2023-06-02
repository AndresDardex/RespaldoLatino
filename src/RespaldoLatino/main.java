package RespaldoLatino;

import Interfaz.PrimeraSolicitud;
import Interfaz.ResultadoSubRegion;
import Interfaz.ResultadosLATAM;
import Interfaz.ResultadosPaisIndividual;
import Interfaz.ResultadosPorRegion;
import Interfaz.SeleccionInformacion;
import Interfaz.SeleccionPais;
import Interfaz.SeleccionarRegion;
import Interfaz.SeleccionarSubRegion;
import Interfaz.TodosLosPaisesResultados;
import com.fasterxml.jackson.databind.JsonNode;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class main {

    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PrimeraSolicitud primeraSolicitud = new PrimeraSolicitud();
        frame.setContentPane(primeraSolicitud.jPanel1);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);   
    }
    public void PaisesIndividual(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeleccionPais seleccionPais = new SeleccionPais();
        frame.setContentPane(seleccionPais.PanelPrincipal);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);   
    }
    public void SeleccionInformacion(JsonNode jsonCountries, int numero){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeleccionInformacion seleccionInfo = new SeleccionInformacion(jsonCountries, numero);
        frame.setContentPane(seleccionInfo.SeleccionInformacion);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void MostrarResultados(String resultados, ImageIcon bandera, ImageIcon escudo){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ResultadosPaisIndividual resultadosPais = new ResultadosPaisIndividual(resultados, bandera, escudo);
        frame.setContentPane(resultadosPais.ResultadosPaisIndividual);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void TodosPaises(String resultados){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TodosLosPaisesResultados resultadosPaises = new TodosLosPaisesResultados(resultados);
        frame.setContentPane(resultadosPaises.ResultadosPaises);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void LATAM(String resultados){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ResultadosLATAM resultadosLatam = new ResultadosLATAM(resultados);
        frame.setContentPane(resultadosLatam.ResultadosPaises);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void Region(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeleccionarRegion region = new SeleccionarRegion();
        frame.setContentPane(region.PanelPrincipal);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void ResultadosRegion(String resultados){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ResultadosPorRegion resultadosRegion = new ResultadosPorRegion(resultados);
        frame.setContentPane(resultadosRegion.PanelPrincipal);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void SelecRegion(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeleccionarSubRegion resultadosSubRegion = new SeleccionarSubRegion();
        frame.setContentPane(resultadosSubRegion.PanelPrincipal);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void ResultadosSubRegion(String resultados){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ResultadoSubRegion resultadosSubRegion = new ResultadoSubRegion(resultados);
        frame.setContentPane(resultadosSubRegion.PanelPrincipal);
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
