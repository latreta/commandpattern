# Command Pattern 

## Intenção

Encapsular uma solicitação em forma de objeto, permitindo parametrizar clientes com diferentes solicitações, enfileirar solicitações, registrar logs das mesmas e oferecer suporte para desfazer as solicitações/operações.

## Que tipos de problema resolve?

- Fluxos de regras de negócio.
- Sistemas de telas em sequência(Exemplos comuns são os modais, dialogs).

## Problema

- Quero realizar o cálculo do valor do seguro de um carro, porém quero caso deseje, reverter o cálculo completamente.

## Solução proposta

- Através do padrão de Commands, eu posso especificar como cada cálculo será feito e a sua ordem, assim cada Cálculo que eu desejar realizar, basta criar uma classe com o sufixo Command e implementar a interface Command, passando os objetos que são necessários para seu funcionamento pelo construtor.

### Minha interface Command
```
public interface Command {
    void execute();
    void undo(); // Opcional caso deseje suporte para desfazer as operações
}
```

### Exemplo 1 - Calculando o valor base do seguro

```
public class CalculaValorBaseSeguroCommand implements Command{
    ISeguro seguro;
    ICarro carro;
    double valorBase;

    public CalculaValorBaseSeguroCommand(ICarro carro, ISeguro seguro){
        this.seguro = seguro;
        this.carro = carro;
        this.valorBase = 0.0;
    }

    @Override
    public void execute() {
        valorBase = this.carro.getValor() * 0.0125; // 1,25% do Valor do carro.
        System.out.println("Adicionando um valor base de R$" + valorBase);
        seguro.adicionarValor(valorBase);
    }

    @Override
    public void undo() {
        System.err.println("Removendo o valor base de R$" + valorBase);
        seguro.removerValor(valorBase);
    }
}
```

### Exemplo 2 - Calculando um desconto por tempo de habilitação

```
public class CalculaDescontoPorTempoHabilitacaoCommand implements Command{
    IPessoa pessoa;
    ISeguro seguro;
    double valorAdicional;

    public CalculaDescontoPorTempoHabilitacaoCommand(IPessoa pessoa, ISeguro seguro){
        this.pessoa = pessoa;
        this.seguro = seguro;
        this.valorAdicional = 0.0;
    }

    @Override
    public void execute() {
        // 50 reais de desconto por anos de habilitações
        this.valorAdicional = 50 * pessoa.getTempoDeHabilitacao();
        System.out.println("Desconto oferecido de R$ " + this.valorAdicional);
        seguro.removerValor(valorAdicional);
    }

    @Override
    public void undo() {
        // Retira o desconto
        System.err.println("Removendo desconto oferecido de R$ " + this.valorAdicional);
        seguro.adicionarValor(valorAdicional);
    }
}
```


### MacroCommands
Pode ser tanto um command como uma classe Invoker

```
// Invoker class
public class CalculaSegurosCommand implements Command {
    private List<Command> commands; // Enfileirar solicitações/commands
    private List<Command> executedCommands; // solicitações/commands executados

    public CalculaSegurosCommand(){
        this.commands = new ArrayList<>();
        this.executedCommands = new ArrayList<>();
    }

    public void adicionarCalculo(Command cmd){
        this.commands.add(cmd);
    }

    @Override
    public void execute() {
        for(Command cmd : commands) {
            cmd.execute();
            executedCommands.add(cmd);
        }
    }

    @Override
    public void undo() {
        for(Command cmd : executedCommands){
            cmd.undo();
        }
        executedCommands.clear();
    }
}
```
