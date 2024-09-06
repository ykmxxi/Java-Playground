package chap02.item02.hierarchy;

import static chap02.item02.hierarchy.NyPizza.Size.SMALL;
import static chap02.item02.hierarchy.Pizza.Topping.HAM;
import static chap02.item02.hierarchy.Pizza.Topping.ONION;
import static chap02.item02.hierarchy.Pizza.Topping.SAUSAGE;

public class PizzaMain {

    public static void main(String[] args) {
        Pizza nyPizza = new NyPizza.Builder(SMALL)
                .addTopping(HAM)
                .addTopping(SAUSAGE)
                .build();

        Pizza calzone = new Calzone.Builder()
                .addTopping(HAM)
                .addTopping(ONION)
                .sauceInside()
                .build();

        nyPizza.print(); // NyPizza's toppings=[HAM, SAUSAGE]
        calzone.print(); // Calzone's toppings=[HAM, ONION]
    }

}
