package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

import Dijkstra.Dijkstra;
import Model.Edge;
import Model.Graph;
import Model.Vertex;
import Wlasny.Wlasny;


public class MainRun {
	
	

	public static void main (String[] args) throws IOException  
    {	
		
		/*
		//stworzenie grafu
		Graph graph1 = LoadData();
		
		//badanie za pomocą djikstry
		System.out.println("Wyznaczanie za pomocą djikstry");
		//graph1.toString();	
		//stworzenie objektu dijkstra
		Dijkstra dijkstra = new Dijkstra(graph1);
		//od A do C
		dijkstra.runDijkstra(graph1.vertexes[0],graph1.vertexes[2]);
		
		
		//badanie za pomocą własnego algorytmu
		System.out.println("Wyznaczanie za pomocą algorytmu bardzo zachłannego");
		Graph graph2 = LoadData();
		Wlasny wlasny = new Wlasny(graph2);
		wlasny.runWlasny(graph2.vertexes[0], graph2.vertexes[2]);
		
		//badanie losowego grafu przez Djikstre
		RandGraphGeneration ft = new RandGraphGeneration();
		Graph ngraph=ft.generateGraph(12,13);
		System.out.println(ngraph);
		//stworzenie objektu dijkstra
		Dijkstra dijkstra2 = new Dijkstra(ngraph);
		//od A do C
		dijkstra2.runDijkstra(ngraph.vertexes[0],ngraph.vertexes[2]);
		*/
		
		
		//test poprawności
		/*
		int goodD=0;
		int goodM=0;
		
		for(int i=0;i<50;i++){
			
		TestDijkstra td= new TestDijkstra();
		boolean test1;
		test1=td.testD(10,11);
		if(test1==false){
			goodD++;
		}
		//System.out.println(test1);
		
		TestWlasny tw = new TestWlasny();
		boolean test2;
		test2=tw.testW(10, 11);
		if(test2==false){
			goodM++;
		}
		//System.out.println(test2);
		
		}
		System.out.println("test efektywności działania - dla 50 prób, 10 krzywych, 11 węzłów");
		System.out.println("pozytywnych dojść (Djikstra):"  + goodD);
		System.out.println("pozytywnych dojść (Własny):"  + goodM);
		*/
		
		
		//test zlozonosci czasowej
		/*
		System.out.println("wlasny");
		TestWlasny tw = new TestWlasny();
		boolean test3;
		do{
		test3=tw.testW(20, 21);}while(test3==true);
		//
		System.out.println("Dijkstra");
		TestDijkstra td= new TestDijkstra();
		boolean test4;
		do{
		test4=td.testD(20,21);}while(test4==true);
		*/
		/*
		System.out.println("wlasny");
		TestWlasny tw = new TestWlasny();
		boolean test3;
		do{
		test3=tw.testW(20, 32);}while(test3==true);
		*/
		System.out.println("Dijkstra");
		TestDijkstra td= new TestDijkstra();
		boolean test4;
		do{
		test4=td.testD(30,50);}while(test4==true);
    }
	
	
	public static Graph LoadData() throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Graph Test\n");
        /*
         * Najpierw ładuję Punkty 
         */
		BufferedReader f = new BufferedReader(new FileReader("Vertexes")); 	// "data.txt"  => size 1 2 3 4 ..
		StringTokenizer st = new StringTokenizer(f.readLine());
		Vertex[] vertexes = new Vertex[Integer.parseInt(st.nextToken())];
		for (int i = 0; i < vertexes.length; i++) 
		{
			vertexes[i] = new Vertex(st.nextToken());
			}	
		/*
		 * teraz ładuje wektory
		 */		
		BufferedReader f2 = new BufferedReader(new FileReader("Edges")); 	// "data.txt"  => size 1 2 3 4 ..
		StringTokenizer st2 = new StringTokenizer(f2.readLine());
		Edge[] edges = new Edge[Integer.parseInt(st2.nextToken())];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new Edge(
					// -1 poniewaz w pliku numerowalem od 1 
					vertexes[Integer.parseInt(st2.nextToken())-1],
					vertexes[Integer.parseInt(st2.nextToken())-1],
					Integer.parseInt(st2.nextToken()),
					Integer.parseInt(st2.nextToken()),
					Integer.parseInt(st2.nextToken()));
			}
		//return
		return new Graph(vertexes,edges);
	}
}
