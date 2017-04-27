package Queue;

import java.util.PriorityQueue;

import Model.Vertex;



public class queue {
	static PriorityQueue<Vertex> q;
	
	
	
	public queue() {
		this.q = new PriorityQueue<Vertex>();;
	}

	public void add(Vertex vertex) {
		q.add(vertex);
	}
	
	public boolean isEmpty() {
		return q.isEmpty();
	}
	
	//retrieves and removes the head of queue
	public Vertex remove(){
		return q.remove();
	}
	
	public void clearShow(){
		int count = 1;
		   while(!q.isEmpty()){
			   System.out.println("Dequeued " + count + "--->" + q.remove());
			   count++;
		   }
	}
	
	
	
}
