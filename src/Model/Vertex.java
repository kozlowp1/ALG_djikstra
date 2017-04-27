package Model;





public class Vertex implements Comparable<Vertex>{
static int idGlobalVertex=0;
public int id;
public String Name;
public Vertex Predecessor;
public double DistanceToSource=1000;
//na potrzeby wlasnego algorytmu
public boolean used;

public void setDistanceToSource(double dist){
	this.DistanceToSource=dist;
}
public Vertex(String name) {
	this.id = idGlobalVertex;
	Name = name;
	idGlobalVertex++;
}

@Override
	public String toString() {

		return "[" + Name + ",distToSource " + DistanceToSource + "]" ;
	}

public boolean equals(Vertex other){
	return this.DistanceToSource == other.DistanceToSource;
}

public int compareTo(Vertex other) {
	if(this.equals(other))
		return 0;
	else if (DistanceToSource > other.DistanceToSource)
		return 1;
	else
		return -1;
	

}

}
