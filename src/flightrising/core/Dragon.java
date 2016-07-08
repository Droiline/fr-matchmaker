package flightrising.core;

public class Dragon {
    private final int id;
    private String name;
    private Breed breed;
    private Gender gender;
    private Colour primaryColour;
    private Colour secondaryColour;
    private Colour tertiaryColour;
    private Gene.Primary primaryGene;
    private Gene.Secondary secondaryGene;
    private Gene.Tertiary tertiaryGene;

    public Dragon(int id) {
        this.id = id;
        name = "Unnamed";
        breed = Breed.GUARDIAN;
        gender = Gender.FEMALE;
        primaryColour = Colour.MAIZE;
        secondaryColour = Colour.MAIZE;
        tertiaryColour = Colour.MAIZE;
        primaryGene = Gene.Primary.BASIC;
        secondaryGene = Gene.Secondary.BASIC;
        tertiaryGene = Gene.Tertiary.BASIC;
    }

    public Dragon(int id, String name, Breed breed, Gender gender, Colour primCol, Colour secCol, Colour tertCol, Gene.Primary primGene, Gene.Secondary secGene, Gene.Tertiary tertGene) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        primaryColour = primCol;
        secondaryColour = secCol;
        tertiaryColour = tertCol;
        primaryGene = primGene;
        secondaryGene = secGene;
        tertiaryGene = tertGene;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }
}
