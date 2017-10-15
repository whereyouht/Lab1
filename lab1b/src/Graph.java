package lab1b;
//git测试修改
import java.awt.image.BufferedImageFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Random;
import java.util.Scanner;

class Constant
{
	public static final int MAX = 100000;

}
 public class Graph {
	private static int V;
	private static int E = 0;
	private static HashMap<String, LinkedList<Edge>> Vertex;
	private static Edge[]  edges;
	private String [][] Path;
	private int[][] Distance;
	private Stack<String> stack_path = new Stack<String>();
	private HashMap<String, Integer> vexTOint;
	
	class Edge
	{
		String start_edge = "";
		String end_edge= "";
		int weight = 0;
		boolean flag = false;
		
		public boolean equals(Edge temp)
		{
			if(start_edge.equals(temp.start_edge) && end_edge.equals(temp.end_edge))
			{
				return true;
			}
			else
				return false;

		}
	}
	
	
	public HashMap<String, LinkedList<Edge>> getVertex(){
		return Vertex;
	}
	
	public void readGraph(String[] readin,int number) //读图
	{
		Vertex = new HashMap<String,LinkedList<Edge>>();
		edges = new Edge[number];
		
		for (int i=0;i<number;i++) 
		{ 
			edges[i] = new Edge();
		}
		//System.out.println(readin.length);
		for (int i=0;  i< number -1;i++)
		{
			String title = readin[i];
			String last = readin[i+1];
			
			int flag = 0;
			for(int j=0;j<E;j++)
			{
				if (edges[j].end_edge.equals(last) && edges[j].start_edge.equals(title))
				{
					edges[j].weight++;
					flag = 1;
					break;
				}
			}
			if (flag == 0)
			{
				edges[E].end_edge = last;
				edges[E].start_edge = title;
				edges[E].weight = 1;
				E++;
			}
		}
		
		for(int i=0;i<readin.length;i++)
		{
			Vertex.put(readin[i], new LinkedList<Edge>());
		}
		
		V = Vertex.size();
		
		for(int i=0;i<E;i++)
		{
			Vertex.get(edges[i].start_edge).add(edges[i]);
		}
	}
	
	/*public String queryBridgeWords(String word1, String word2) {
		String a = "abc";
		return a;
	}
	
	public String generateNewText(String inputText){//根据桥接词生成新文本
		String b = "abc";
		return b;
    }*/
	
	public static void main() {
		Graph G = new Graph();
		//G.readGraph("aa bb c  d iow wjkdjsk njhwu aa bb".split("\\s+"));
	}
	
	
	public String queryBridgeWords (String word1,String word2) {//输出桥接词结果
		String on="";
		if(Vertex.containsKey(word1) && Vertex.containsKey(word2))
		{
			String outt = bridgeWords(word1, word2);
			if(outt.equals(""))
			{
				System.out.println("No bridge words from " + "'"+ word1 +"'"+" to " + "'"+word2+"'" +" !");
			}
			else
			{
				System.out.println("The bridge words from " + "'" + word1 + "'" + " to " + "'" +word2 +"'"+" are: " +outt);
			}

		}
		else
		{
			System.out.println("No"+"'"+word1+"'"+ "or" +"'"+word2+"'"+ "in the graph!");
		}
		return on;
	}
	
	
	
	public String bridgeWords(String word1,String word2)//找桥接词
	{
		String outt = "";

		Stack<String> wholebridge = new Stack<String>();
		Stack<String> bridge = new Stack<String>();

		LinkedList<Edge> temp = Vertex.get(word1);
		String mayBridge;

		for(int i = 0;i<temp.size();i++)
		{
			mayBridge = temp.get(i).end_edge;
			if(!mayBridge.equals(word2))
			{
				bridge.push(mayBridge);
			}
		}

		while(!bridge.empty())
		{
			String may = bridge.pop();
			LinkedList<Edge> temp2 = Vertex.get(may);
			String testWord;

			for(int i = 0;i<temp2.size();i++)
			{
				testWord = temp2.get(i).end_edge;
				if(testWord.equals(word2))
				{
					wholebridge.push(may);
					break;
				}
			}
		}

		while(!wholebridge.empty())
		{
			outt = outt.concat(wholebridge.pop());
			if(wholebridge.empty())
				outt = outt.concat(".");
			else
				outt = outt.concat(",");
		}
		return outt;
	}
	
	
	public String generateNewText(String[] inputText)//根据桥接词生成新文本
	{
		LinkedList<String> outt = new LinkedList<String>();
		for(int i = 0;i+1<inputText.length;i++)
		{

			outt.add(inputText[i]);

			if(Vertex.containsKey(inputText[i]) && Vertex.containsKey(inputText[i+1]))
			{
				String bridge = bridgeWords(inputText[i], inputText[i+1]);
				if(!bridge.equals(""))
				{
					String[] temp = bridge.split("[^a-zA-Z]+");
					//随机选择更优，试一下。
					outt.add(temp[0]);
				}
			}
		}
		outt.add(inputText[inputText.length-1]);


		String endText = "";

		for(int i = 0;i+1<outt.size();i++)
		{
			endText= endText + outt.get(i)+" ";
			//System.out.print(outt.get(i)+" ");
		}
		endText = endText + outt.getLast();

		endText = endText.substring(0,1).toUpperCase()+endText.substring(1);
	//	System.out.println(outt.getLast());
		System.out.println(endText);
		return endText;
	}
	
	/*public void f_to_one(String start)
	{
		for(String end:vexTOint.keySet())
		{
			if(start.equals(end))
				continue;
			else
				p_Path(start, end);

		}
	}*/

	public String calcShortestPath(String start,String end)
	{
		String out="";
		if(start.equals(end) || Distance[vexTOint.get(start)][vexTOint.get(end)] == Constant.MAX)
		{
			System.out.println("No way!");
		}
		else
		{
			System.out.print(start+"->");
			shortestPath(start, end);
			System.out.println(end);
			System.out.println("The length of path is "+Distance[vexTOint.get(start)][vexTOint.get(end)]);
		}
		return out;
	}


	public void shortestPath(String start,String end)
	{
		int i = vexTOint.get(start);
		int j = vexTOint.get(end);

		if(Path[i][j].equals(""))
		{
			return;
		}
		else
		{
			stack_path.push(Path[i][j]);
			shortestPath(start, Path[i][j]);
			if(!stack_path.empty())
				System.out.print(stack_path.pop()+"->");
			shortestPath(Path[i][j], end);
			if(!stack_path.empty())
				System.out.print(stack_path.pop()+"->");
		}
	}

	public void Floyd()
	{
		vexTOint = new HashMap<String,Integer>();
		int value = 0;
		for(String key:Vertex.keySet())
		{
			vexTOint.put(key,value);
			value++;
		}


		Distance = new int[V][V];
		Path = new String[V][V];
		for(int i = 0;i<V;i++)
		{
			Distance[i] = new int[V];
			Path[i] = new String[V];
			for(int j = 0;j<V;j++)
			{
				Distance[i][j] = Constant.MAX;
				Path[i][j] = "";
			}
		}
		for(int i = 0;i<E;i++)
		{
			Distance[vexTOint.get(edges[i].start_edge)][vexTOint.get(edges[i].end_edge)] = edges[i].weight;
		}

		for(String k:vexTOint.keySet())
		{
			for(String i:vexTOint.keySet())
			{
				for(String j:vexTOint.keySet())
				{
					int i1,j1,k1;
					i1 = vexTOint.get(i);
					j1 = vexTOint.get(j);
					k1 = vexTOint.get(k);
					if(Distance[i1][k1] + Distance[k1][j1] < Distance[i1][j1])
					{
						Distance[i1][j1] = Distance[i1][k1] + Distance[k1][j1];
						Path[i1][j1] = k;
					}
				}
			}
		}
	}
	
	public String randomWalk() throws IOException
	{
		HashMap<Edge, Boolean> visit = new HashMap<Edge,Boolean>();
		Scanner in = new Scanner(System.in);
		String result = new String();
		result = "";
		Random r1 = new Random();
		int j1 = r1.nextInt( Vertex.size());
		int i1 = 0 ;
		for (String string : Vertex.keySet()) {
			i1++;
			if (i1 == j1) {
				for(Edge key:edges)
				{
					visit.put(key, false);
				}

				stack_path.push(string);
				System.out.print(string);
				result = result+ string + " ";
			}
		}
		
		
		LinkedList<Edge> p;

		while(!stack_path.empty())
		{
			p = Vertex.get(stack_path.pop());
			for(int i= 0;i<p.size();i++)
			{
				Random r11 = new Random();
				int j = r11.nextInt(p.size());
				Edge edge = p.get(j);
				if(!visit.get(edge))
				{
					System.out.println("\n输入Y继续/N结束：");
					String qtq = in.nextLine();
					if(qtq.equals("Y")) {
						System.out.print(""+edge.end_edge);
						result = result+ edge.end_edge + " ";
						visit.replace(edge, true);
						
						stack_path.push(edge.end_edge);
						break;
					}
					else if (qtq.equals("N")){
						break;

					}
				}
				
				else
				{
					System.out.print(" "+edge.end_edge);
					result = result + " " + edge.end_edge;
					
					break;
				}			

			}

		}
		System.out.println("\n随机游走结束");
		
		File file = new File("D:\\random.txt");
		BufferedWriter output = new BufferedWriter(new FileWriter(file));  
	    output.write(result);  
	    output.close();
	    return result;
	}
}
 