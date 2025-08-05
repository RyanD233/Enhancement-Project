import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;

    // Panel margin values
    private final int TOP = 200;
    private final int LEFT = 200;
    private final int BOTTOM = 200;
    private final int RIGHT = 200;

    // Grid Layout values
    private final int NUM_ROWS = 0; // A value of zero allows for infinite rows
    private final int NUM_COLUMNS = 2;
    private final int textFieldLength = 10;

    // Stores inputs
    private HashMap<String, JTextField> dogTextFields = new HashMap<>();
    private HashMap<String, JComboBox> dogComboFields = new HashMap<>();

    private HashMap<String, JTextField> monkeyTextFields = new HashMap<>();
    private HashMap<String, JComboBox> monkeyComboFields = new HashMap<>();

    private HashMap<String, JTextField> reserveTextFields = new HashMap<>();
    private HashMap<String, JComboBox> reserveComboFields = new HashMap<>();

    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public GUI() {
        // Setup window
        frame = new JFrame();
        frame.setTitle("Rescue Animal");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create cards
        JPanel mainMenu = createMainMenu();
        JPanel intakeDog = createDogForm();
        JPanel intakeMonkey = createMonkeyForm();
        JPanel reserveAnimal = createReserveForm();

        panel = new JPanel(new CardLayout());
        panel.add(mainMenu, "Main Menu");
        panel.add(intakeDog, "Intake Dog");
        panel.add(intakeMonkey, "Intake Monkey");
        panel.add(reserveAnimal, "Reserve Animal");

        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Make window visible
        frame.pack();
        frame.setVisible(true);
    }

    // Creates a popup for errors or confirmation
    private void createPopup(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    // Checks if the string is an integer
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Builds the main menu
    private JPanel createMainMenu() {
        JPanel mainMenu = new JPanel();
        mainMenu.setBorder(BorderFactory.createEmptyBorder(TOP, LEFT, BOTTOM, RIGHT));
        mainMenu.setLayout(new GridLayout(NUM_ROWS, NUM_COLUMNS));

        JButton intakeDog = new JButton("Intake new dog");
        intakeDog.setActionCommand("Intake Dog");
        intakeDog.addActionListener(this);
        mainMenu.add(intakeDog);

        JButton intakeMonkey = new JButton("Intake new monkey");
        intakeMonkey.setActionCommand("Intake Monkey");
        intakeMonkey.addActionListener(this);
        mainMenu.add(intakeMonkey);

        JButton reserveAnimal = new JButton("Reserve animal");
        reserveAnimal.setActionCommand("Reserve Animal");
        reserveAnimal.addActionListener(this);
        mainMenu.add(reserveAnimal);

        JButton showDogs = new JButton("Show dog names");
        showDogs.setActionCommand("Show Dogs");
        showDogs.addActionListener(this);
        mainMenu.add(showDogs);

        JButton showMonkeys = new JButton("Show monkey names");
        showMonkeys.setActionCommand("Show Monkeys");
        showMonkeys.addActionListener(this);
        mainMenu.add(showMonkeys);

        JButton showAvailable = new JButton("Show available animals");
        showAvailable.setActionCommand("Show Available");
        showAvailable.addActionListener(this);
        mainMenu.add(showAvailable);

        return mainMenu;
    }

    // Builds the form for dog information
    private JPanel createDogForm() {
        // Options for combo boxes
        String[] genders = {"Male", "Female"};
        String[] trainingStatus = {"In service", "Not in service"};
        String[] reserved = {"Is reserved", "Not reserved"};

        JPanel dogForm = new JPanel();
        dogForm.setBorder(BorderFactory.createEmptyBorder(TOP, LEFT, BOTTOM, RIGHT));
        dogForm.setLayout(new GridLayout(NUM_ROWS, NUM_COLUMNS));

        dogForm.add(new JLabel("Name: "));
        JTextField name = new JTextField(textFieldLength);
        dogTextFields.put("Name", name);
        dogForm.add(name);

        dogForm.add(new JLabel("Breed: "));
        JTextField breed = new JTextField(textFieldLength);
        dogTextFields.put("Breed", breed);
        dogForm.add(breed);

        dogForm.add(new JLabel("Gender: "));
        JComboBox<String> gender = new JComboBox<String>(genders);
        dogComboFields.put("Gender", gender);
        dogForm.add(gender);

        dogForm.add(new JLabel("Age: "));
        JTextField age = new JTextField(textFieldLength);
        dogTextFields.put("Age", age);
        dogForm.add(age);

        dogForm.add(new JLabel("Weight: "));
        JTextField weight = new JTextField(textFieldLength);
        dogTextFields.put("Weight", weight);
        dogForm.add(weight);

        dogForm.add(new JLabel("Acquisition date: "));
        JTextField acquisitionDate = new JTextField(textFieldLength);
        dogTextFields.put("Acquisition Date", acquisitionDate);
        dogForm.add(acquisitionDate);

        dogForm.add(new JLabel("Acquisition country"));
        JTextField acquisitionCountry = new JTextField(textFieldLength);
        dogTextFields.put("Acquisition Country", acquisitionCountry);
        dogForm.add(acquisitionCountry);

        dogForm.add(new JLabel("Training status: "));
        JComboBox<String> training = new JComboBox<String>(trainingStatus);
        dogComboFields.put("Training Status", training);
        dogForm.add(training);

        dogForm.add(new JLabel("Reserve status: "));
        JComboBox<String> reserveStatus = new JComboBox<String>(reserved);
        dogComboFields.put("Reserve Status", reserveStatus);
        dogForm.add(reserveStatus);

        dogForm.add(new JLabel("Service country: "));
        JTextField serviceCountry = new JTextField(textFieldLength);
        dogTextFields.put("Service Country", serviceCountry);
        dogForm.add(serviceCountry);

        JButton back = new JButton("Back");
        back.setActionCommand("Back");
        back.addActionListener(this);
        dogForm.add(back);

        JButton save = new JButton("Save");
        save.setActionCommand("Dog Form Save");
        save.addActionListener(this);
        dogForm.add(save);

        return dogForm;
    }

    // Builds the form for monkey information
    private JPanel createMonkeyForm() {
        // Options for combo boxes
        String[] speciesList = new String[] {"Capuchin", "Guenon", "Macaque", "Marmoset",
                "Squirrel monkey", "Tamarin"};
        String[] genders = {"Male", "Female"};
        String[] trainingStatus = {"In service", "Not in service"};
        String[] reserved = {"Is reserved", "Not reserved"};

        JPanel monkeyForm = new JPanel();
        monkeyForm.setBorder(BorderFactory.createEmptyBorder(TOP, LEFT, BOTTOM, RIGHT));
        monkeyForm.setLayout(new GridLayout(NUM_ROWS, NUM_COLUMNS));

        monkeyForm.add(new JLabel("Name: "));
        JTextField name = new JTextField(textFieldLength);
        monkeyTextFields.put("Name", name);
        monkeyForm.add(name);

        monkeyForm.add(new JLabel("Species: "));
        JComboBox<String> species = new JComboBox<String>(speciesList);
        monkeyComboFields.put("Species", species);
        monkeyForm.add(species);

        monkeyForm.add(new JLabel("Gender: "));
        JComboBox<String> gender = new JComboBox<String>(genders);
        monkeyComboFields.put("Gender", gender);
        monkeyForm.add(gender);

        monkeyForm.add(new JLabel("Age: "));
        JTextField age = new JTextField(textFieldLength);
        monkeyTextFields.put("Age", age);
        monkeyForm.add(age);

        monkeyForm.add(new JLabel("Weight: "));
        JTextField weight = new JTextField(textFieldLength);
        monkeyTextFields.put("Weight", weight);
        monkeyForm.add(weight);

        monkeyForm.add(new JLabel("Tail Length: "));
        JTextField tailLength = new JTextField(textFieldLength);
        monkeyTextFields.put("Tail Length", tailLength);
        monkeyForm.add(tailLength);

        monkeyForm.add(new JLabel("Height: "));
        JTextField height = new JTextField(textFieldLength);
        monkeyTextFields.put("Height", height);
        monkeyForm.add(height);

        monkeyForm.add(new JLabel("Body Length: "));
        JTextField bodyLength = new JTextField(textFieldLength);
        monkeyTextFields.put("Body Length", bodyLength);
        monkeyForm.add(bodyLength);

        monkeyForm.add(new JLabel("Acquisition date: "));
        JTextField acquisitionDate = new JTextField(textFieldLength);
        monkeyTextFields.put("Acquisition Date", acquisitionDate);
        monkeyForm.add(acquisitionDate);

        monkeyForm.add(new JLabel("Acquisition country"));
        JTextField acquisitionCountry = new JTextField(textFieldLength);
        monkeyTextFields.put("Acquisition Country", acquisitionCountry);
        monkeyForm.add(acquisitionCountry);

        monkeyForm.add(new JLabel("Training status: "));
        JComboBox<String> training = new JComboBox<String>(trainingStatus);
        monkeyComboFields.put("Training Status", training);
        monkeyForm.add(training);

        monkeyForm.add(new JLabel("Reserve status: "));
        JComboBox<String> reserveStatus = new JComboBox<String>(reserved);
        monkeyComboFields.put("Reserve Status", reserveStatus);
        monkeyForm.add(reserveStatus);

        monkeyForm.add(new JLabel("Service country: "));
        JTextField serviceCountry = new JTextField(textFieldLength);
        monkeyTextFields.put("Service Country", serviceCountry);
        monkeyForm.add(serviceCountry);

        JButton back = new JButton("Back");
        back.setActionCommand("Back");
        back.addActionListener(this);
        monkeyForm.add(back);

        JButton save = new JButton("Save");
        save.setActionCommand("Monkey Form Save");
        save.addActionListener(this);
        monkeyForm.add(save);

        return monkeyForm;
    }

    private JPanel createReserveForm() {
        // Options for combo box
        String[] animalTypes = {"Dog", "Monkey"};

        JPanel reserveForm = new JPanel();
        reserveForm.setBorder(BorderFactory.createEmptyBorder(TOP, LEFT, BOTTOM, RIGHT));
        reserveForm.setLayout(new GridLayout(NUM_ROWS, NUM_COLUMNS));

        reserveForm.add(new JLabel("Animal Type: "));
        JComboBox<String> animalType = new JComboBox<String>(animalTypes);
        reserveComboFields.put("Animal Type", animalType);
        reserveForm.add(animalType);

        reserveForm.add(new JLabel("Reserve Country"));
        JTextField reserveCountry = new JTextField(textFieldLength);
        reserveTextFields.put("Reserve Country", reserveCountry);
        reserveForm.add(reserveCountry);

        JButton back = new JButton("Back");
        back.setActionCommand("Back");
        back.addActionListener(this);
        reserveForm.add(back);

        JButton save = new JButton("Reserve");
        save.setActionCommand("Reserve Form Reserve");
        save.addActionListener(this);
        reserveForm.add(save);

        return reserveForm;
    }

    // Validates text inputs from the user
    private boolean validateDogInfo() {
        // Makes sure the same name is not found in our list
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(dogTextFields.get("Name").getText())) {
                createPopup(dogTextFields.get("Name").getText() + " is already stored.");
                return false;
            }
        }
        // Makes sure age is a positive integer or 0
        if (!(isInteger(dogTextFields.get("Age").getText())
                && Integer.parseInt(dogTextFields.get("Age").getText()) >= 0)) {
            createPopup("Age needs to be a positive integer or 0.");
            return false;
        }
        if (!(isInteger(dogTextFields.get("Weight").getText())
                && Integer.parseInt(dogTextFields.get("Weight").getText()) >= 0)) {
            createPopup("Weight needs to be a positive integer or 0.");
            return false;
        }
        return true;
    }

    private boolean validateMonkeyInfo() {
        for(Monkey monkey: monkeyList) {
            if (monkey.getName().equalsIgnoreCase(monkeyTextFields.get("Name").getText())) {
                createPopup(monkeyTextFields.get("Name").getText() + " is already stored.");
                return false;
            }
        }
        // Makes sure age is a positive integer or 0
        if (!(isInteger(monkeyTextFields.get("Age").getText())
                && Integer.parseInt(monkeyTextFields.get("Age").getText()) >= 0)) {
            createPopup("Age needs to be a positive integer or 0.");
            return false;
        }
        if (!(isInteger(monkeyTextFields.get("Weight").getText())
                && Integer.parseInt(monkeyTextFields.get("Weight").getText()) >= 0)) {
            createPopup("Weight needs to be a positive integer or 0.");
            return false;
        }
        if (!(isInteger(monkeyTextFields.get("Tail Length").getText())
                && Integer.parseInt(monkeyTextFields.get("Tail Length").getText()) >= 0)) {
            createPopup("Tail length needs to be a positive integer or 0.");
            return false;
        }
        if (!(isInteger(monkeyTextFields.get("Height").getText())
                && Integer.parseInt(monkeyTextFields.get("Height").getText()) >= 0)) {
            createPopup("Height needs to be a positive integer or 0.");
            return false;
        }
        if (!(isInteger(monkeyTextFields.get("Body Length").getText())
                && Integer.parseInt(monkeyTextFields.get("Body Length").getText()) >= 0)) {
            createPopup("Body length needs to be a positive integer or 0.");
            return false;
        }
        return true;
    }

    // Handles button presses
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout)(panel.getLayout());

        // Switches the card based on the button pressed
        if ("Intake Dog".equals(e.getActionCommand())) {
            cl.show(panel, "Intake Dog");
        }
        else if ("Intake Monkey".equals(e.getActionCommand())) {
            cl.show(panel, "Intake Monkey");
        }
        else if ("Reserve Animal".equals(e.getActionCommand())) {
            cl.show(panel, "Reserve Animal");
        }

        // Creates a comma separated list of the dog names
        else if ("Show Dogs".equals(e.getActionCommand())) {
            StringBuilder list = new StringBuilder();

            for(int i = 0; i < dogList.size(); i++) {
                if (i < dogList.size() - 1) {
                    list.append(dogList.get(i).getName());
                    list.append(", ");
                }
                else {
                    list.append(dogList.get(i).getName());
                }
            }
            createPopup(list.toString());
        }
        else if ("Show Monkeys".equals(e.getActionCommand())) {
            StringBuilder list = new StringBuilder();

            for(int i = 0; i < monkeyList.size(); i++) {
                if (i < monkeyList.size() - 1) {
                    list.append(monkeyList.get(i).getName());
                    list.append(", ");
                }
                else {
                    list.append(monkeyList.get(i).getName());
                }
            }
            createPopup(list.toString());
        }
        // Displays the names of all animals that are not reserved and are in service
        else if ("Show Available".equals(e.getActionCommand())) {
            StringBuilder list = new StringBuilder();

            for (Dog dog: dogList) {
                if ((!dog.getReserved()) &&
                        (dog.getTrainingStatus().equalsIgnoreCase("in service"))) {
                    list.append(dog.getName());
                    list.append(", ");
                }
            }
            for (int i = 0; i < monkeyList.size(); i++) {
                Monkey monkey = monkeyList.get(i);
                if ((!monkey.getReserved()) &&
                        (monkey.getTrainingStatus().equalsIgnoreCase("in service"))) {
                    if (i < monkeyList.size() - 1) {
                        list.append(monkey.getName());
                        list.append(", ");
                    }
                    else {
                        list.append(monkey.getName());
                    }
                }
            }
            createPopup(list.toString());
        }
        else if ("Back".equals(e.getActionCommand())) {
            cl.show(panel, "Main Menu");
        }

        // Create a dog object and store it if input is valid
        else if ("Dog Form Save".equals(e.getActionCommand())) {
            if (validateDogInfo()) {
                String name = dogTextFields.get("Name").getText();
                String breed = dogTextFields.get("Breed").getText();
                String gender = (String) dogComboFields.get("Gender").getSelectedItem();
                String age = dogTextFields.get("Age").getText();
                String weight = dogTextFields.get("Weight").getText();
                String acquisitionDate = dogTextFields.get("Acquisition Date").getText();
                String acquisitionCountry = dogTextFields.get("Acquisition Country").getText();
                String trainingStatus = (String) dogComboFields.get("Training Status").getSelectedItem();
                boolean reserved = false;
                String serviceCountry = dogTextFields.get("Service Country").getText();

                if ("Is reserved".equals((String) dogComboFields.get("Reserve Status").getSelectedItem())) {
                    reserved = true;
                }
                // Creates a new dog object, adds it to dogList, and displays a confirmation
                Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate,
                        acquisitionCountry, trainingStatus, reserved, serviceCountry);
                dogList.add(dog);

                createPopup(name + " saved.");
            }
        }
        // Create a monkey object and store it if input is valid
        else if ("Monkey Form Save".equals(e.getActionCommand())) {
            if (validateMonkeyInfo()) {
                String name = monkeyTextFields.get("Name").getText();
                String species = (String) monkeyComboFields.get("Species").getSelectedItem();
                String gender = (String) monkeyComboFields.get("Gender").getSelectedItem();
                String age = monkeyTextFields.get("Age").getText();
                String weight = monkeyTextFields.get("Weight").getText();
                String tailLength = monkeyTextFields.get("Tail Length").getText();
                String height = monkeyTextFields.get("Height").getText();
                String bodyLength = monkeyTextFields.get("Body Length").getText();
                String acquisitionDate = monkeyTextFields.get("Acquisition Date").getText();
                String acquisitionCountry = monkeyTextFields.get("Acquisition Country").getText();
                String trainingStatus = (String) monkeyComboFields.get("Training Status").getSelectedItem();
                boolean reserved = false;
                String serviceCountry = monkeyTextFields.get("Service Country").getText();

                if ("Is reserved".equals((String) monkeyComboFields.get("Reserve Status").getSelectedItem())) {
                    reserved = true;
                }

                Monkey monkey = new Monkey(name, species, gender, age, weight, tailLength, height,
                        bodyLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, serviceCountry);
                monkeyList.add(monkey);

                createPopup(name + " saved.");
            }
        }
        else if ("Reserve Form Reserve".equals(e.getActionCommand())) {
            String animalType = (String)reserveComboFields.get("Animal Type").getSelectedItem();
            String reserveCountry = reserveTextFields.get("Reserve Country").getText();

            boolean found = false;
            // If the user wants a dog, this searches through dogList
            if (animalType.equalsIgnoreCase("Dog")) {
                for (Dog dog: dogList) {
                    // Checks if the dog is in service, not reserved, and in the correct country
                    if ((!dog.getReserved()) && (dog.getInServiceLocation().equalsIgnoreCase(reserveCountry))
                            && (dog.getTrainingStatus().equalsIgnoreCase("in service"))) {
                        // Sets the reserved status of the dog to true and displays a confirmation
                        dog.setReserved(true);
                        found = true;
                        createPopup("Reserved " + dog.getName());
                    }
                }
            }
            // If the user wants a monkey, this searches through the monkeyList
            else if (animalType.equalsIgnoreCase("monkey")) {
                for (Monkey monkey: monkeyList) {
                    // Checks if the monkey is in service, not reserved, and in the correct country
                    if ((!monkey.getReserved()) && (monkey.getInServiceLocation().equalsIgnoreCase(reserveCountry))
                            && (monkey.getTrainingStatus().equalsIgnoreCase("in service"))) {
                        // Sets the reserved status of the monkey to true and displays a confirmation
                        monkey.setReserved(true);
                        found = true;
                        createPopup("Reserved " + monkey.getName());
                    }
                }
            }
            if (!found) {
                createPopup("A matching animal could not be found or reserved.");
            }
        }
    }
}
