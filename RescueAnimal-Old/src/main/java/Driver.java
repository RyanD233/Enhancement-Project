import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);

        // Continuously displays the menu for the user to use
        while (true) {
        	String input;
        	int choice = 0;
        	displayMenu();
        	
        	try {
        		input = scnr.nextLine();
        		// Checks if the user wants to quit out of menu
        		if (input.equalsIgnoreCase("q")) {
        			break;
        		}
        		// Converts the input into an integer
        		choice = Integer.parseInt(input);
        		// Takes their numbered choice and chooses an output
        		switch (choice) {
        		case 1:
        			intakeNewDog(scnr);
        			break;
        		case 2:
        			intakeNewMonkey(scnr);
        			break;
        		case 3:
        			reserveAnimal(scnr);
        			break;
        		case 4:
        			printAnimals("dog");
        			break;
        		case 5:
        			printAnimals("monkey");
        			break;
        		case 6:
        			printAnimals("available");
        			break;
        			// Outputs if integer was not 1-6
        			default:
        				System.out.println("Enter a number from 1 to 6!");
        		}
        	}
        	// Catches inputs that are not integers
        	catch(Exception excpt) {
        		System.out.println("Enter a number from 1 to 6!");
        	}
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("What is the dog's acquisition country?");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog reserved?(Enter true or false)");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("What is the dog's service country?");
        String inServiceCountry = scanner.nextLine();
        
        // Creates new dog object and adds it to dogList
        Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, 
        		acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(dog);
    }

    // Get input from user for new monkey
    public static void intakeNewMonkey(Scanner scanner) {
        String[] speciesList = new String[] {"Capuchin", "Guenon", "Macaque", "Marmoset",
        			                             "Squirrel monkey", "Tamarin"};
            
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        // Checks if the monkey is already in the system
        for(Monkey monkey: monkeyList) {
        	if(monkey.getName().equalsIgnoreCase(name)) {
            System.out.println("\n\nThis monkey is already in our system\n\n");
            return; //returns to menu
            }
        }
        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine();
        boolean found = false;
        // Checks if the monkey is an accepted species
        for(String speciesType: speciesList) {
            if(species.equalsIgnoreCase(speciesType)) {
            	found = true;
            	break;
            }
        }
        if (!found) {
        	System.out.println("Species not accepted.");
        	return; //returns to menu
        }
        System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the monkey's age");
        String age = scanner.nextLine();
        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is the monkey's tail length?");
        String tailLength = scanner.nextLine();
        System.out.println("What is the monkey's height?");
        String height = scanner.nextLine();
        System.out.println("What is the monkey's body length?");
        String bodyLength = scanner.nextLine();
        System.out.println("What is the monkey's acquisition date?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("What is the monkey's acquisition country?");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the monkey's training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the monkey reserved?");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("What is the Monkey's service country?");
        String inServiceCountry = scanner.nextLine();
            
        // Creates new monkey object and adds it to monkeyList
        Monkey monkey = new Monkey(name, species, gender, age, weight, tailLength,
            		                   height, bodyLength, acquisitionDate, acquisitionCountry,
            		                   trainingStatus, reserved, inServiceCountry);
        monkeyList.add(monkey);
        }

    // Reserves an animal for user if it is in service and not reserved
    public static void reserveAnimal(Scanner scanner) {
    	System.out.println("What type of animal do you want?");
     	String animalType = scanner.nextLine();
       	System.out.println("What country is the animal needed in?");
       	String serviceCountry = scanner.nextLine();
        	
       	boolean found = false;
       	// If the user wants a dog, this searches through dogList
       	if (animalType.equalsIgnoreCase("dog")) {
       		for (Dog dog: dogList) {
       			// Checks if the dog is in service, not reserved, and in the correct country
       			if ((!dog.getReserved()) && (dog.getInServiceLocation().equalsIgnoreCase(serviceCountry))
        				&& (dog.getTrainingStatus().equalsIgnoreCase("in service"))) {
        			// Sets the reserved status of the dog to true and prints the name of the dog reserved
       				dog.setReserved(true);
       				found = true;
       				System.out.println(dog.getName());
       			}
       		}
       	}
        // If the user wants a monkey, this searches through the monkeyList
       	else if (animalType.equalsIgnoreCase("monkey")) {
       		for (Monkey monkey: monkeyList) {
       			// Checks if the monkey is in service, not reserved, and in the correct country
       			if ((!monkey.getReserved()) && (monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry))
       					&& (monkey.getTrainingStatus().equalsIgnoreCase("in service"))) {
        			// Sets the reserved status of the monkey to true and prints the monkey's name
       				monkey.setReserved(true);
        			found = true;
        			System.out.println(monkey.getName());
        		}
       		}
       	}
       	// Printed if the animal is not found in the system
       	if (!found) {
       		System.out.println("No animals of that type and location are available.");
       	}
    }
    
    // Takes the type of list to print and prints the names of the animals required
    public static void printAnimals(String listType) {
    	// Prints all of the names in the dogList
    	if (listType.equals("dog")) {
           	for(Dog dog: dogList) {
           		System.out.println(dog.getName());
           	}
        }
    	// Prints all of the names in the monkeyList
    	else if (listType.equals("monkey")) {
           	for(Monkey monkey: monkeyList) {
           		System.out.println(monkey.getName());
           	}
        }
    	// Prints all animals that are in service and not reserved
    	else if (listType.equals("available")) {
            for (Dog dog: dogList) {
            	if ((!dog.getReserved()) && 
            			(dog.getTrainingStatus().equalsIgnoreCase("in service"))) {
            		System.out.println(dog.getName());
            	}
            }
            for (Monkey monkey: monkeyList) {
            	if ((!monkey.getReserved()) && 
            			(monkey.getTrainingStatus().equalsIgnoreCase("in service"))) {
            		System.out.println(monkey.getName());
            	}
            }
        }
    }
}

