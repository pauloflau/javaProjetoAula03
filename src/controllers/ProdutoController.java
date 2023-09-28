package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Fornecedor;
import entities.Produto;
import enums.TipoProduto;
import interfaces.ProdutoRepository;
import repositories.ProdutoRepositoryTxt;
import repositories.ProdutoRepositoryXml;

public class ProdutoController {
	public void cadastrarPRoduto() {
	
		Scanner scan = new Scanner(System.in);
		
		try {
			
			Produto produto = new Produto();
			
			produto.setId(UUID.randomUUID());
			produto.setFornecedor(new Fornecedor());
			
			System.out.println("\n *** CADASTRO DE PRODUTO ***\n");
			System.out.print("Nome**************************************: ");
			produto.setNome(scan.nextLine());
			
			System.out.print("Preco*************************************: ");
			produto.setPreco(Double.parseDouble(scan.nextLine()));
			
			System.out.print("Quantidade********************************: ");
			produto.setQuantidade(Integer.parseInt(scan.nextLine()));
			
			System.out.print("INFORME PERECIVEL(1) OU NAO PERECIVEL(2)**: ");
			Integer opcao = Integer.parseInt(scan.nextLine());
			
			switch (opcao) {
			case 1: produto.setTipo(TipoProduto.PERECIVEL);break;
			case 2: produto.setTipo(TipoProduto.NAO_PERECIVEL);break;
			default: //nenhum dos anteriores
				throw new Exception("Opcao invalida");
			}
			
			System.out.print("NOME DO FORNECEDOR************************: ");
			produto.getFornecedor().setNome(scan.nextLine());
			
			System.out.print("CNPJ DO FORNECEDOR************************: ");
			produto.getFornecedor().setCnpj(scan.nextLine());
			
			
			System.out.print("ESCOLHA (1)TXT OU (2)XML******************: ");
			Integer tipo = Integer.parseInt(scan.nextLine());
			
			//declaro um objeto da interface ProdutoRepository
			ProdutoRepository produtoRepository = null;
			
			switch(tipo) {
			case 1:
				produtoRepository = new ProdutoRepositoryTxt();
				break;
			case 2:
				produtoRepository = new ProdutoRepositoryXml();
				break;
			default:
				throw new Exception("Tipo de arquivo invalido!");
			}
			
			produtoRepository.exportarDados(produto);
		
			
		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR PRODUTO");
			System.out.println(e.getMessage());
		}
		
		finally {
			scan.close();	
		}
		
	}
	
	

}
