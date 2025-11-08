class Computer {
    // Fields
    private String CPU;
    private int RAM;
    private int storage;
    private String graphicsCard;

    // Private constructor (only Builder can create)
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    // Display computer details
    public void showSpecs() {
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM + "GB");
        System.out.println("Storage: " + storage + "GB");
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("-------------------------");
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;
        private String graphicsCard;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        // Build first computer
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM(32)
                .setStorage(1000)
                .setGraphicsCard("RTX 4080")
                .build();

        // Build second computer
        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM(16)
                .setStorage(512)
                .setGraphicsCard("Integrated Graphics")
                .build();

        // Show results
        System.out.println("Gaming PC Configuration:");
        gamingPC.showSpecs();

        System.out.println("Office PC Configuration:");
        officePC.showSpecs();
    }
}