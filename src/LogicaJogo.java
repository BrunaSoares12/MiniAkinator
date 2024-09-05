import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogicaJogo {
    private List<Animal> animais;
    private List<String> perguntas;

    public LogicaJogo() {
        animais = new ArrayList<>();
        perguntas = new ArrayList<>();

        inicializarAnimais();

        inicializarPerguntas();
    }

    private void inicializarAnimais() {
        Animal cachorro = new Animal("Cachorro");
        cachorro.adicionarCaracteristica("tem pelo", true);
        cachorro.adicionarCaracteristica("tem 4 patas", true);
        cachorro.adicionarCaracteristica("vive na água", false);
        cachorro.adicionarCaracteristica("é um mamífero", true);
        cachorro.adicionarCaracteristica("é carnívoro", false);
        cachorro.adicionarCaracteristica("é grande", false);

        Animal gato = new Animal("Gato");
        gato.adicionarCaracteristica("tem pelo", true);
        gato.adicionarCaracteristica("tem 4 patas", true);
        gato.adicionarCaracteristica("vive na água", false);
        gato.adicionarCaracteristica("é um mamífero", true);
        gato.adicionarCaracteristica("é carnívoro", true);
        gato.adicionarCaracteristica("é grande", false);

        Animal peixe = new Animal("Peixe");
        peixe.adicionarCaracteristica("tem pelo", false);
        peixe.adicionarCaracteristica("tem 4 patas", false);
        peixe.adicionarCaracteristica("vive na água", true);
        peixe.adicionarCaracteristica("é um mamífero", false);
        peixe.adicionarCaracteristica("é carnívoro", false);
        peixe.adicionarCaracteristica("é grande", false);

        Animal elefante = new Animal("Elefante");
        elefante.adicionarCaracteristica("tem pelo", false);
        elefante.adicionarCaracteristica("tem 4 patas", true);
        elefante.adicionarCaracteristica("vive na água", false);
        elefante.adicionarCaracteristica("é um mamífero", true);
        elefante.adicionarCaracteristica("é carnívoro", false);
        elefante.adicionarCaracteristica("é grande", true);

        Animal girafa = new Animal("Girafa");
        girafa.adicionarCaracteristica("tem pelo", false);
        girafa.adicionarCaracteristica("tem 4 patas", true);
        girafa.adicionarCaracteristica("vive na água", false);
        girafa.adicionarCaracteristica("é um mamífero", true);
        girafa.adicionarCaracteristica("é carnívoro", false);
        girafa.adicionarCaracteristica("é grande", true);

        Animal hipopotamo = new Animal("Hipopótamo");
        hipopotamo.adicionarCaracteristica("tem pelo", false);
        hipopotamo.adicionarCaracteristica("tem 4 patas", true);
        hipopotamo.adicionarCaracteristica("vive na água", true);
        hipopotamo.adicionarCaracteristica("é um mamífero", true);
        hipopotamo.adicionarCaracteristica("é carnívoro", false);
        hipopotamo.adicionarCaracteristica("é grande", true);

        Animal leao = new Animal("Leão");
        leao.adicionarCaracteristica("tem pelo", true);
        leao.adicionarCaracteristica("tem 4 patas", true);
        leao.adicionarCaracteristica("vive na água", false);
        leao.adicionarCaracteristica("é um mamífero", true);
        leao.adicionarCaracteristica("é carnívoro", true);
        leao.adicionarCaracteristica("é grande", true);

        animais.add(cachorro);
        animais.add(gato);
        animais.add(peixe);
        animais.add(elefante);
        animais.add(girafa);
        animais.add(hipopotamo);
        animais.add(leao);
    }

    private void inicializarPerguntas() {
        perguntas.add("tem pelo");
        perguntas.add("tem 4 patas");
        perguntas.add("vive na água");
        perguntas.add("é um mamífero");
        perguntas.add("é carnívoro");
        perguntas.add("é grande");
    }

    public void iniciar() {
        System.out.println("Pense em um animal!");

        Scanner scanner = new Scanner(System.in);

        for (String pergunta : perguntas) {
            System.out.println("Seu animal " + pergunta + "? (1 - sim, 2 - não): ");
            String resposta = scanner.next();

            if (resposta.equals("1")) {
                filtrarAnimais(pergunta, true);
            } else if (resposta.equals("2")) {
                filtrarAnimais(pergunta, false);
            } else {
                System.out.println("Por favor, responda com 1 para 'sim' ou 2 para 'não'.");
            }

            if (animais.size() == 1) {
                System.out.println("Seu animal é: " + animais.get(0).getNome() + "!");
                return;
            }
        }

        if (animais.size() > 1) {
            System.out.println("Não consegui adivinhar. Os possíveis animais são: ");
            for (Animal animal : animais) {
                System.out.println(animal.getNome());
            }
        } else {
            System.out.println("Seu animal é: " + animais.get(0).getNome() + "!");
        }
    }

    private void filtrarAnimais(String caracteristica, boolean valor) {
        List<Animal> animaisRestantes = new ArrayList<>();
        for (Animal animal : animais) {
            if (animal.temCaracteristica(caracteristica) == valor) {
                animaisRestantes.add(animal);
            }
        }
        animais = animaisRestantes;
    }
}
