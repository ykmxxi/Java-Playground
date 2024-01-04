package chap12;

public class CarMain {

    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.setCar(new K3Car());
        driver.drive();

        driver.setCar(new Model3Car());
        driver.drive();
    }

}
