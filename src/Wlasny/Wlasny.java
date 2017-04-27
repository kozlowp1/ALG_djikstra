package Wlasny;

import java.util.ArrayList;
import Model.Edge;
import Model.Graph;
import Model.Vertex;


public class Wlasny {

	//czy zaszla kolizja i nie znaleziono drogi
	boolean collision = false;
	
	
double length=0;
Graph graph;
ArrayList<Vertex> path = new ArrayList<Vertex>();


public Wlasny(Graph graph) {
	this.graph = graph;
}

public boolean runWlasny(Vertex fromIn,Vertex toIn){
	Vertex from =fromIn;
	Vertex to=toIn;
	from.DistanceToSource=0;

	//znajdz sasiada i stworz punktem nastepnego wyszukiwania tego sasiada
	Vertex startingNode=from;
	do{
		if(startingNode.Name==null){
			collision=true;
			break;
		}
		//mySet.remove(startingNode);
		startingNode = addNextStep(startingNode);
	}while(startingNode.id!=to.id);
	

	
	System.out.println(path);
	return collision;
	
}


private Vertex addNextStep(Vertex vertex) {
	//droga którą będzie zachłannie się kierować
	Edge way = null;
	double lengthVar=0;

	for(int i=0;i<graph.edges.length;i++){
		//znajduje punkt źródłowy
		if(graph.edges[i].source.id==vertex.id && graph.edges[i].used==false)
		{
			graph.edges[i].used=true;
			if(way==null ||  graph.edges[i].distanceWeight<way.distanceWeight )
			{
				way=graph.edges[i];
				lengthVar=graph.edges[i].distanceWeight;
			}
		}
	}
	
	length=length+lengthVar;
	/*if(way==null){
		System.out.println("nie znaleziono drogi");
		collision=true;
	}*/
	if(way==null){
		System.out.println("zabłądzono");
		collision=true;
		return new Vertex(null);
	}
	else{
	way.destination.DistanceToSource=length;
	path.add(way.destination);
	return way.destination;
	}
	
	
	
}

}
