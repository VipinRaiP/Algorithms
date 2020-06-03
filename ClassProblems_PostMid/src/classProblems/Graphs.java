package classProblems;


import java.util.*;
import classProblems.MinHeap;


public class Graphs {

	private LinkedList<Node> adjList[];
	private Node vertices[];
	private int weight[][];
	private int time;
	private int[] verData;
	private class Edge{
		private int u;
		private int v;
		private int weight;
		public Edge(int u,int v,int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}
	private LinkedList<Edge> EdgeList;
	public Graphs(int v,int verData[]){
		this.vertices = new Node[v];
		adjList = new LinkedList[v];
		weight = new int[v][v];
		this.verData = verData;
		this.EdgeList = new LinkedList<Edge>();
		for(int i=0;i<v;i++) {
			adjList[i] = new LinkedList<Node>();
			vertices[i] = new Node(verData[i],i);
			this.time = 0;
		}
	}
	
	public void addEdge(int v1,int v2,int weight,boolean directed) {
		adjList[v1].add(vertices[v2]);
		this.weight[v1][v2] = weight;
		this.EdgeList.add(new Edge(v1,v2,weight));
		if(!directed) {
			adjList[v2].add(vertices[v1]);
			this.weight[v2][v1] = weight;
		}
		
	}
	
	public void printAdjList() {
		for(int i=0;i<adjList.length;i++) {
			System.out.print("\n"+vertices[i].data+" : ");
			for(Node adj:adjList[i]) {
				System.out.print(adj.data+"("+weight[i][adj.index]+")"+"->");
			}
		}
		System.out.println();
	}
	
	/* Graph traversals */
	
	public void initTraversal() {
		for(int i=0;i<vertices.length;i++) {
			vertices[i].visited=false;
			vertices[i].pi = null;
		}	
	}
	
	public void BFS(int v) {
		Queue<Node> q = new LinkedList<Node>();
		initTraversal();
		q.add(vertices[v]);
		vertices[v].visited = true;
		vertices[v].pi = vertices[v];
		while(!q.isEmpty()) {
			Node cur = q.remove();
			System.out.print(cur.data+" --> ");
			for(Node adj:adjList[cur.index]) {
				if(!adj.visited) {
					q.add(adj);
					adj.visited = true;
					adj.pi = cur;
				}
			}
		}
	}
	
	public void  DFS(int v) {
		initTraversal();
		time = 0;
	//	vertices[v].pi=vertices[v];
		DFSRec(v);
		printTime();
	}
	
	public void DFSRec(int v) {
		
		if(vertices[v].visited==false) {
			vertices[v].visited=true;
			vertices[v].discoveryTime = time++;
			System.out.print(vertices[v].data+"-->");
			
			for(Node adj:adjList[v]) {
				if(adj.visited==false) {
					adj.pi = vertices[v];
					DFSRec(adj.index);
				}
			}
			vertices[v].finishTime=time++;
		}
	}

	public void printTime() {
		System.out.println("\nDiscovery and Finish times");
		for(int i=0;i<vertices.length;i++) {
			if(vertices[i].pi==null)
				System.out.print("\nindex : "+ vertices[i].data + " DT : "+vertices[i].discoveryTime+" FT: "+vertices[i].finishTime+" Pi: null");
			else	
				System.out.print("\nindex : "+ vertices[i].data + " DT : "+vertices[i].discoveryTime+" FT: "+vertices[i].finishTime+" Pi: "+vertices[i].pi.index);
		}
	}
	
	public int[][] dijkstra(int v) {
		int dist[][] = new int[vertices.length][2];
		initDijkstra(v);
		dijkstraImp(v);
		for(int i=0;i<vertices.length;i++) {
			dist[i][0] = vertices[i].priority;
			if(vertices[i].pi!=null)
				dist[i][1] = vertices[i].pi.index;
			else
				dist[i][1] = -1;
		}
		return dist;
	}
	
	public void initDijkstra(int v) {
		for(int i=0;i<vertices.length;i++) {
			vertices[i].visited=false;
			vertices[i].pi = null;
			if(i!=v)
				vertices[i].priority = Integer.MAX_VALUE;
			else {
				vertices[i].priority = 0;
			}		
		}
	}
	
	public void dijkstraImp(int v) {
		DijMinHeap h = new DijMinHeap(100000);
		//Node vert_cop[] = new Node[]
		h.BuildHeap(vertices.clone());
	
		while(h.getSize()!=0){
			Node cur = h.getMin();
			h.DeleteMin(h.getHeap());
			vertices[cur.index].visited = true;
			for(Node adj:adjList[cur.index]) {
				if(vertices[adj.index].visited==false && vertices[adj.index].priority>(vertices[cur.index].priority+weight[cur.index][adj.index])) {
					h.DecKey(h.getHeap(),adj.index,vertices[cur.index].priority+weight[cur.index][adj.index]);
					vertices[adj.index].priority = vertices[cur.index].priority+weight[cur.index][adj.index];
					vertices[adj.index].pi = vertices[cur.index];
				}
			}
		}
	}
	
	public Graphs primeMin(int v) {
		initDijkstra(v);
		primeMinImp();
		Graphs mst = new Graphs(this.verData.length,this.verData.clone());
		for(int i=0;i<vertices.length;i++) {
			if(vertices[i].pi!=null) {
				int parent_index = vertices[i].pi.index;
				mst.addEdge(parent_index,i, weight[parent_index][i],false);
			}
		}
		return mst;
	}
	
	public void primeMinImp() {
		DijMinHeap h = new DijMinHeap(100000);
		//Node vert_cop[] = new Node[]
		h.BuildHeap(vertices.clone());
	
		while(h.getSize()!=0){
			Node cur = h.getMin();
			h.DeleteMin(h.getHeap());
			vertices[cur.index].visited = true;
			for(Node adj:adjList[cur.index]) {
				if(vertices[adj.index].visited==false && vertices[adj.index].priority>(weight[cur.index][adj.index])) {
					h.DecKey(h.getHeap(),adj.index,weight[cur.index][adj.index]);
					vertices[adj.index].priority = weight[cur.index][adj.index];
					vertices[adj.index].pi = vertices[cur.index];
				}
			}
		}
	}
	
	/* Kruskals MST */
	
	public Graphs Kruskal_min() {
		// colour of a vertex;
		int []vertexColour = new int[verData.length];
		// number of vertex with colour i
		int []numberVertex = new int[verData.length];
		int totalVertex = verData.length;
		ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<ArrayList<Integer>>();
		
		Graphs minSt = new Graphs(this.verData.length,this.verData.clone());
		
		class sortEdges implements Comparator<Edge>{
			public int compare(Edge e1,Edge e2) {
				return e1.weight-e2.weight;
			}
		}
		
		Collections.sort(EdgeList,new sortEdges());
		
		for(int i=0;i<totalVertex;i++) {
			vertexColour[i] = i;
			numberVertex[i] = 1;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(i);
			connectedComponents.add(temp);
		}
		
		for(Edge e:EdgeList) {
			if(vertexColour[e.u]==vertexColour[e.v]) {
				continue;
			}
			else {
				if(numberVertex[e.u]<=numberVertex[e.v]) {
					numberVertex[e.v] += numberVertex[e.u];
					numberVertex[e.u] = 0;
					for(int verIndex:connectedComponents.get(e.u)) {
						vertexColour[verIndex] = vertexColour[e.v];
						connectedComponents.get(e.v).add(verIndex);
					}
					/* empty the list */
					
			
				}
				else {
					numberVertex[e.u] += numberVertex[e.v];
					numberVertex[e.v] = 0;
					for(int verIndex:connectedComponents.get(e.v)) {
						vertexColour[verIndex] = vertexColour[e.u];
						connectedComponents.get(e.u).add(verIndex);
					}
					/* empty the list */
					
				}
				minSt.addEdge(e.u,e.v,e.weight,false);
			}
			
		}
		
		return minSt;
	}
	
	
	
	
	/* update min spanning tree after adding a new edge */
	
	
	public void newEdgeMinST(int u,int v,int weight) {
		
		//int max_weight_edge = findMaxEdge(u,v); 
		
	}
	
	
	/* Transpose of a graph */
	
	public Graphs getTranspose(Graphs g) {
		
		Graphs gt = new Graphs(g.verData.length,g.verData);
		int i=0;
		for(LinkedList<Node> list:g.adjList) {
			
			for(Node adj:list) {
				gt.addEdge(adj.index,i,g.weight[i][adj.index],true);
			}
			i+=1;
		}
		return gt;
	}
	
	/* Check graph is strongly connected */
	
	public boolean isStronglyConnected(Graphs g) {
		
		g.DFS(0);
		
		for(int i=0;i<g.verData.length;i++) {
			if(g.vertices[i].visited==false)
				return false;
		}
		
		Graphs gt = getTranspose(g);
		
		gt.DFS(0);
		
		for(int i=0;i<gt.verData.length;i++) {
			if(gt.vertices[i].visited==false)
				return false;	
		}
		
		return true;
	}
	
	/* Check graph is connected */
	
	public boolean isConnected(Graphs g) {
		
		g.DFS(0);
		
		for(int i=0;i<g.verData.length;i++) {
			if(g.vertices[i].visited==false)
				return false;
		}
			
		return true;
	}
	
	/* To find graph contains eulerian cycle 
	 */
	
	public boolean  hasEulerianCycleDirected(Graphs g) {
		
		if(!g.isStronglyConnected(g))
		{
			return false;
		}
		
		int outDegree[] = new int[g.verData.length];
		int inDegree[] = new int[g.verData.length];
		int index=0;
		for(int i=0;i<g.verData.length;i++)
			inDegree[i] = 0;
		for(LinkedList<Node> list:g.adjList) {
			outDegree[index++] = list.size();
			for(Node adj:list) {
				inDegree[adj.index] += 1;
			}
		}
		
		for(int i=0;i<g.verData.length;i++) {
			if(inDegree[i]!=outDegree[i])
				return false;
			
		}
		return true;
	}

	/* graph contains eulerian path */
	
	
	public boolean hasEulerianPathDirected(Graphs g) {
		
		if(!g.isConnected(g))
		{
			return false;
		}
		
		int outDegree[] = new int[g.verData.length];
		int inDegree[] = new int[g.verData.length];
		int index=0;
		for(int i=0;i<g.verData.length;i++)
			inDegree[i] = 0;
		for(LinkedList<Node> list:g.adjList) {
			outDegree[index++] = list.size();
			for(Node adj:list) {
				inDegree[adj.index] += 1;
			}
		}
		
		int inGreater=0;
		int outGreater=0;
		int equalDegree=0;
		
		for(int i=0;i<g.verData.length;i++) {
			if(inDegree[i]>outDegree[i]) {
				inGreater += 1;
				if(inGreater>1)
					return false;
			}
			else if(inDegree[i]<outDegree[i]) {
				outGreater += 1;
				if(outGreater>1)
					return false;
			}
			else {
				equalDegree += 1;
			} 
			
		}
		//System.out.println(inGreater + " "+ outGreater+" "+equalDegree+" "+g.verData.length);
		if(inGreater==1 && outGreater==1 && equalDegree==g.verData.length-2) {
			return true;
		}
		
		return false;
	}
	
	public boolean hasEulerianPathUnDirected(Graphs g) {
		
		if(!g.isConnected(g))
		{
			return false;
		}
		
		int Degree[] = new int[g.verData.length];
		
		int index=0;
		int oddDegree = 0;
		for(LinkedList<Node> list:g.adjList) {
			Degree[index] = list.size();
			if((Degree[index]%2)!=0)
				oddDegree += 1;
		}
		
		if(oddDegree>2)
			return false;
		else if(oddDegree==2||oddDegree==0)
			return true;	
		
		return false;
	}
	
	public boolean hasEulerianCycleUnDirected(Graphs g) {
		
		if(!g.isConnected(g))
		{
			return false;
		}
		
		int Degree[] = new int[g.verData.length];
		
		int index=0;
		int oddDegree = 0;
		for(LinkedList<Node> list:g.adjList) {
			Degree[index] = list.size();
			if((Degree[index]%2)!=0)
				return false;
		}
		
		return true;
	}
	
	/* Check whether a given graph is bipartite */
	
	public boolean isBipartite(Graphs g) {
		
		g.initTraversal();
		
		ArrayList<Node> q = new ArrayList<Node>();
		
		q.add(g.vertices[0]);
		g.vertices[0].color = 0;
		g.vertices[0].visited = true;
		while(q.size()!=0) {
			Node curVertex = q.remove(0);
			LinkedList<Node> list = g.adjList[curVertex.index];
			for(Node adjVertex:list) {
				if(adjVertex.color==-1) {
					g.vertices[adjVertex.index].color = 1-curVertex.color;
				}
				else if(adjVertex.color==curVertex.color)
					return false;
				if(g.vertices[adjVertex.index].visited==false) {
					q.add(g.vertices[adjVertex.index]);
				}
				g.vertices[adjVertex.index].visited = true;
			}
		}
		return true;	
	}
	
	/* Find Articulation points in the graph */
	
	public void getAp(Graphs g,int src,Integer[] low,Boolean ap[],int time) {
		
		g.vertices[src].visited = true;
		
		LinkedList<Node> adj = g.adjList[src];
		g.vertices[src].discoveryTime = time;
		low[src] = time++;
		int noChildren = 0;
		for(Node vertex:adj) {
			if(g.vertices[vertex.index].visited!=true) {
				noChildren +=1;
				g.vertices[vertex.index].pi = g.vertices[src];
				getAp(g,vertex.index,low,ap,time);
				
				low[src] = Math.min(low[src],low[vertex.index]);
				
				if(g.vertices[src].pi==null && noChildren>1) {
					ap[src] = true;
				}
				
				if(g.vertices[src].pi!=null && g.vertices[src].discoveryTime<=low[vertex.index]) {
					ap[src] = true;
				}
			}
			else {
				if(g.vertices[src].pi!=null && g.vertices[src].pi.index!=vertex.index) {
					low[src] = Math.min(low[src],g.vertices[vertex.index].discoveryTime);
				}
			}
		}
	}
	

	public Boolean[] findArticulationPoints(Graphs g) {
		
		int noV = g.verData.length;
		g.initTraversal();
		Integer low[] = new Integer[noV];
		Boolean ap[] = new Boolean[noV];
		
		for(int i=0;i<noV;i++)
			ap[i] = false;
		
		getAp(g,0,low,ap,0);
		
		return ap;
	}
	
	
	/* Find bridge of the graph */
	

	/* Find Articulation points in the graph */
	
	public void getBridges(Graphs g,int src,Integer[] low,Boolean bridges[][],int time) {
		
		g.vertices[src].visited = true;
		
		LinkedList<Node> adj = g.adjList[src];
		g.vertices[src].discoveryTime = time;
		low[src] = time++;
		int root = -1;
		int noChildren = 0;
		for(Node vertex:adj) {
			if(g.vertices[vertex.index].visited!=true) {
				noChildren +=1;
				g.vertices[vertex.index].pi = g.vertices[src];
				getBridges(g,vertex.index,low,bridges,time);
				
				low[src] = Math.min(low[src],low[vertex.index]);
				
			/*	if(g.vertices[src].pi==null && noChildren>1) {
					root = src;
				}*/
				
				if(g.vertices[src].discoveryTime<low[vertex.index]) {
					bridges[src][vertex.index] = true;
				}
			}
			else {
				if(g.vertices[src].pi!=null && g.vertices[src].pi.index!=vertex.index) {
					low[src] = Math.min(low[src],g.vertices[vertex.index].discoveryTime);
				}
			}
		}
		if(root==src) {
			for(Node in:g.adjList[src]) {
				if(g.vertices[in.index].pi.index==root) {
					bridges[root][in.index] = true;
				}
			}
		}
	}
	

	public Boolean[][] findBridges(Graphs g) {
		
		int noV = g.verData.length;
		g.initTraversal();
		Integer low[] = new Integer[noV];
		Boolean bridges[][] = new Boolean[noV][noV];
		
		for(int i=0;i<noV;i++) {
			for(int j=0;j<noV;j++)
				bridges[i][j] = false;
		}	
		
		getBridges(g,0,low,bridges,0);
		
		return bridges;
	}
	
	
	/*  Biconnected components of the graph */
		
	public void findBiConnectedComponents(Graphs g) {
		int noV = g.verData.length;
		LinkedList<Edge> stack = new LinkedList<Edge>();
		Integer low[] = new Integer[noV];
		getBCC(g,0,low,0,stack);
		while (stack.size() > 0) { 
            System.out.print(stack.getLast().u + "--" + stack.getLast().v + " "); 
            stack.removeLast(); 
        }
		
	}
	
	
	
	public void getBCC(Graphs g,int src,Integer[] low,int time,LinkedList<Edge> stack) {
		
		g.vertices[src].visited = true;
		
		LinkedList<Node> adj = g.adjList[src];
		g.vertices[src].discoveryTime = time;
		low[src] = time++;
		int noChildren = 0;
		for(Node vertex:adj) {
			if(g.vertices[vertex.index].visited!=true) {
				noChildren +=1;
				g.vertices[vertex.index].pi = g.vertices[src];
				stack.add(new Edge(src,vertex.index,g.weight[src][vertex.index]));
				getBCC(g,vertex.index,low,time,stack);
				
				low[src] = Math.min(low[src],low[vertex.index]);
				
				if((g.vertices[src].pi==null && noChildren>1) || (g.vertices[src].pi!=null && g.vertices[src].discoveryTime<=low[vertex.index])) {
					while(stack.getLast().u!=src && stack.getLast().v!=vertex.index) {
						System.out.print(stack.getLast().u+"---->"+stack.getLast().v+"  ");
						stack.removeLast();
					}
					System.out.println(src+"---->"+vertex.index);
					stack.removeLast();
				}
			}
			else {
				if(g.vertices[src].pi!=null && g.vertices[src].pi.index!=vertex.index && g.vertices[vertex.index].discoveryTime<g.vertices[src].discoveryTime) {
					low[src] = Math.min(low[src],g.vertices[vertex.index].discoveryTime);
					stack.add(new Edge(src,vertex.index,g.weight[src][vertex.index]));
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}