import org.testng.annotations.*;


public class classname {

    @BeforeSuite
    public void beforesuite(){
        System.out.println("beforesuite");
    }

    @BeforeClass
    public void beforeclass(){
        System.out.println("beforeclass");
    }

    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest");
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("beforemethod");
    }

    @Test
    public void test() {
        System.out.println("test");


    }


}
