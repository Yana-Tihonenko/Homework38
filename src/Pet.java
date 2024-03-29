import java.util.ArrayList;


public class Pet {
    enum Kind {
        CAT,
        DOG,
        HAMSTER,
    }

    Kind kind;
    String name;
    String dateOfBirth = "";
    double weight = 0.0;

    public Pet(Kind kind, String name) {
        this.kind = kind;
        this.name = name;
    }

    public Pet(Kind kind, String name, double weight) {
        this.kind = kind;
        this.name = name;
        this.weight = weight;
    }

    public Pet(Kind kind, String name, double weight, String dateOfBirth) {
        this.kind = kind;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static Pet createPetFromLine(String line, String sep) {
        ArrayList<String> petToArray = parsLineToArray(line, sep);
        Pet newPet = createPetFromArray(petToArray);
        return newPet;
    }

    private static ArrayList<String> parsLineToArray(String line, String sep) {
        ArrayList<String> temp = new ArrayList<>();
        int sepCurrent = line.indexOf(sep);
        if (sepCurrent != -1) {
            temp.add(line.substring(0, sepCurrent));
            while (sepCurrent != -1) {
                int sepNext = line.indexOf(sep, sepCurrent + 1);
                if (sepNext == -1) {
                    temp.add(line.substring(sepCurrent + 1));
                } else {
                    temp.add(line.substring(sepCurrent + 1, sepNext));
                }
                sepCurrent = sepNext;
            }
        }
        return temp;
    }

    public static Pet createPetFromArray(ArrayList<String> pet) {
        Pet newPet = null;
        switch (pet.size()) {
            case (2):
                newPet = new Pet(Kind.valueOf(pet.get(0)), pet.get(1));
                break;
            case (3):
                newPet = new Pet(Kind.valueOf(pet.get(0)), pet.get(1), Double.parseDouble(pet.get(2)));
                break;
            case (4):
                newPet = new Pet(Kind.valueOf(pet.get(0)), pet.get(1), Double.parseDouble(pet.get(2)), pet.get(3));
                break;
        }
        return newPet;
    }

    public static  void  toPrintPet(ArrayList<Pet> petsArray) {
        for (Pet record : petsArray) {
            System.out.println("Pet:" +
                    "kind=" + record.kind +
                    ", name=" + record.name +
                    ", weight=" +record.weight +
                    ",dateOfBirth=" + record.dateOfBirth);

        }
    }
}

