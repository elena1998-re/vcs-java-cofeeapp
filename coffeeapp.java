public class CoffeeApp {
    public static void main (String[] args) {
        // 1. Let's get ourselves a coffee machine
        CoffeeMachine homeCoffeeMachine = new CoffeeMachine();

        // 2. Let's create a container object
        Container cup = new Cup();
        Container teapot = new Teapot();

        // 3. Let's pour some coffee
        homeCoffeeMachine.pour(teapot);
        System.out.println("The teapot contains " + teapot.getVolume() + " L of coffee.");
        System.out.println("Is the teapot full? " + teapot.isFull());

        homeCoffeeMachine.pour(cup);
        System.out.println("The cup contains " + cup.getVolume() + " L of coffee.");
        System.out.println("Is the cup full? " + cup.isFull());

        // 4. Let's draw a cup of coffee
        Cup coffeeCup = new Cup();
        System.out.println(coffeeCup.toString());
    }
}

class CoffeeMachine {
    void pour(Container container) {
        while (!container.isFull()) {
            container.setVolume(container.getVolume() + 0.01f);
        }
    }
}

class Container {
    final int MAX_VOLUME = 200; // 0.2L
    private float volume = 0.0f; // 0.0L

    float getVolume() {
        return volume;
    }

    void setVolume(float volume) {
        if (volume < 0 || volume > MAX_VOLUME) {
            System.err.println("WRONG VOLUME!!!");
        } else {
            this.volume = volume;
        }
    }

    boolean isFull() {
        return volume >= MAX_VOLUME * 0.95f; // 5%
    }
}

class Cup extends Container {
    public String toString() {
        String out =
        "+------------------+\n" +
        " \\                / \n" +
        "  \\~~~~~~~~~~~~~~/  \n" +
        "   \\            /   \n" +
        "    +_ _ _ _ _ _+   \n";
        return out;
    }
}

class Teapot extends Container {
}

