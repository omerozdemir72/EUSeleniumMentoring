package TestNG;

import org.testng.annotations.*;

public class hiyerarsi {

    @BeforeSuite
    public void BeforeSuite(){

        System.out.println("BEFORE SUİTE --     Testi başlatan, ilk çalışan methoddur.");
    }
    @BeforeTest
    public void BeforeTest(){

        System.out.println("BEFORE TEST --   Suitten sonra teste geçiş anlamında çalışa methoddur.");
    }
@BeforeClass
    public void BeforeClass(){
    System.out.println("BEFORE CLASS  --    Class başında ve before testten sonra çalışır");

}
@BeforeMethod
    public void BeforeMethod(){

    System.out.println("BEFORE METHOD  --- Her test methodundan önce çalışır...");
}

@Test
    public void Test1(){

    System.out.println("TEST 1 -------------------------");
}
    @Test
    public void Test2(){

        System.out.println("TEST 2 -------------------------");
    }


    @AfterMethod
    public void AfterMethod(){


        System.out.println("AFTER  METHOD ---  Her test methodundan sonra çalışır...");
    }

    @AfterClass
    public void AfterClass(){

        System.out.println("AFTER CLASS --  Classtaki test işlemi tamamlandıgında çalışır.");
    }

    @AfterTest
    public void AfterTest(){

        System.out.println("AFTER TEST --    After classtan sonra çalışır.");
    }

    @AfterSuite
    public void AfterSuite(){

        System.out.println("AFTER SUİTE -- En son çalışır. Suite'i kapatır..");
    }


}
