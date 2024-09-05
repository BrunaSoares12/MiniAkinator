import java.util.HashMap;
import java.util.Map;

public class Animal {
    private String nome;
    private Map<String, Boolean> caracteristicas;

    public Animal(String nome) {
        this.nome = nome;
        this.caracteristicas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarCaracteristica(String caracteristica, boolean valor) {
        caracteristicas.put(caracteristica, valor);
    }

    public boolean temCaracteristica(String caracteristica) {
        return caracteristicas.getOrDefault(caracteristica, false);
    }
}
