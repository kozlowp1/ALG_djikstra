package Model;

import java.util.List;

public class Graph {
	  public final Vertex[] vertexes;
	  public final Edge[] edges;
	  
	  public Graph(Vertex[] vertexes, Edge[] edges) {
		    this.vertexes = vertexes;
		    this.edges = edges;
		  }

	  @Override
	public String toString() {
		  
			for(int y=0;y<edges.length;y++){
				System.out.println(edges[y].toString());
			}
			
		return super.toString();
	}
		  
}
