package tr.gov.turkiye.sekilapp.jasonreaderandwriter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tr.gov.turkiye.sekilapp.log.Logger;
import tr.gov.turkiye.sekilapp.sekil.Sekil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;


public class JasonReader {
    public static void Reader(String filepath, ArrayList<Sekil> sekils){


        ObjectMapper objectMapper = new ObjectMapper();

        File sekilJsonfile = new File(filepath);

        try {

            List<Sekil> sekils2 = objectMapper.readValue(sekilJsonfile, new TypeReference<List<Sekil>>() {
            });
            for (Sekil sekil1 : sekils2) {
                Logger.logMessage("Sekil Tipi " + sekil1.getClass().getSimpleName() + " Kenar: " + sekil1.getKenar() + ", Sembol: " + sekil1.getSembol() + "\n");
                sekils.add(sekil1);
            }

            Logger.logMessage("Json dosyasından objeler okundu");
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }catch (InvalidPropertiesFormatException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
