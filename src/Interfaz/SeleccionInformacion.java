/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaz;

import Logica.ConexionPorPais;
import Logica.ListaLATAM;
import Logica.ListaPorRegion;
import Logica.ListaSubRegion;
import Logica.ListaTodosLosPaises;
import com.fasterxml.jackson.databind.JsonNode;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.SwingUtilities;

/**
 *
 * @author Andrés Dardex
 */
public class SeleccionInformacion extends javax.swing.JPanel {
    private List<String> opcionesSeleccionadas = new ArrayList<>();
    ConexionPorPais conexPais = new ConexionPorPais();
    ListaTodosLosPaises conexPaises = new ListaTodosLosPaises();
    ListaLATAM listaLatam = new ListaLATAM();
    ListaPorRegion listaRegion = new ListaPorRegion();
    ListaSubRegion listaSubRegion = new ListaSubRegion();
    /**
     * Creates new form SeleccionInformacion
     */
    public SeleccionInformacion(JsonNode jsonCountries, int numero) {
        initComponents();
        btnAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JCheckBox[] checkBoxes = {NombrePais,Moneda,Capital,Idioma,Region,SubRegion,Poblacion,InicioSemana,Gini,TiempoZonal};
                for (JCheckBox checkBox : checkBoxes) {
                    if (checkBox.isSelected()) {
                        if (checkBox.getText().equals("Nombre Del Pais")){
                            opcionesSeleccionadas.add("NombrePais");
                        }
                        if (checkBox.getText().equals("Capital")){
                            opcionesSeleccionadas.add("Capital");
                        }
                        if (checkBox.getText().equals("Moneda")){
                            opcionesSeleccionadas.add("Moneda");
                        }
                        if (checkBox.getText().equals("Idioma/s")){
                            opcionesSeleccionadas.add("Idioma");
                        }
                        if (checkBox.getText().equals("Region")){
                            opcionesSeleccionadas.add("Region");
                        }
                        if (checkBox.getText().equals("Sub-Region")){
                            opcionesSeleccionadas.add("SubRegion");
                        }
                        if (checkBox.getText().equals("Poblacion")){
                            opcionesSeleccionadas.add("Poblacion");
                        }
                        if (checkBox.getText().equals("Inicio de semana")){
                            opcionesSeleccionadas.add("InicioSemana");
                        }
                        if (checkBox.getText().equals("Indice Gini")){
                            opcionesSeleccionadas.add("Gini");
                        }
                        if (checkBox.getText().equals("Tiempo Zonal")){
                            opcionesSeleccionadas.add("TiempoZonal");
                        }
                    }
                }
                switch(numero){
                    case 1:
                        try {
                    conexPais.informacion(opcionesSeleccionadas, jsonCountries);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(SeleccionInformacion.class.getName()).log(Level.SEVERE, null, ex);
                }
                    break;
                    case 2:
                        try {
                            conexPaises.informacion(opcionesSeleccionadas, jsonCountries);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(SeleccionInformacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                    case 3:
                        try {
                            listaLatam.informacion(opcionesSeleccionadas, jsonCountries);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(SeleccionInformacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                    case 4:
                        try {
                            listaRegion.informacion(opcionesSeleccionadas, jsonCountries);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(SeleccionInformacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                    case 5:
                    {
                        try {
                            listaSubRegion.informacion(opcionesSeleccionadas, jsonCountries);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(SeleccionInformacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
                
                Window window = SwingUtilities.windowForComponent(btnAceptar);
                window.dispose();
            }
        });
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SeleccionInformacion = new javax.swing.JPanel();
        RespaldoImagen = new javax.swing.JLabel();
        NombrePais = new javax.swing.JCheckBox();
        TiempoZonal = new javax.swing.JCheckBox();
        SubRegion = new javax.swing.JCheckBox();
        Region = new javax.swing.JCheckBox();
        Idioma = new javax.swing.JCheckBox();
        Capital = new javax.swing.JCheckBox();
        Moneda = new javax.swing.JCheckBox();
        InicioSemana = new javax.swing.JCheckBox();
        Gini = new javax.swing.JCheckBox();
        Poblacion = new javax.swing.JCheckBox();
        Mensaje = new javax.swing.JLabel();
        btnAceptar = new java.awt.Button();

        SeleccionInformacion.setBackground(new java.awt.Color(255, 255, 255));

        RespaldoImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Captura7.PNG"))); // NOI18N

        NombrePais.setBackground(new java.awt.Color(255, 255, 255));
        NombrePais.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        NombrePais.setForeground(new java.awt.Color(0, 0, 0));
        NombrePais.setText("Nombre Del Pais");
        NombrePais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombrePaisActionPerformed(evt);
            }
        });

        TiempoZonal.setBackground(new java.awt.Color(255, 255, 255));
        TiempoZonal.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        TiempoZonal.setForeground(new java.awt.Color(0, 0, 0));
        TiempoZonal.setText("Tiempo Zonal");
        TiempoZonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiempoZonalActionPerformed(evt);
            }
        });

        SubRegion.setBackground(new java.awt.Color(255, 255, 255));
        SubRegion.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        SubRegion.setForeground(new java.awt.Color(0, 0, 0));
        SubRegion.setText("Sub-Region");

        Region.setBackground(new java.awt.Color(255, 255, 255));
        Region.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        Region.setForeground(new java.awt.Color(0, 0, 0));
        Region.setText("Region");

        Idioma.setBackground(new java.awt.Color(255, 255, 255));
        Idioma.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        Idioma.setForeground(new java.awt.Color(0, 0, 0));
        Idioma.setText("Idioma/s");

        Capital.setBackground(new java.awt.Color(255, 255, 255));
        Capital.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        Capital.setForeground(new java.awt.Color(0, 0, 0));
        Capital.setText("Capital");

        Moneda.setBackground(new java.awt.Color(255, 255, 255));
        Moneda.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        Moneda.setForeground(new java.awt.Color(0, 0, 0));
        Moneda.setText("Moneda");
        Moneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonedaActionPerformed(evt);
            }
        });

        InicioSemana.setBackground(new java.awt.Color(255, 255, 255));
        InicioSemana.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        InicioSemana.setForeground(new java.awt.Color(0, 0, 0));
        InicioSemana.setText("Inicio de semana");
        InicioSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioSemanaActionPerformed(evt);
            }
        });

        Gini.setBackground(new java.awt.Color(255, 255, 255));
        Gini.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        Gini.setForeground(new java.awt.Color(0, 0, 0));
        Gini.setText("Indice Gini");
        Gini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GiniActionPerformed(evt);
            }
        });

        Poblacion.setBackground(new java.awt.Color(255, 255, 255));
        Poblacion.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        Poblacion.setForeground(new java.awt.Color(0, 0, 0));
        Poblacion.setText("Poblacion");
        Poblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoblacionActionPerformed(evt);
            }
        });

        Mensaje.setBackground(new java.awt.Color(0, 0, 0));
        Mensaje.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        Mensaje.setForeground(new java.awt.Color(0, 0, 0));
        Mensaje.setText("Seleccione la informacion que desea obtener (puede elegir una o todas)");
        Mensaje.setToolTipText("");

        btnAceptar.setBackground(new java.awt.Color(51, 51, 51));
        btnAceptar.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setLabel("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeleccionInformacionLayout = new javax.swing.GroupLayout(SeleccionInformacion);
        SeleccionInformacion.setLayout(SeleccionInformacionLayout);
        SeleccionInformacionLayout.setHorizontalGroup(
            SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionInformacionLayout.createSequentialGroup()
                .addComponent(RespaldoImagen)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeleccionInformacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Mensaje)
                .addGap(68, 68, 68))
            .addGroup(SeleccionInformacionLayout.createSequentialGroup()
                .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeleccionInformacionLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeleccionInformacionLayout.createSequentialGroup()
                                .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Poblacion)
                                    .addComponent(Capital))
                                .addGap(128, 128, 128)
                                .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Idioma)
                                    .addComponent(Gini)
                                    .addComponent(TiempoZonal)
                                    .addComponent(Moneda)
                                    .addComponent(SubRegion)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(InicioSemana)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeleccionInformacionLayout.createSequentialGroup()
                                    .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NombrePais)
                                        .addComponent(Region))
                                    .addGap(197, 197, 197)))))
                    .addGroup(SeleccionInformacionLayout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SeleccionInformacionLayout.setVerticalGroup(
            SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeleccionInformacionLayout.createSequentialGroup()
                .addComponent(RespaldoImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombrePais)
                    .addComponent(SubRegion))
                .addGap(18, 18, 18)
                .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Region)
                    .addComponent(Moneda))
                .addGap(18, 18, 18)
                .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InicioSemana)
                    .addComponent(Gini))
                .addGap(18, 18, 18)
                .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TiempoZonal)
                    .addComponent(Poblacion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(SeleccionInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Capital)
                    .addComponent(Idioma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SeleccionInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SeleccionInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TiempoZonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiempoZonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TiempoZonalActionPerformed

    private void NombrePaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombrePaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombrePaisActionPerformed

    private void InicioSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioSemanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InicioSemanaActionPerformed

    private void GiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GiniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GiniActionPerformed

    private void PoblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoblacionActionPerformed
        // TO add your handling code here:
    }//GEN-LAST:event_PoblacionActionPerformed

    private void MonedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonedaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox Capital;
    public javax.swing.JCheckBox Gini;
    public javax.swing.JCheckBox Idioma;
    public javax.swing.JCheckBox InicioSemana;
    public javax.swing.JLabel Mensaje;
    public javax.swing.JCheckBox Moneda;
    public javax.swing.JCheckBox NombrePais;
    public javax.swing.JCheckBox Poblacion;
    public javax.swing.JCheckBox Region;
    public javax.swing.JLabel RespaldoImagen;
    public javax.swing.JPanel SeleccionInformacion;
    public javax.swing.JCheckBox SubRegion;
    public javax.swing.JCheckBox TiempoZonal;
    public java.awt.Button btnAceptar;
    // End of variables declaration//GEN-END:variables
}
