package Model;

public class Edge {
static int idGlobal=0;
int id;
String name;
public Vertex source;
public Vertex destination;
public double layover;
public double maxSpeed;
public double distance;
public boolean used = false;
//jezeli jest postoj w punkcie Destination
//to nalezy dodac do kosztu podrozy
public double distanceWeight;

public Edge(Vertex source, Vertex destination,
		double layover, double maxSpeed, double distance) {

	this.id = idGlobal;
	this.name = "Distance_" + idGlobal;
	this.source = source;
	this.destination = destination;
	this.layover = layover;
	this.maxSpeed = maxSpeed;
	this.distance = distance;
	this.distanceWeight = (distance/maxSpeed)+layover;
	
	idGlobal++;
}

@Override
	public String toString() {

		return "id:|" + id + "|  F:" + source.toString() + " T:" + destination.toString() 
				+ " LO:[" + layover + "] TC:[" + distanceWeight + "]";
	}



}
