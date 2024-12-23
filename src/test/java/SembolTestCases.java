import org.testng.Assert;
import org.testng.annotations.Test;
import tr.gov.turkiye.sekilapp.log.Logger;
import tr.gov.turkiye.sekilapp.newscanner.Newscanner;
import tr.gov.turkiye.sekilapp.newscanner.Newscanner.*;

public class SembolTestCases {

    @Test(dataProvider = "TestDataProvider",dataProviderClass = CustomDataProviderClass.class)
    void test1(char sembol,boolean answer){
        Newscanner newscanner = new Newscanner();
        Assert.assertEquals(newscanner.sembolKontrol(sembol),answer,"sembolKontrol fonksiyonu yanlış sonuç verdi ve sembol :"+sembol);



    }
}
