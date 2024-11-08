import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ZipCodeQuery zipCodeQuery = new ZipCodeQuery();

        System.out.println("Digite um número de CEP para consulta: ");
        var zipCode = reader.nextLine();


        try{
            Address newAddress = zipCodeQuery.searchAddress(zipCode);
            System.out.println(newAddress);
            FileGenerator generator = new FileGenerator();
            generator.saveJsonFile(newAddress);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }



    }
}