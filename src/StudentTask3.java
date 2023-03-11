public class StudentTask3 {
    private static int counter = 0;
    final private static char SEP = ',';
    final private int id;
    private String name;
    private Group group;
    private String eMail;

    public StudentTask3(String name, Group group) {
        this.id = ++counter;
        this.name = name;
        this.group = group;
        this.eMail = null;
    }

    public StudentTask3(String name, Group group, String eMail) {
        ++counter;
        this.id = counter;
        this.name = name;
        this.group = group;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }


    public String getEMail() {
        return eMail;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public static StudentTask3 parseStudent(Group group, String line) {
        int sepIndex = line.indexOf(SEP);
        if (sepIndex != -1) {
            String name = line.substring(0, sepIndex);
            String eMail = line.substring(sepIndex + 1);
            return new StudentTask3(name, group, eMail);
        }
        return new StudentTask3(/*name*/line, group);
    }
}
