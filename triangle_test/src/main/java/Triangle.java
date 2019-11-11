
public class Triangle {
    public boolean triangle(double a, double b, double c) {
        if (a<=0 || b<=0 || c<=0) {
            throw new IllegalArgumentException("The side can't be less than zero");
        }
        return a + b > c && a + c > b && c + b > a;
    }
}
