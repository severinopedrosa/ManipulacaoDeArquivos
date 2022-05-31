package View;

import java.io.IOException;

import javax.swing.JOptionPane;

import Controller.FileController;
import Controller.IArquivosController;

public class Main {

	public static void main(String[] args) {
		
		IArquivosController arqCont = new FileController();
		String dir = "";
		String name = "";
		String typeFile = ""; 
		int menu = Integer.parseInt( JOptionPane.showInputDialog(null, "Digite o número correspondente com uma ação: \n"+"Menu\n" + "1. Leitura de diretorio\n" + "2. Criar arquivo .txt\n" + "3. Criar arquivo .csv\n" + "4. Ler arquivo .txt\n" + "5. Ler arquivo .csv\n" + "6. Abrir arquivo .csv\n" + "7. Abrir arquivo .txt"));
		dir = JOptionPane.showInputDialog(null, "Digite o caminho do arquivo");
		switch (menu) {

		case 1:
			try {
				 arqCont.readDir(dir); //Leitura de pastas e arquivos.
			} catch (IOException e) {
				e.printStackTrace();
			}
		break;

		case 2:
			name = JOptionPane.showInputDialog(null, "Digite o nome do arquivo");
			typeFile = ".txt"; 
			try {
				arqCont.createFile(dir, name, typeFile); //Criar um arquivo e ecrever nele.			
			} catch (IOException e) {
				e.printStackTrace();
			}
		break;

		case 3:
			name = JOptionPane.showInputDialog(null, "Digite o nome do arquivo");
			typeFile = ".csv"; 
			try {
				arqCont.createFile(dir, name, typeFile); //Criar um arquivo e ecrever nele.			
			} catch (IOException e) {
				e.printStackTrace();
			}
		break;

		case 4:
			name = JOptionPane.showInputDialog(null, "Digite o nome do arquivo");
			typeFile = ".txt"; 
			try {
				arqCont.readFile(dir, name, typeFile); //Ler um arquivo.			
			} catch (IOException e) {
				e.printStackTrace();
			}
		break;
		case 5:
			name = JOptionPane.showInputDialog(null, "Digite o nome do arquivo");
			typeFile = ".csv"; 
			try {
				arqCont.readFile(dir, name, typeFile); //Ler um arquivo.				
			} catch (IOException e) {
				e.printStackTrace();
			}
		break;
		case 6:
			typeFile = ".csv";
			name = JOptionPane.showInputDialog(null, "Digite o nome do arquivo");
			try {
				arqCont.openFile(dir, name, typeFile); //Abrir um arquivo.			
			} catch (IOException e) {
				e.printStackTrace();
			}
		break;
		case 7:
			typeFile = ".txt";
			name = JOptionPane.showInputDialog(null, "Digite o nome do arquivo");
			try {
				arqCont.openFile(dir, name, typeFile); //Abrir um arquivo.			
			} catch (IOException e) {
				e.printStackTrace();
			}
		break;
		default:
			System.out.print("O número digitado está incorreto");
		}
	}

}
