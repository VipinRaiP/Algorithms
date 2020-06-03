package problemInputs;

import classProblems.Graphs;

public class GraphIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int verData[] = {0,1,2,3,4};
/*		Graphs g = new Graphs(5,verData);
		g.addEdge(0,1,4,true);
		g.addEdge(0,2,8,true);
		g.addEdge(1,2,3,true);
		g.addEdge(2,3,1,true);
		g.addEdge(3,1,4,true);
		g.addEdge(3,4,1,true);
		g.addEdge(1,4,6,true);
		System.out.print("\nAdjacency List: \n");
		g.printAdjList();
		System.out.println("\n-----------------------------------------------------------------");
		System.out.print("\n\nBFS Traversal : ");
		g.BFS(0);
		System.out.print("\n\nDFS Traversal : ");
		g.DFS(0);
		int start = 2;
		int dist[][] = new int[verData.length][2];
		System.out.println("\n-----------------------------------------------------------------");
		System.out.println("\n Adj list : ");
		g.printAdjList();
		System.out.println("-----------------------------------------------------------------");
		System.out.print("\n\nDijkstra single source shortest paths from vertex "+start+"\n");
		dist = g.dijkstra(start);
		System.out.print("\nIndex\t\tDist\t\tPi\n");
		for(int i=0;i<verData.length;i++) {
			System.out.printf("%-12d\t%-12d\t%-12d\n",i,dist[i][0],dist[i][1]);
		}
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Prime MST");
		Graphs mst = g.primeMin(0);
		mst.printAdjList();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("\nGraph 2 Adj List");
		int ver[] = {0,1,2,3,4,5};
		Graphs g2 = new Graphs(6,ver);
		g2.addEdge(0,4,4,false);  // undirected
 		g2.addEdge(4,3,4,false);
		g2.addEdge(3,2,2,false);
		g2.addEdge(2,5,3,false);
		g2.addEdge(2,1,7,false);
		g2.addEdge(1,5,9,false);
		g2.printAdjList();
		System.out.println("\nPrime Min Spanning Tree");
		Graphs mst2 = g2.primeMin(0);
		mst2.printAdjList();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Kruskal Min spanning Tree");
		Graphs mst3 = g2.Kruskal_min();
		mst3.printAdjList();
		
		System.out.println("-----------------------------------------------------------------"); */
		
		System.out.println("\n\nEulerian Cycle : ");
		
		Graphs g3 = new Graphs(5,new int[] {0,1,2,3,4});
	
		g3.addEdge(0,3,1,true);
		g3.addEdge(3,4,1,true);
		//g3.addEdge(4,0,1,true);
		g3.addEdge(1,0,1,true);
		g3.addEdge(0,2,1,true);
		g3.addEdge(2,1,1,true);
		g3.printAdjList();
		System.out.print("\nhas Eulerian cycle : "+g3.hasEulerianCycleDirected(g3));
		System.out.print("\nIs Strongly Connected : "+g3.isStronglyConnected(g3));
		System.out.print("\nIs Connected : "+g3.isConnected(g3));
		System.out.print("\nhas Eulerian path: "+g3.hasEulerianPathDirected(g3));
		
		System.out.println("\n-----------------------------------------------------------------");
		
		System.out.println("\nEulerian Cycle Undirected : ");
		
		Graphs g4 = new Graphs(5,new int[] {0,1,2,3,4});
		
		g4.addEdge(0,3,1,false);
		g4.addEdge(3,4,1,false);
		g4.addEdge(4,0,1,false);
		g4.addEdge(1,0,1,false);
		g4.addEdge(0,2,1,false);
		g4.addEdge(2,1,1,false);
		//g4.addEdge(3,1,1,false);


		System.out.print("\nhas Eulerian cycle : "+g4.hasEulerianCycleUnDirected(g4));
		System.out.print("\nIs Connected : "+g4.isConnected(g4));
		System.out.print("\nhas Eulerian path: "+g4.hasEulerianPathUnDirected(g4));
		
		System.out.println("\n-----------------------------------------------------------------");
		
		System.out.println("\nCheck Bipartite : ");
		
		Graphs g5  = new Graphs(5,new int[] {0,1,2,3,4});
		g5.addEdge(0,1,1, false);
		g5.addEdge(1,2,1, false);
		g5.addEdge(2,3,1, false);
		g5.addEdge(3,4,1, false);
		g5.addEdge(4,0,1, false);
		
		System.out.println("Is Bipartite : "+g5.isBipartite(g5));
		
		Graphs g6  = new Graphs(6,new int[] {0,1,2,3,4,5});
		g6.addEdge(0,1,1, false);
		g6.addEdge(1,2,1, false);
		g6.addEdge(2,3,1, false);
		g6.addEdge(3,4,1, false);
		g6.addEdge(4,5,1, false);
		g6.addEdge(5,0,1, false);
		//g6.addEdge(6,0,1, false);
		System.out.println("Is Bipartite : "+g6.isBipartite(g6));
		
		
		System.out.println("\n-----------------------------------------------------------------");
		
		System.out.println("\nArticulation Points : ");
		
		Graphs g7 = new Graphs(5,new int[] {0,1,2,3,4});
		
		g7.addEdge(0,3,1,false);
		g7.addEdge(3,4,1,false);
		//g4.addEdge(4,0,1,false);
		g7.addEdge(1,0,1,false);
		g7.addEdge(0,2,1,false);
		g7.addEdge(2,1,1,false);
		
		Boolean [] ap = g7.findArticulationPoints(g7);
		Boolean[][] bridges = g7.findBridges(g7) ;
		System.out.print("\nAP : ");
		for(int i=0;i<5;i++) {
			if(ap[i])
				System.out.print(i+" ");
		}
		System.out.print("Bridges : ");
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(bridges[i][j])
					System.out.print(i+"-->"+j+" ");
			}	
		}
		System.out.println();
		Graphs g8 = new Graphs(7,new int[] {0,1,2,3,4,5,6});
		
		g8.addEdge(0,2,1,false);
		g8.addEdge(0,1,1,false);
		//g4.addEdge(4,0,1,false);
		g8.addEdge(1,2,1,false);
		g8.addEdge(1,6,1,false);
		g8.addEdge(1,3,1,false);
		g8.addEdge(1,4,1,false);
		g8.addEdge(3,5,1,false);
		g8.addEdge(5,4,1,false);
		
		
		Boolean ap2[] = g8.findArticulationPoints(g8);
		Boolean bridges2[][] = g8.findBridges(g8);
		System.out.print("\nAP : ");
		for(int i=0;i<7;i++) {
			if(ap2[i])
				System.out.print(i+" ");
		}
		System.out.print("Bridges : ");
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				if(bridges2[i][j])
					System.out.print(i+"-->"+j+" ");
			}	
		}
		
		System.out.println("\n-----------------------------------------------------------------");

		System.out.println("Biconnected components");
		Graphs g9 = new Graphs(10,new int[]{0,1,2,3,4,5,6,7,8,9});
	      	g9.addEdge(0, 1,1,false); 
	        g9.addEdge(0, 6,1,false); 
	        g9.addEdge(1, 5,1,false); 
	        g9.addEdge(5, 6,1,false); 
	        g9.addEdge(5, 8,1,false); 
	        g9.addEdge(5, 7,1,false); 
	        g9.addEdge(7, 8,1,false); 
	        g9.addEdge(8, 9,1,false); 
	        g9.addEdge(1, 3,1,false); 
	        g9.addEdge(1, 2,1,false); 
	        g9.addEdge(2, 3,1,false); 
	        g9.addEdge(2, 4,1,false); 
	        g9.addEdge(4, 3,1,false); 
	       // g9.findBiConnectedComponents(g9);
	        ap = g9.findArticulationPoints(g9);
	        for(int i=0;i<10;i++) {
				if(ap[i])
					System.out.print(i+" ");
			}
	}
}
