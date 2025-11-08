// ----- Product Interfaces -----
interface Button {
    void paint();
}

interface Checkbox {
    void check();
}

// ----- Light Theme Implementations -----
class LightButton implements Button {
    public void paint() {
        System.out.println("Rendering a Light Theme Button");
    }
}

class LightCheckbox implements Checkbox {
    public void check() {
        System.out.println("Light Theme Checkbox checked");
    }
}

// ----- Dark Theme Implementations -----
class DarkButton implements Button {
    public void paint() {
        System.out.println("Rendering a Dark Theme Button");
    }
}

class DarkCheckbox implements Checkbox {
    public void check() {
        System.out.println("Dark Theme Checkbox checked");
    }
}

// ----- Abstract Factory Interface -----
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// ----- Concrete Factories -----
class LightThemeFactory implements GUIFactory {
    public Button createButton() {
        return new LightButton();
    }

    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

class DarkThemeFactory implements GUIFactory {
    public Button createButton() {
        return new DarkButton();
    }

    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}

// ----- Client -----
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        String theme = "dark";  // You can change to "light" or "dark"

        GUIFactory factory;

        if (theme.equalsIgnoreCase("light")) {
            factory = new LightThemeFactory();
        } else {
            factory = new DarkThemeFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.check();
    }
}