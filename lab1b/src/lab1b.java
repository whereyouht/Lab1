 package lab1b;
import java.util.LinkedList;
import java.util.Scanner;
import org.omg.CORBA.PUBLIC_MEMBER;
import java.awt.Choice;
import java.awt.List;
import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import lab1b.Graph;
import lab1b.Graph.Edge;
public class lab1b {
    public static void main(String[] args){
    	int cchoice;//1
    	String word1;
    	String word2;
    	String word3;
    	String word4;
    	String word5;
    	String outt = "";
    	
        Graph G =new Graph();
        
        System.out.println("��ӭ��ʹ�ñ�ϵͳ��");//ѭ������
		do {
    	System.out.println("\n�밴����ѡ��");
    	System.out.println("1.���ļ���ȡ����ͼ");
    	System.out.println("2.չʾ����ͼ");
    	System.out.println("3.��ѯ�ŽӴ�");
    	System.out.println("4.�����ŽӴ��������ı�");
    	System.out.println("5.�����������ʵ����·��");
    	System.out.println("6.�������");
    	System.out.println("0.�˳�����");
    	System.out.println("����������ѡ��");
    	Scanner in = new Scanner(System.in);
    	cchoice = in.nextInt();
    	
    	switch(cchoice){
    		case 1:
    			String name = null;
    			String[] s = new String[100];
    			int number;
    			InputStreamReader stdin = new InputStreamReader(System.in);
    			BufferedReader bufin = new BufferedReader(stdin);
    			try{
    				System.out.print("�������ļ���������d:/word.txt��:\n");
    				name=bufin.readLine();
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    			number=readfile(name, s);
    			System.out.print("�ļ��������£�\n");
    			for(int i=0;i<=number;i++)
    			{
    				System.out.println(s[i]);
    			}
    			G.readGraph(s,number+1);	
    			break;
    			
    		case 2:
    			showDirectedGraph(G);
    			break;
    			
    		case 3:
    			System.out.println("�������һ������");
    			String qaq=in.nextLine();
    			word1 = in.nextLine();
    			System.out.println("������ڶ�������");
    			//qaq=in.nextLine();
    			word2 = in.nextLine();
    			//G.bridgeWords(word1, word2);
    			G.queryBridgeWords(word1, word2);
    			//System.out.println(word1);
    			//System.out.println(word2);
    			break;
    			
    		case 4:
    			System.out.println("�����ͼ����һ���ı�");
    			String qwq = in.nextLine();
    			String Inputtext = in.nextLine();
    			String[] input = Inputtext.split(" ");
    			System.out.println("���ɵ��ı��ǣ�");
    			G.generateNewText(input);   	
    			break;
    			
    		case 5:
    			System.out.println("�������һ������");
    			String qeq = in.nextLine();
    			word3 = in.nextLine();
    			System.out.println("������ڶ�������");
    			word4 = in.nextLine();
    			G.Floyd();
    			G.calcShortestPath(word3, word4);
    			//G.f_to_one(word3);
    			break;
    			
    		case 6:	
    			
				try {
					G.randomWalk();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				System.out.println("������ߵ��ı��ѱ�����d:/random.txt");
    			break;
    			
    		case 0:
    			System.out.println("���˳�");
    			System.exit(0);
    
    		default:
    			System.out.println("�Բ����밴Ҫ������ѡ��");
    	} 
    	
    	}while(cchoice == 0 || cchoice == 1||cchoice == 2 || cchoice == 3 || cchoice == 4|| cchoice == 5|| cchoice == 6 );
    }
    
       
    private static String String(InputStream in) {
		// TODO �Զ����ɵķ������
		return null;
	}

	private static void readGraph(Object object) {
		// TODO Auto-generated method stub
		
	}
	
	public static void showDirectedGraph(Graph G) {
		GraphViz gV = new GraphViz();
		gV.addln(gV.start_graph());
		for (String str : G.getVertex().keySet()) {
			LinkedList<Edge> list = new LinkedList<Edge>();
			list = G.getVertex().get(str);
			for (Edge edge : list) {
				gV.addln(edge.start_edge + "->" + edge.end_edge +"[label = "+edge.weight +"]");
			}
		}
		
		gV.addln(gV.end_graph());
		File to = new File("D:\\test.jpg"); 
		gV.writeGraphToFile(gV.getGraph(gV.getDotSource(), "jpg"), to);
		System.out.print("ͼƬ������D�̸�Ŀ¼");
	}

	public static int readfile(String filename,String[] s)
	{
		InputStream in=null;
		int tempbyte;
		int word_number=0,word_new=-1;
		File f=new File(filename);
		String str = new String();
		if(!f.exists())	
		{
			System.out.println("�ļ�������");
			return 0;
		}
		try{
			in=new FileInputStream(f);
			while((tempbyte=in.read())!=-1)
				{
					if(Character.isLetter(tempbyte))
					{
						if(word_new==0)
							word_number++;
						if(s[word_number]!=null)
							s[word_number]+=(char)tempbyte;
						else {
							s[word_number]=String.valueOf((char) tempbyte);
							}
						word_new=1;
					}
					else
					{
						word_new=0;
						s[word_number]=s[word_number].toLowerCase();
					}
				}
			in.close();
			}
		catch(Exception e)
			{
				e.printStackTrace();
			}
		return word_number;
	}
}
