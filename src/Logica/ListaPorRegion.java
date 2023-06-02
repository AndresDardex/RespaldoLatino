package Logica;

import DataBase.PaisesDAO;
import RespaldoLatino.main;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListaPorRegion {
    private static final String SUBREGIONS = "https://restcountries.com/v3.1/region/";
    private JsonNode pais;
    private List<String> solicitud;
    private String nombre;
    private String moneda;
    private String simbolo;
    private String capital;
    private List<String> idioma;
    private String region;
    private String subRegion;
    private int poblacion ;
    private String inicioSemana;
    private String year;
    private String gini;
    public String mensaje;
    public StringBuilder mensajeBuilder = new StringBuilder();
    
    public String GetCountries(String SubRegion) throws IOException {
        URL url = new URL(SUBREGIONS + SubRegion );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
        connection.setRequestMethod("GET");
        
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
    public void informacion(List<String> solicitudUser, JsonNode jsonCountries ) throws MalformedURLException{
            this.solicitud = solicitudUser;
            this.pais = jsonCountries;
            main main = new main();
            ConexionPorPais conexionPais = new ConexionPorPais();
            if (!solicitud.isEmpty()){
                for (int quantity = 0; quantity < 70; quantity++) {
                    JsonNode countryNode = pais.get(quantity);
                    if (countryNode != null) {
                        for(String solicitudes : solicitud){
                            if(solicitudes.equals("NombrePais")){
                                this.nombre = pais.get(quantity).get("name").get("common").asText();
                                mensajeBuilder.append("El país es ").append(nombre).append("\n");
                            }
                            if(solicitudes.equals("Capital")){
                                JsonNode capitalNode = jsonCountries.get(quantity).get("capital");
                                if(capitalNode != null){
                                    this.capital = capitalNode.get(0).asText();
                                    mensajeBuilder.append("Su Capital es ").append(capital).append("\n");
                                }else{
                                    mensajeBuilder.append("No posee Capital").append("\n");;
                                }
                            }
                            if(solicitudes.equals("Moneda")){
                                JsonNode monedaNode = pais.get(quantity).get("currencies");
                                if(monedaNode != null){Iterator<String> fieldNames = monedaNode.fieldNames();
                                while (fieldNames.hasNext()) {
                                    String currencyCode = fieldNames.next();
                                    JsonNode currency = monedaNode.get(currencyCode);
                                    JsonNode simboloNode = currency.get("symbol");
                                    if(simboloNode != null){
                                        this.moneda = currency.get("name").asText();
                                        this.simbolo = currency.get("symbol").asText();
                                        mensajeBuilder.append("Su Moneda es: ").append(moneda).append(" y su simbolo es: ").append(simbolo).append("\n");
                                    }else{
                                        this.moneda = currency.get("name").asText();
                                        mensajeBuilder.append("Su Moneda es: ").append(moneda).append("\n");
                                    }
                                    }
                                }else{
                                    mensajeBuilder.append("No posee Moneda").append("\n");
                                }
                            }
                            if(solicitudes.equals("Idioma")){
                            idioma = new ArrayList<>();
                            JsonNode idiomaNode = pais.get(quantity).get("languages");
                            if (idiomaNode != null) {
                                Iterator<String> fieldNames = idiomaNode.fieldNames();
                                while (fieldNames.hasNext()) {
                                    String idiomaCode = fieldNames.next();
                                    idioma.add(idiomaNode.get(idiomaCode).toString().replace("\"", ""));
                                }
                            }

                            if (idioma.isEmpty()) {
                                mensajeBuilder.append("No tiene idiomas");
                            } else if (idioma.size() == 1) {
                                mensajeBuilder.append("Su idioma es: ").append(idioma.get(0));
                            } else {
                                mensajeBuilder.append("Sus idiomas son: ");
                                for (String lang : idioma) {
                                    mensajeBuilder.append(lang).append(", ");
                                }
                                mensajeBuilder.setLength(mensajeBuilder.length() - 2); // Eliminar la última coma y espacio
                            }
                            mensajeBuilder.append("\n");

                        }
                            if(solicitudes.equals("Region")){
                                this.region = pais.get(quantity).get("region").toString().replace("\"", "");
                                mensajeBuilder.append("Su Region es ").append(region).append("\n");
                            }
                            if(solicitudes.equals("SubRegion")){
                                JsonNode paisNode = pais.get(quantity).get("subregion");
                                if(paisNode != null){
                                    this.subRegion = paisNode.asText();
                                    mensajeBuilder.append("Su Sub-Region es ").append(subRegion).append("\n");
                                }else{
                                    mensajeBuilder.append("Su Sub-Region es ").append("No Tiene Sub Region").append("\n");
                                }
                                
                            }
                            if(solicitudes.equals("Poblacion")){
                                this.poblacion = pais.get(quantity).get("population").asInt();
                                mensajeBuilder.append("Tiene una poblacion de ").append(poblacion).append("\n");
                            }
                            if (solicitudes.equals("InicioSemana")) {
                                this.inicioSemana = pais.get(quantity).get("startOfWeek").asText();
                            String dia;
                            if (inicioSemana.equals("monday")) {
                                dia = "Lunes";
                            } else if (inicioSemana.equals("saturday")) {
                                dia = "Sábado";
                            } else if(inicioSemana.equals("sunday")){
                                dia = "Domingo";
                            }else{
                                dia = "error";
                            }
                            mensajeBuilder.append("Inicia la semana el día ").append(dia).append("\n");
                        }

                            if(solicitudes.equals("Gini")){
                                JsonNode giniNode = pais.get(quantity).get("gini");
                                if(giniNode != null){
                                    Iterator<String> fieldNames = giniNode.fieldNames();
                                    while(fieldNames.hasNext()){
                                        this.year = fieldNames.next();
                                        this.gini = giniNode.get(year).toString().replace("\"", "");
                                        mensajeBuilder.append("para el año ").append(year).append(" el indice Gini es de ").append(gini).append("\n");
                                    }
                                }else{
                                    mensajeBuilder.append("No posee Indice gini ").append("\n");
                                }

                            }
                            if(solicitudes.equals("TiempoZonal")){
                                String tZonal = pais.get(quantity).get("timezones").toString().replace("\"", "").replace("[", "").replace("]","");
                                mensajeBuilder.append("tu Tiempo Zonal es ").append(tZonal).append("\n");
                            }

                    }
                       mensajeBuilder.append("----------------------------------------------------------------------------------------------\n");  
                        
                }
                    // CONSTRUCCION DE LA BASE DE DATOS, ENVIO DE LA INFORMACION COMPLETA
            JsonNode countryNode2 = pais.get(quantity);
                    if (countryNode != null) {
                this.nombre = pais.get(quantity).get("name").get("common").asText();
                JsonNode capitalNode = jsonCountries.get(quantity).get("capital");
                        if(capitalNode != null){
                            this.capital = capitalNode.get(0).asText();
                        }else{
                            this.capital = null;
                        }
                JsonNode monedaNode = pais.get(quantity).get("currencies");
                        if(monedaNode != null){
                        Iterator<String> fieldNames = monedaNode.fieldNames();
                        while (fieldNames.hasNext()) {
                            String currencyCode = fieldNames.next();
                            JsonNode currency = monedaNode.get(currencyCode);
                            this.moneda = currency.get("name").asText();}
                        }else{
                            this.moneda = null;
                        }
                this.region = pais.get(quantity).get("region").toString().replace("\"", "");
                JsonNode paisNode = pais.get(quantity).get("subregion");
                        if(paisNode != null){
                            this.subRegion = paisNode.asText();
                        }else{
                            this.subRegion = null;
                        }
                this.poblacion = pais.get(quantity).get("population").asInt();
                this.inicioSemana = pais.get(quantity).get("startOfWeek").asText();
                JsonNode giniNode = pais.get(quantity).get("gini");
                        if(giniNode != null){
                            Iterator<String> fieldNames = giniNode.fieldNames();
                            while(fieldNames.hasNext()){
                                this.year = fieldNames.next();
                                this.gini = giniNode.get(year).toString().replace("\"", "");
                            }
                        }else{
                            this.gini = null;
                        }
                        PaisesDAO paisesDao = new PaisesDAO();
                        paisesDao.createTableRegion();
                        paisesDao.createRegion(nombre, capital, moneda, region, subRegion, subRegion, inicioSemana, gini);}

            }
                if(solicitud.isEmpty()){
                    mensajeBuilder.append("no escogiste una opcion");
                }
            }
            main.ResultadosRegion(mensajeBuilder.toString());
    }
}