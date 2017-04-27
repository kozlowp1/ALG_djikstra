package Dijkstra;

import java.util.ArrayList;




import java.util.Queue;

import Model.Edge;
import Model.Graph;
import Model.Vertex;
import Queue.queue;

public class Dijkstra {
	//sprawdzenie czy nastala jakas kolizja i nie znaleziono sciezki
	boolean collision;
	
Vertex[] path;
Graph graph;
Vertex from;
Vertex to;
queue queue;


public Dijkstra(Graph graph) {
	this.graph = graph;
}

public boolean runDijkstra(Vertex from,Vertex to){
	this.from=from;
	this.to=to;
	from.DistanceToSource=0;

	
	queue = new queue();
	
	
	
	//znajdz sasiada pierwszego punktu
	
	Vertex startingNode=from;
	this.addNeighbours(startingNode);
	do{
		if(queue.isEmpty()){
			break;
		}
		startingNode=queue.remove();
		this.addNeighbours(startingNode);
	}while(!queue.isEmpty());
	
	/*
	this.addNeighbours(from);	
	System.out.println(from.toString() + " " + to.toString());
	//System.out.println(this.from.DistanceToSource);
	queue.clearShow();
	*/
	path=createPath(from,to);
	for(int i=0;i<path.length;i++){
	System.out.println(path[i]);
	}
	return collision;
}


//asdioashod trzeba przypisac do poczatkowego noda
//predecessora ktory ma 0 distance to node

//dodaje do kolejki sąsiadów
private void addNeighbours(Vertex vertex) {
	
	for(int i=0;i<graph.edges.length;i++){
		if(graph.edges[i].source.id==vertex.id && graph.edges[i].used==false)
		{
			graph.edges[i].used=true;
			if(graph.edges[i].destination.DistanceToSource>=
					graph.edges[i].distanceWeight
					+graph.edges[i].source.DistanceToSource)
			{
				graph.edges[i].destination.DistanceToSource = graph.edges[i].distanceWeight
						+graph.edges[i].source.DistanceToSource;
				graph.edges[i].destination.Predecessor=graph.edges[i].source;
				queue.add(graph.edges[i].destination);
			}
		
		}
	}
}

private Vertex[] createPath(Vertex from, Vertex to) {
	
	Vertex container = to;
	
	Vertex[] path;
	ArrayList<Vertex> pathList = new ArrayList<Vertex>();

	pathList.add(to);
	do{
			if (container.Predecessor == null) {
				collision=true;
				System.out.println("nie znaleziono sciezki");	
				break;
			}
		container=container.Predecessor;
		pathList.add(container);

	}while(!(container.id==from.id ));
	
	path=new Vertex[pathList.size()];
	for(int i=0;i<pathList.size();i++){
		path[i]=pathList.get(i);
	}
	return path;

}


}
