import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pet> petsArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            petsArray.add(Pet.createPetFromLine(line,","));
        }
        for (Pet record:petsArray) {
           System.out.println(record.toStringPet());
        }

    }
}