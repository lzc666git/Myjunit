import org.junit.*;

public class CalculatorTest {
    public Calculator cal;

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
        cal=new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @Test
    public void add() {
        System.out.println("add");
        Assert.assertEquals(3,cal.add(1,2));
    }

    @Test
    public void sub() {
        System.out.println("add");
        Assert.assertEquals(1,cal.sub(2,1));
    }
}