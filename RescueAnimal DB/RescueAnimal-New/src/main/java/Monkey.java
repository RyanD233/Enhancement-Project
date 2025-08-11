
public class Monkey extends RescueAnimal{
	private String tailLength;
	private String height;
	private String bodyLength;
	private String species;
	
    public Monkey(String name, String species, String gender, String age,
    String weight, String tailLength, String height, String bodyLength, 
    String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

    }
    
    // Accessor and mutator methods
    public void setSpecies(String species) {this.species = species;}
    public String getSpecies() {return species;}
    
    public void setTailLength(String tailLength) {this.tailLength = tailLength;}
    public String getTailLength() {return tailLength;}
    
    public void setHeight(String height) {this.height = height;}
    public String getHeight() {return height;}
    
    public void setBodyLength(String bodyLength) {this.bodyLength = bodyLength;}
    public String getBodyLength() {return bodyLength;}
}
