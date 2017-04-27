package test;

import Model.Edge;
import Model.Graph;
import Model.Vertex;

public class RandGraphGeneration {
	// Na przykład, gdy chcemy uzyskać liczbę z zakresu od 1 do 10,
	// int liczbaLosowa = (int) (Math.random() * 10 + 1);
	int numbNodes;

	Vertex[] vertexes;
	Edge[] edges;

	public Graph generateGraph(int numbNodes, int numbEdges) {

		vertexes = new Vertex[numbNodes];
		edges = new Edge[numbEdges];

		// tworzenie vertexów
		for (int i = 0; i < numbNodes; i++) {
			vertexes[i] = new Vertex("name" + i);
		}

		// wyszukiwanie czy takie są
		// na kazdy element tablicy dopasowuje krzywa
		for (int i = 0; i < numbEdges; i++) {
			boolean found = false;
			int randWeight = (int) (Math.random() * 10 + 0);

			//dopóki nie znaleziono poprawnej pary
			while (found != true) {
				int randSourc = (int) (Math.random() * 10 + 0);
				int randDest = (int) (Math.random() * 10 + 0);
				//wyklucz dwa te same punkty
				if (randSourc == randDest) {
					// do nothing
				} else {
					// find if the pair has been already existed
					boolean isAlready=false;
					
					for (int j = 0; j < edges.length; j++) {
						// jezeli juz taka para jest

						if (edges[j] != null && edges[j].source.id == randSourc
								&& edges[j].destination.id == randDest) {
							isAlready=true;
						}
					}
					//jezeli nie bedzie duplikatem to dodaj
					// dodac do tablicy edges
					if(isAlready==false){
					edges[i] = new Edge(vertexes[randSourc],
							vertexes[randDest], 0, 1, randWeight);
					// zmienic na true
					found = true;
					//System.out.println("dodano nowy element");
					}
				}
			}
		}

		// Tworzenie obiektu Graf
		Graph graph = new Graph(vertexes, edges);

		return graph;

	}

}
