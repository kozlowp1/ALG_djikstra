package test;

import java.io.IOException;
import java.util.PriorityQueue;

import Model.Vertex;

public class TestOfQueue {
	
	public static void main (String[] args) throws IOException  
    {	

		Vertex vert0=new Vertex("vert0");
		Vertex vert1=new Vertex("vert1");
		Vertex vert2=new Vertex("vert2");
		Vertex vert3=new Vertex("vert3");
		
		vert0.setDistanceToSource(3);
		vert1.setDistanceToSource(2);
		vert2.setDistanceToSource(3);
		vert3.setDistanceToSource(1);
		
		PriorityQueue<Vertex> q =new PriorityQueue<Vertex>();
		q.add(vert0);
		q.add(vert1);
		q.add(vert2);
		q.add(vert3);
		
		int count = 1;
	   while(!q.isEmpty()){
		   System.out.println("Dequeued " + count + "--->" + q.remove());
		   count++;
	   }
		
		
    }
}
