import org.testng.annotations.DataProvider;


public class CustomDataProviderClass {

    @DataProvider(name = "TestDataProvider")
    public Object[][] CustomDataProviderClass (){

        Object[][] samples =
                {{'#',false},
                {'9',true},
                {'0',true},
                {'a',true},
                {'A',true},
                {'z',true},
                {'Z',true},
                {'-',true},
                {'\u0000', false},
                {'.', false}};

        return samples;
    }
}
