public class Heizung {
    // Private Objekt-Attribute
    private int temperature;
    private int min;
    private int max;
    private int increment;

    // Konstruktor
    public Heizung(int startTemperature, int increment) {
        this.temperature = startTemperature;
        this.increment = increment;
        this.min = 0;  // Standardwert für Minimum
        this.max = 100;  // Standardwert für Maximum
    }

    // Getter für die aktuelle Temperatur
    public int getTemperature() {
        return this.temperature;
    }

    // Setter für die Temperatur (mit Validierung)
    public void setTemperature(int temperature) {
        if (temperature >= min && temperature <= max) {
            this.temperature = temperature;
        } else {
            System.out.println("Ungültige Temperatur. Muss zwischen " + min + " und " + max + " liegen.");
        }
    }

    // Getter für das Increment
    public int getIncrement() {
        return this.increment;
    }

    // Setter für das Increment (mit optionaler Validierung)
    public void setIncrement(int increment) {
        if (increment > 0) {
            this.increment = increment;
        } else {
            System.out.println("Inkrement muss größer als 0 sein.");
        }
    }

    // Methode zum Erhöhen der Temperatur
    public void waermerStellen() {
        if (this.temperature + this.increment <= this.max) {
            this.temperature += this.increment;
        } else {
            System.out.println("Maximale Temperatur erreicht.");
        }
    }

    // Methode zum Verringern der Temperatur
    public void kaelterStellen() {
        if (this.temperature - this.increment >= this.min) {
            this.temperature -= this.increment;
        } else {
            System.out.println("Minimale Temperatur erreicht.");
        }
    }

    // Main-Methode zur Simulation
    public static void main(String[] args) {
        // Heizung mit Startwert 20 und Inkrement 5 erstellen
        Heizung heizung = new Heizung(20, 5);

        // Getter verwenden
        System.out.println("Aktuelle Temperatur: " + heizung.getTemperature());

        // Setter verwenden, um Temperatur direkt festzulegen
        heizung.setTemperature(25);
        System.out.println("Neue Temperatur: " + heizung.getTemperature());

        // Inkrement ändern mit Setter
        heizung.setIncrement(2);

        // Temperatur erhöhen mit neuem Increment
        heizung.waermerStellen();
        System.out.println("Temperatur nach Erhöhung: " + heizung.getTemperature());

        heizung.kaelterStellen();
        System.out.println("Temperatur nach Verringerung: " + heizung.getTemperature());
    }
}
