/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Amadeu Martim Silva De oliveira
 */
public class questao1 {

    static int numeroVertices = 30000;

    public static void main(String[] args) {

        Scanner in;
        String line;
        int indice = 0;
        String[] numb = new String[30000];

        LinkedList[] lista = new LinkedList[numeroVertices];
        ligarLista(lista); // obrigatório para pode ligar a lsita, caso contrario o elemento é null

        try {
            in = new Scanner(new FileReader("C:\\Users\\Dinopc\\Desktop\\coisas aleatorias\\grafo.txt"));

            while (in.hasNextLine()) {
                line = in.nextLine();
                String array[] = line.split("\t");
                numb[indice] = array[0];
                for (int y = 0; y < array.length - 1; y++) {
                    lista[indice].add(array[y + 1]);
                }
                indice++;
                //System.out.println(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();;

        }
        int q = 0;
        for (int k = 0; k < numeroVertices; k++) {
            q += lista[k].size();

        }
        print(lista, numb);
        for (int g = 0; g < numeroVertices; g++) {
            System.out.println(numb[g] + " tem " + lista[g].size() + " vértices adjacentes");
            System.out.println();

        }
        complexidade(lista);
        System.out.println("A quantidade total de arestas é de" + " " + q);

    }

    static void ligarLista(LinkedList[] lista) {
        for (int i = 0; i < numeroVertices; i++) {
            lista[i] = new LinkedList();
        }
    }
    
    static void complexidade(LinkedList[] listas) {
        int complexidade = 0;
        for (int i = 0; i < numeroVertices; i++) {
            complexidade += listas[i].size() + (listas[i].size() + 1);
        }
        System.out.println("O grafo possui complexidade: " + complexidade);
    }


    static void print(LinkedList[] lista, String numb[]) {
        for (int i = 0; i < numeroVertices; i++) {
            System.out.print(numb[i] + ": ");
            for (int j = 0; j < lista[i].size(); j++) {
                System.out.print(lista[i].get(j) + " ");
            }
            System.out.println();
        }

    }
}
