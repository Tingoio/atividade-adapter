import java.util.Map;
import java.util.HashMap;

class Credenciais {
    private Map<String, String> chaves = new HashMap<>();
    
    public void adicionarChave(String nome, String valor) {
        chaves.put(nome, valor);
    }
    
    public String getChave(String nome) {
        return chaves.get(nome);
    }
}