
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;


public class TriangleTest {
    private final Triangle triangle = new Triangle();

    @Test(expected = IllegalArgumentException.class)
    public void oneNegativeSide(){
        triangle.triangle(1,3,-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneZeroSide() {
        triangle.triangle(1,2,0);
    }

    @Test
    public void equilateralTriangle() {
        assertTrue(triangle.triangle(3,3,3));
    }

    @Test
    public void isoscelesTriangle() {
        assertTrue(triangle.triangle(1,3,3));
    }

    @Test
    public void rightTriangle() {
        assertTrue(triangle.triangle(5,4,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void allZeroSides() {
        triangle.triangle(0, 0, 0);
    }

    @Test
    public void sumOfTwoSidesEqualsThird() {
        assertFalse(triangle.triangle(1,2,3));
    }

    @Test
    public void existingTriangle() {
        assertTrue(triangle.triangle(4,5,3));
    }

    @Test
    public void oneOfTheSideIsMaxDouble() {
        assertFalse(triangle.triangle(Double.MAX_VALUE, 5, 3));
    }

    @Test
    public void allSidesIsMaxDouble() {
        assertTrue(triangle.triangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
    }
}