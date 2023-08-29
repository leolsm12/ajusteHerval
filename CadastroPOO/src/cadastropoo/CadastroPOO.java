package cadastropoo;


import gerenciadores.PessoaFisicaRepo;
import gerenciadores.PessoaJuridicaRepo;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaJuridica;

/**
 *
 * @author HervalDantas
 */
public class CadastroPOO {

    public static void main(String[] args) {
        
        //inicia os dois tipos de pessoa 
        //o mais recomendado é iniciar as instacias no começo do código
        PessoaFisica pessoaF = new PessoaFisica();
        PessoaJuridica pessoaJ = new PessoaJuridica();
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaJuridicaRepo repo2 = new PessoaJuridicaRepo();
        //Scannear
        Scanner optionIn = new Scanner(System.in);
        //inicia as duas variaveis dos laços while
        boolean inicio = true;
        boolean caso = true;
       
                
        while(inicio == true){
             
            //Display Menu
            System.out.println("           M  E  N  U");
            System.out.println("================================");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir conforme ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar");
            System.out.println("7 - Recuperar");
            System.out.println("0 - Finalizar programa");
            System.out.println("================================");
            
            String opcao = optionIn.nextLine();

            switch (opcao) {
                case "0" : 
                    inicio = false;
                    break;
                case "1":
                    while(caso == true){

                        System.out.println("F - Pessoa Física  |  J - Pessoa Jurídica");
                        String entity = optionIn.nextLine().toUpperCase();
                        
                        if(entity.equals("F")){
                            System.out.println("Digite o Número do ID: ");
                            int inputId = optionIn.nextInt();
                            //Consumir a linha pendente
                            optionIn.nextLine();
                            
                            System.out.println("Digite o Nome: ");
                            String inputNome = optionIn.nextLine();
                            System.out.println("Digite o CPF: ");
                            String inputCPF = optionIn.nextLine();
                            System.out.println("Digite sua Idade: ");
                            int inputIdade = optionIn.nextInt();
                            optionIn.nextLine();
                            
                            //atribui os valores no objeto pessoaFisica
                            pessoaF.setNome(inputNome);
                            pessoaF.setId(inputId);
                            pessoaF.setCpf(inputCPF);
                            pessoaF.setIdade(inputIdade);

                            //usa o pessoaFisicaRepo para persistir os dados
                            repo1.inserir(pessoaF);
                            
                            System.out.println("ID: " + pessoaF.getId() + "\nNome: " + pessoaF.getNome() + "\nCPF: " + pessoaF.getCpf() + " ==> Idade: " + pessoaF.getIdade() + "\n==============\n ");
                            
                            caso = false;
                        } else if (entity.equals("J")) {
                            System.out.println("Digite o Número do ID: ");
                            int inputId = optionIn.nextInt();
                            optionIn.nextLine();
                            System.out.println("Digite o Nome da Empresa: ");
                            String inputNome = optionIn.nextLine();
                            System.out.println("Digite o CNPJ: ");
                            String inputCNPJ = optionIn.nextLine();
                            
                            pessoaJ.setNome(inputNome);
                            pessoaJ.setId(inputId);
                            pessoaJ.setCnpj(inputCNPJ);
                            
                            repo2.inserir(pessoaJ);
                            
                            caso = false;
                        }else{
                            System.out.println("opção inavalida");
                        }
                    }

                    break;
                
                case "2":
                    System.out.println("Alterar");    
                    break;
                case "3":
                    System.out.println("Excluir");
                    break;
                case "4":
                    System.out.println("Exibir conforme ID");
                    break;
                case "5":
                    System.out.println("Exibir todos");
                    break;
                case "6":
                    System.out.println("Salvar");
                    break;
                case "7":
                    System.out.println("Recuperar");
                    break;
                }
            
        }  

    }

    

    // ============== Repositório Pessoa Física ================
    /* PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica pessoaF = new PessoaFisica(1001, "Herval Rosano Dantas", "8240330000", 59);
        PessoaFisica pessoaF1 = new PessoaFisica(1002, "Antonio Dantas", "00009700", 15);
        PessoaFisica pessoaF2 = new PessoaFisica(1003, "Angela Agostinho da Costa Dantas", "82411122253", 53);

        repo1.inserir(pessoaF);
        repo1.inserir(pessoaF1);
        repo1.inserir(pessoaF2);

        for (PessoaFisica pessoaFisica : repo1.obterTodos()) {
            System.out.println("ID: " + pessoaFisica.getId() + "\nNome: " + pessoaFisica.getNome() + "\nCPF: " + pessoaFisica.getCpf() + " ==> Idade: " + pessoaFisica.getIdade() + "\n==============\n ");
        }

        repo1.persistir("pessoaFisica.txt");
        //repo1.recuperar("pessoaFisica.txt");

        ArrayList persona = repo1.recuperar("pessoaFisica.txt");

        //System.out.println("Recuperando arquivo: " + persona); 
        for (var pessoaRecuperadas : persona) {

            System.out.println("Recuperado: " + pessoaRecuperadas);

            //pessoaRecuperadas(0).exibir();
            //System.out.println("Empresa ID: " + pesona.getId() + "\nEmpresa: " + persona.getNome()+ "\nCNPJ: " + pessoaJuridica.getCnpj()+"\n==============\n " );            
        }

        // =========== Pessoa Jurídica ==========================
        /* PessoaJuridicaRepo repo2 = new PessoaJuridicaRepo();        
        
        PessoaJuridica pessoaJ = new PessoaJuridica(3001, "Herval MEI", "82403309753/0001");
        PessoaJuridica pessoaJ2 = new PessoaJuridica(3002, "Antonio MEI", "82403309753/0002");
        PessoaJuridica pessoaJ3 = new PessoaJuridica(3002, "Antonio MEI", "82403309753/0002");
        
        repo2.inserir(pessoaJ);
        repo2.inserir(pessoaJ2);
        repo2.inserir(pessoaJ3);
        
        for (PessoaJuridica pessoaJuridica : repo2.obterTodos()) {            
            System.out.println("Empresa ID: " + pessoaJuridica.getId() + "\nEmpresa: " + pessoaJuridica.getNome()+ "\nCNPJ: " + pessoaJuridica.getCnpj()+"\n==============\n " );            
        }
     */
}
