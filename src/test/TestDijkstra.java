package test;

import Dijkstra.Dijkstra;
import Model.Graph;

public class TestDijkstra {
	
	public boolean testD(int numbNodes,int numbEdges){
		int numbEdgesv=numbEdges;
		int numbNodesv=numbNodes;
		RandGraphGeneration ft2 = new RandGraphGeneration();
		Graph ngraph2 = ft2.generateGraph(numbNodesv, numbEdgesv);
		Dijkstra dijkstra2 = new Dijkstra(ngraph2);
		long tStart2 = System.nanoTime();
		boolean collision = dijkstra2.runDijkstra(ngraph2.vertexes[0],ngraph2.vertexes[2]);
		long tEnd2 = System.nanoTime();
		long tDelta2 = tEnd2 - tStart2;
		double elapsedSeconds2 = tDelta2/1000;
		System.out.println(elapsedSeconds2);
		return collision;
	}
	
	
}
