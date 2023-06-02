package Logica;

import Interfaz.SeleccionarRegion;
import RespaldoLatino.main;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


public class SolicitudesDTO {
    private String primeraSolicitud;
    private String pais;
    private String region;
    main main = new main();
    ConexionPorPais conexionPais = new ConexionPorPais();
    ObjectMapper objectMapper = new ObjectMapper();
    ListaTodosLosPaises todosPaises = new ListaTodosLosPaises();
    ListaLATAM LATAM = new ListaLATAM();
    ListaPorRegion listaRegion = new ListaPorRegion();
    ListaSubRegion listaSubRegion = new ListaSubRegion();
    
    public void SolicitudesDTO(String primeraSolicitud) throws IOException{
        this.primeraSolicitud = primeraSolicitud;
         switch (primeraSolicitud){
                case "Pais Individual":
                    main.PaisesIndividual();
                break;
                case "Lista de TODOS los paises":
                    JsonNode paises = objectMapper.readTree(todosPaises.GetCountries());
                    main.SeleccionInformacion(paises, 2);
                break;
                case "Lista paises LATAM":
                    JsonNode latamNode = objectMapper.readTree(LATAM.GetCountriesLATAM());
                    main.SeleccionInformacion(latamNode, 3);
                break;
                case "Lista de paises por Region":
                    main.Region();
                break;
                case "Lista de paises por Sub Region":
                    main.SelecRegion();
        }
    }
    public void PaisIndividual(String pais) throws IOException{
        this.pais = pais;
        String country = conexionPais.ObtenerPais(pais);
        JsonNode jsonCountry = objectMapper.readTree(country);
        conexionPais.ConexionPorPais(jsonCountry);
    }
    public void Region(String region) throws IOException{
        this.region = region;
        JsonNode regionInfo = objectMapper.readTree(listaRegion.GetCountries(region));
        main.SeleccionInformacion(regionInfo, 4);
    }
    public void SubRegion(String region) throws IOException{
        this.region = region;
        JsonNode regionInfo = objectMapper.readTree(listaSubRegion.GetCountries(region));
        main.SeleccionInformacion(regionInfo, 5);
    }
}
