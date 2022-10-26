package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Generator;

import java.util.Random;

public class BunTest {

    private Bun bunCorrect;
    private Bun bunNull;
    private String randomString;
    private float randomPrice;

    @Before
    public void init() {
        randomString = Generator.getRandomString();
        randomPrice = new Random().nextFloat();
        bunCorrect = new Bun(randomString,  randomPrice);
        bunNull = new Bun(null, 0);
    }

    @Test
    public void getCorrectName() {
        Assert.assertEquals(randomString, bunCorrect.getName());
    }

    @Test
    public void getNullName() {
        Assert.assertNull("У булочки есть название", bunNull.getName());
    }

    @Test
    public void getCorrectPrice() {
        Assert.assertEquals(randomPrice, bunCorrect.getPrice(), .0001);
    }

    @Test
    public void getNullPrice() {
        Assert.assertEquals(0, bunNull.getPrice(), 0);
    }
}