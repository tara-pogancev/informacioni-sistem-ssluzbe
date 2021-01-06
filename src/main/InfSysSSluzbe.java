// #deserijalizacija

package main;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import gui.MainFrame;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class InfSysSSluzbe {

	public static void main(String[] args) {

		ObjectInputStream ois1, ois2, ois3;
		try {
			ois1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream("studenti.txt")));
			ois2 = new ObjectInputStream(new BufferedInputStream(new FileInputStream("profesori.txt")));
			ois3 = new ObjectInputStream(new BufferedInputStream(new FileInputStream("predmeti.txt")));
			try {
				BazaStudenata.getInstance().readDataStudent(ois1);
				BazaProfesora.getInstance().readDataProfesor(ois2);
				BazaPredmeta.getInstance().readDataPredmet(ois3);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		MainFrame.getInstance();

	}
}
