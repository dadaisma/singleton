{/*

public class Main {
    private Undo undo;

    public Main() {
        this.undo = Undo.getInstance();
    }

    // Mètode per gestionar les opcions introduïdes per consola
    public void handleConsoleOption(String option) {
        switch (option) {
            case "add":
                this.undo.addCommand("Add something");
                System.out.println("Command added.");
                break;
            case "remove":
                String removedCommand = this.undo.removeLastCommand();
                if (removedCommand != null) {
                    System.out.println("Removed command: " + removedCommand);
                } else {
                    System.out.println("No commands to remove.");
                }
                break;
            case "list":
                String[] commands = this.undo.listCommands();
                System.out.println("Last commands:");
                for (int i = 0; i < commands.length; i++) {
                    System.out.println((i + 1) + ". " + commands[i]);
                }
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    // Mètode main
    public static void main(String[] args) {
        Main main = new Main();
        // Afegir els paràmetres del mètode main com opcions
        main.handleConsoleOption("add");
        main.handleConsoleOption("add");
        main.handleConsoleOption("list");
        main.handleConsoleOption("remove");
        main.handleConsoleOption("list");
        for (String arg : args) {
            main.handleConsoleOption(arg);
        }
    }
}}