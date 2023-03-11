import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        //Task1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pet> petsArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            petsArray.add(Pet.createPetFromLine(line, ","));
        }
        Pet.toPrintPet(petsArray);

        //Task2
        File file = new File("resourse/students");
        ArrayList<Student> students = new ArrayList<>();
        students = Student.createStudentFromFile(file);
        Student.toPrintStudent(students);

    }
}