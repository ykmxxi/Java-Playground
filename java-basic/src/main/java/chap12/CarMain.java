package chap12;

public class CarMain {

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setK3Car(new K3Car());

        driver.drive();
    }

}
