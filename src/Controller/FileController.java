package Controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class FileController implements IArquivosController{

	public FileController() {
		super();
		
	}

	@Override
	public void readDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] listFiles = dir.listFiles();
			for (File f : listFiles ) {
				if(f.isFile()) {
					System.out.println("     \t"+f.getName());
				}else {
					System.out.println("<DIR>\t"+f.getName());
				}
				
			}
			
			
		}else {
			throw new IOException("Diretório inválido");
		}
		
	}

	public void createFile(String path, String name, String typeFile) throws IOException {
		File dir = new File(path);
		File arq = new File(path, name + typeFile);
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()){
				existe = true;
			}
			
			if(typeFile == ".csv") {
				String content = gerarCsv();
				FileWriter fileWriter = new FileWriter(arq, existe);
				PrintWriter print = new PrintWriter(fileWriter);
				print.write(content);
				print.flush();
				print.close();
				fileWriter.close();
			}else if(typeFile == ".txt") {
				String content = gerarTxt();
				FileWriter fileWriter = new FileWriter(arq, existe);
				PrintWriter print = new PrintWriter(fileWriter);
				print.write(content);
				print.flush();
				print.close();
				fileWriter.close();
			}
		}else {
			throw new IOException("Diretório inválido");
		}
	}

	private String gerarCsv() {
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while (!line.equalsIgnoreCase("fim;")) {
			line = JOptionPane.showInputDialog(null,"Digite uma frase", "Entrada de Texto", JOptionPane.INFORMATION_MESSAGE);
				line += ";";
				if(!line.equalsIgnoreCase("fim;")) {
					buffer.append(line + "\n");
				}
			}
		return buffer.toString();
	}

	private String gerarTxt() {
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while (!line.equalsIgnoreCase("fim")) {
			line = JOptionPane.showInputDialog(null,"Digite uma frase", "Entrada de Texto", JOptionPane.INFORMATION_MESSAGE);
				if(!line.equalsIgnoreCase("fim")) {
					buffer.append(line + "\n");
				}
			}
		return buffer.toString();
	}

	public void readFile(String path, String name, String typeFile) throws IOException {
		File arq = new File(path, name + typeFile);
		if (arq.exists() && arq.isFile()) {
			if(typeFile == ".csv") {
				FileInputStream flow = new FileInputStream(arq);
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();

				while(line != null) { // Procurando EOF	
					String word [] = line.split(",");
				for (int i = 0; i <= word.length - 1; i++) {
					if (word[2].contains("Fruits") || word[2].contains("GROUP") ) {
						if(i == 3) {
							System.out.println(word[i] + "\t");
						}else {
							System.out.print(word[i] + "\t");
						}
					}
				}
				line = buffer.readLine();	
				}
				buffer.close();
				reader.close();
				flow.close();
			}else {
				FileInputStream flow = new FileInputStream(arq);
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				while(line != null) { // Procurando EOF
					System.out.println(line);
					line = buffer.readLine();
				}
				buffer.close();
				reader.close();
				flow.close();
			}
		}else {
			throw new IOException("Arquivo inválido");
			
		}
		
	}

	@Override
	public void openFile(String path, String name, String typeFile) throws IOException {
		File arq = new File(path, name + typeFile);
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		}else {
			throw new IOException("Arquivo invalido");
		}
		
	}
	

}