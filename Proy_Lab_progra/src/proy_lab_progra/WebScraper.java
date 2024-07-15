
package proy_lab_progra;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebScraper {
    public static String extractMiPerfilInfo(String username, String password) throws IOException {
        // Autenticar en la página web
        Document doc = Jsoup.connect("https://sum.unmsm.edu.pe/alumnoWebSum/login")
               .data("username", username)
               .data("password", password)
               .post();

        // Extraer la información de "Mi perfil"
        Element miPerfilElement = doc.select("div.mi-perfil").first();
        String miPerfilInfo = miPerfilElement.text();
        return miPerfilInfo;
    }
}