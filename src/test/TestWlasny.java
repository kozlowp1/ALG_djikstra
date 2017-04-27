package test;

import Model.Graph;
import Wlasny.Wlasny;

public class TestWlasny {
	
	public boolean testW(int numbEdges,int numbNodes){
		int vEdges=numbEdges;
		int vNodes=numbNodes;
	//badanie losowego grafu przez własny algorytm
	RandGraphGeneration ft2 = new RandGraphGeneration();
	Graph ngraph2 = ft2.generateGraph(vNodes, vEdges);
	// System.out.println(ngraph2);
	Wlasny wlasny2 = new Wlasny(ngraph2);
	long tStart = System.nanoTime();
	boolean collision = wlasny2.runWlasny(ngraph2.vertexes[0], ngraph2.vertexes[2]);
	long tEnd = System.nanoTime();
	long tDelta = tEnd - tStart;
	double elapsedSeconds = tDelta/1000;
	System.out.println(elapsedSeconds);
	return collision;
	}
}
