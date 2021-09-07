package Model;


public class Main {
    

    public static void main (String[] args) {
        String nome = "thiago";
        System.out.println(nome);

        Servico servico = new Servico(1, "barba", 30);

        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());


        Cliente cliente = new Cliente(1, "Arthur", "Rua quarenta e oito", "53409600");
        System.out.println(cliente.getNome());

        Usuario usuario = new Usuario(1, "barbeiro", "Senha");
        System.out.println(usuario.getNome());


        Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "03/08/2021 09:15");
        System.out.println(agendamento.getCliente().getNome());
    }
}
