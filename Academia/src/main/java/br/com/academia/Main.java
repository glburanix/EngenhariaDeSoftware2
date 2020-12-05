package br.com.academia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.academia.dao.AlunosDAO;
import br.com.academia.dao.PlanosDAO;
import br.com.academia.modelo.Alunos;
import br.com.academia.modelo.Planos;


public class Main {
	
	
    public static void main(String[] args) {  
    	
    	Scanner teclado = new Scanner(System.in);
    	    	
    	
    	// obj de acesso a Dados (Hibernate)
    	
    	AlunosDAO dao = new AlunosDAO();
    	PlanosDAO dao2 = new PlanosDAO();
    	Boolean continuee;
    	
		do {

			System.out.println("Tecle '1' para Entrar em Alunos e '2' para entrar em Planos");
			int x = teclado.nextInt();

			switch (x) {

			case 1:

				System.out.println("Digite '1' para ver a lista de Alunos ou '2' para Cadastrar um Aluno.");
				int y = teclado.nextInt();

				switch (y) {

				case 1:
					List<Alunos> lista = dao.getTodas();
					System.out.println(relatorioDisciplinas(lista));

					break;

				case 2:
					Alunos disc = new Alunos();

					String newStudant = JOptionPane.showInputDialog("Digite o Nome do Aluno que deseja Cadastra:.");
					String cpf = JOptionPane.showInputDialog("Digite o CPF do Aluno:" );
					String age = JOptionPane.showInputDialog("Digite a idade do Aluno:");
					String weight = JOptionPane.showInputDialog("Digite o peso do Aluno:");
					String height = JOptionPane.showInputDialog("Digite a altura do Aluno:");
					String sex = JOptionPane.showInputDialog("Digite o sexo do Aluno:");
					
					double altura = Double.parseDouble(height);
					double peso = Double.parseDouble(weight);
					int idade = Integer.parseInt(age);
					Date data = new Date();

					disc.setNome(newStudant);
					disc.setAltura(altura);
					disc.setCpf(cpf);
					disc.setDataInicio(data);
					disc.setIdade(idade);
					disc.setPeso(peso);
					disc.setSex(sex);
					dao.inserir(disc);
					break;
				}
				break;

			case 2:

				System.out.println("Digite '1' para ver a lista de Planos ou '2' para Cadastrar um Plano.");
				int z = teclado.nextInt();

				switch (z) {

				case 1:
					List<Planos> listaPlanos = dao2.getTodas();
					System.out.println(relatorioPlanos(listaPlanos));

					break;

				case 2:
					Planos disc = new Planos();

					String newPlano = JOptionPane.showInputDialog("Digite o Nome do Plano que deseja Cadastrar:");
					String value = JOptionPane.showInputDialog("Digite o Valor do Plano: ");
					String time = JOptionPane.showInputDialog("Digite a Dura��o do Plano: ");

					double valor = Double.parseDouble(value);
					int tempo = Integer.parseInt(time);

					disc.setNome_plano(newPlano);
					disc.setValor_plano(valor);
					disc.setDuracao_plano(tempo);
					dao2.inserir(disc);

					break;
				}
				break;

			default:
				System.out.println("Opera��o Invalida!!");
			}
			
			int dialogContinue = JOptionPane.YES_NO_OPTION;
			int dialogContinueResult = JOptionPane.showConfirmDialog(null, "Continuar?", "Deseja Continuar?", dialogContinue);
			
			if(dialogContinueResult == 0) {
				continuee = true;
			} else {
				continuee = false;
			} 

		} while (continuee == true);
		
		System.out.println("End");
		
	}
    
    
    
    public static String relatorioDisciplinas(List<Alunos> list) {
    	    	   
    	   String rel = "-----------Relat�rio de Alunos-----------\n";
    	   
    	   for(Alunos disc : list){             	
               rel += "\n" + disc.getId() + " | " + disc.getNome() + "\n";
           }
    	   
    	   return rel;
           
    	
    }
    
    public static String relatorioPlanos(List<Planos> list) {
  	   
  	   String rel = "-----------Relat�rio de Planos-----------\n";
  	   
  	   for(Planos disc : list){             	
             rel += "\n" + disc.getId() + " | " + disc.getNome_plano() + "\n";
         }
  	   return rel;
  }

}
