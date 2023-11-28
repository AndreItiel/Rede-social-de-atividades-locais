import java.util.Scanner;

public class Localizacao implements Gerenciavel {
    private double latitude;
    private double longitude;
    private String endereco;

    public Localizacao(double latitude, double longitude, String endereco) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
    }

    @Override
    public void criar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a latitude da localização:");
        this.latitude = scanner.nextDouble();
        System.out.println("Digite a longitude da localização:");
        this.longitude = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha pendente
        System.out.println("Digite o endereço da localização:");
        this.endereco = scanner.nextLine();

        System.out.println("Localização adicionada!");
    }

    @Override
    public void editar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a nova latitude da localização:");
        this.latitude = scanner.nextDouble();
        System.out.println("Digite a nova longitude da localização:");
        this.longitude = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha pendente
        System.out.println("Digite o novo endereço da localização:");
        this.endereco = scanner.nextLine();

        System.out.println("Localização editada!");
    }

    @Override
    public void excluir() {
        System.out.println("Localização excluída!");
    }

    @Override
    public void visualizar() {
        System.out.println("Visualizando localização");
    }
}
