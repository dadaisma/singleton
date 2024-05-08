class Undo {
    private static Undo instance;
    private String[] commands;
    private int size;
    private int index;

    private Undo() {
        this.size = 10; // Màxim 10 comandes
        this.commands = new String[size];
        this.index = 0;
    }

    // Mètode estàtic per obtenir l'única instància de la classe
    public static synchronized Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    // Afegir una comanda
    public void addCommand(String command) {
        if (index == size) {
            // Si la llista està plena, descartem la comanda més antiga
            for (int i = 0; i < size - 1; i++) {
                commands[i] = commands[i + 1];
            }
            index--;
        }
        commands[index++] = command;
    }

    // Eliminar l'última comanda
    public String removeLastCommand() {
        if (index == 0) {
            return null; // No hi ha comandes per eliminar
        }
        return commands[--index];
    }

    // Llistar les últimes comandes introduïdes
    public String[] listCommands() {
        String[] lastCommands = new String[index];
        for (int i = 0; i < index; i++) {
            lastCommands[i] = commands[i];
        }
        return lastCommands;
    }
}