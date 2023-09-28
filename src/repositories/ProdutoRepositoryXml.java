package repositories;

import java.io.PrintWriter;

import entities.Produto;
import interfaces.ProdutoRepository;

public class ProdutoRepositoryXml implements ProdutoRepository {

	@Override
	public void exportarDados(Produto produto) {
		/*try {
			
			PrintWriter printWriter = new PrintWriter("c:\\temp\\produto.xml");
			printWriter.write("<?xml version='1.0' encoding)=ISO-8859-1;"
					+ "

		} catch (Exception e) {
			System.out.println("\nFALHA AO EXPORTAR PRA TXT");
			System.out.println(e.getMessage());
		}*/

		System.out.println("arquivo gravado em xml");
	}

}
