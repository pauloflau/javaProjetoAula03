package repositories;

import java.io.PrintWriter;

import entities.Produto;
import interfaces.ProdutoRepository;

public class ProdutoRepositoryTxt implements ProdutoRepository {

	@Override
	public void exportarDados(Produto produto) {
		try {
			PrintWriter printWriter = new PrintWriter("C:\\temp\\produto.txt");
			
			printWriter.write("\nID DO PRODUTO**********:"+produto.getId());
			printWriter.write("\nNOME DO PRODUTO********:"+produto.getNome());
			printWriter.write("\nPRECO DO PRODUTO*******:"+produto.getPreco());
			printWriter.write("\nQUANTIDADE DO PRODUTO**:"+produto.getQuantidade());
			printWriter.write("\nFORNECEDOR DO PRODUTO**:"+produto.getFornecedor().getNome());
			printWriter.write("\nCNPJ DO PRODUTO********:"+produto.getFornecedor().getCnpj());
		
			printWriter.flush();
			printWriter.close();
			
			System.out.println("\nARQUIVO GRAVADO COM SUCESSO!");
			
		} catch (Exception e) {
			System.out.println("\nFALHA AO EXPORTAR PRA TXT");
			System.out.println(e.getMessage());
		}
		
	}



}
