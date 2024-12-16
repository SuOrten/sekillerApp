package tr.gov.turkiye.sekilapp.jasonreaderandwriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import tr.gov.turkiye.sekilapp.sekil.Sekil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JasonWriter {
    public static void Writer (String filepath, ArrayList<Sekil> sekils) {

        try {
            ArrayList<Sekil> sekils2 = new ArrayList<>();
            for (Sekil sekil1: sekils
                 ) {
                sekils2.add(sekil1);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filepath), sekils2);

            System.out.println("Objeler JSON dosyasına yazıldı.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
