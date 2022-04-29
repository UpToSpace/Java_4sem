package CarTest;

import Admin.Admin;
import Cars.Taxi;
import Cars.Type;
import Main.Car;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.print.Book;
import java.util.ArrayList;

public class TESTHUEST extends Assert {
    Admin admin;
    public TESTHUEST() throws Exception {
        admin = new Admin();
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod – аннотированный метод будет выполняться перед каждым тестовым методом.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod – аннотированный метод будет запускаться после каждого тестового метода.");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups – аннотирует методы, которые будут выполняться перед первым методом в любой из указанных групп.");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("@AfterGroups – аннотируется методы, которые будут выполняться после всех методом в любом из указанных групп.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass – указывает, что метод будет выполнен до всех тестовых методов тестового класса.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass  – аннотированный метод будет запущен после всех тестовых методов в текущем классе.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest - аннотированный метод будет запускаться до всех тестовых методов.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest – аннотированный метод будет запущен после всех тестовых методов, принадлежащих классам внутри тега <test>.");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite – указывает, что данный метод будет запускаться перед любым методом тестового класса.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite – указывает, что данный метод, будет запускаться после всех методов тестового класса.");
    }
    @Test(groups = {"unit"})
    public void testAddCar() {
        ArrayList<Car> cars = admin.cars;
        cars.forEach(System.out::println);
        Assert.assertNotNull(cars);
    }

    @Test
    public void testCompareCars() throws Exception {
        ArrayList<Car> cars = admin.cars;

        Assert.assertEquals(cars, admin.cars);
    }

    @Test(groups = {"unit"})
    public void testRemoveCar() throws Exception {
        ArrayList<Car> cars1 = new ArrayList<>();
        Taxi taxi = new Taxi(1000, 20.9, 370, Type.BUSINESS);
        cars1.add(taxi);
        cars1.remove(taxi);

        Assert.assertNotNull(admin.cars);
    }

    @Test(enabled = false)
    public void testAddCarsIgnore() {
        ArrayList<Car> cars = admin.cars;
        cars.forEach(System.out::println);

        Assert.assertNotNull(cars);
    }
}
