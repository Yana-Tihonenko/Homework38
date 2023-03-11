import java.io.*;
import java.util.ArrayList;

public class Student {
    private static int counter = 0;
    final private static char SEP = ',';
    final private int id;
    private String name;
    private String group;
    private String eMail;

    public Student(String name, String group) {
        this.id = ++counter;
        this.name = name;
        this.group = group;
        this.eMail = null;
    }

    public Student(String name, String group, String eMail) {
        ++counter;
        this.id = counter;
        this.name = name;
        this.group = group;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String getEMail() {
        return eMail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public static Student parseStudent(String group, String line) {
        int sepIndex = line.indexOf(SEP);
        if (sepIndex != -1) {
            String name = line.substring(0, sepIndex);
            String eMail = line.substring(sepIndex + 1);
            return new Student(name, group, eMail);
        }
        return new Student(/*name*/line, group);
    }

    public static ArrayList<Student> createStudentFromFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<Student> students = new ArrayList<>();
        String line;
        do {
            line = br.readLine();
            students.add(createStudentFromArray(parsLineToArray(line,SEP)));
        } while (line.length() > 0);

        return students;
    }

    private static ArrayList<String> parsLineToArray(String line, char SEP) {
        ArrayList<String> temp = new ArrayList<>();
        int sepCurrent = line.indexOf(SEP);
        if (sepCurrent != -1) {
            temp.add(line.substring(0, sepCurrent));
            while (sepCurrent != -1) {
                int sepNext = line.indexOf(SEP, sepCurrent + 1);
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

    public static Student createStudentFromArray(ArrayList<String> student) {
        Student newStudent = null;
        switch (student.size()) {
            case (2):
                newStudent = new Student(student.get(0), student.get(1));
                break;
            case (3):
                newStudent = new Student(student.get(0), student.get(1), student.get(2));
                break;
        }
        return newStudent;
    }

}



