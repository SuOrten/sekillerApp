package tr.gov.turkiye.sekilapp.main;

import tr.gov.turkiye.sekilapp.anatasyonlar.TestableClass;
import tr.gov.turkiye.sekilapp.anatasyonlar.TestableMethod;
import tr.gov.turkiye.sekilapp.log.Logger;
import tr.gov.turkiye.sekilapp.newscanner.Newscanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Mainanatasyonlar {



    public static void main(String[] args) {

    Newscanner newscanner = new Newscanner();

    if( newscanner.getClass().isAnnotationPresent(TestableClass.class)){
        for (Method method : newscanner.getClass().getDeclaredMethods()){
            if (method.isAnnotationPresent(TestableMethod.class)){

                try {

                    TestableMethod annotation = method.getAnnotation(TestableMethod.class);

                    char[] samples = annotation.samples();
                    Logger.logMessage("Çalıltırılan metod :"+method.getName()+"\n");


                    for (int i = 0; i < samples.length; i += 2) {
                        char sembol = samples[i];
                        boolean cevap=false;
                        if (samples[i+1]=='1'){
                            cevap=true;
                        }
                        Object result = method.invoke(newscanner, sembol);

                        System.out.println("denenen sembol: " + sembol + " , olması gereken sonuç: " + cevap + " , sonuç: " + result);

                        if ((boolean) result != cevap) {
                            Logger.logMessage("sembolKontrol fonksiyonu bir hata yaptı ve sembol: " + sembol+"\n");
                        } else {
                            Logger.logMessage("Bir sorun olmadı.\n");
                        }
                    }

                }catch (IllegalAccessException e){
                    Logger.logMessage("Erişim ile bir sorun oluştu\n");
                    e.getStackTrace();
                }catch (InvocationTargetException e){
                    Logger.logMessage("Invokasyon ile bir sorun oluştu\n");
                    e.getStackTrace();
                }



            }
        }
    }


    }

}
