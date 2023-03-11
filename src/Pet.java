public class Pet {
    enum Kind {
        CAT,
        DOG,
        HAMSTER,
    }

    Kind kind;
    String name;
    String dateOfBirth="";
    double weight=0.0;

    public Pet(Kind kind, String name) {
        this.kind = kind;
        this.name = name;
    }

    public Pet(Kind kind, String name, double weight) {
        this.kind = kind;
        this.name = name;
        this.weight = weight;
    }

    public Pet(Kind kind, String name, String dateOfBirth, double weight) {
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
}
