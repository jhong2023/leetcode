package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser {

	class Node{
		public Node(String name) {
			this.name = name;
		}
		String name;
		List<Node> children;
	}
	
	public Node parser(String xml) {
		Stack<Node> s = new Stack<Node>();
		int i = 0;
		while(i < xml.length()){
			boolean startNode = false;
			boolean endNode = false;
			if(xml.charAt(i) == '<'){
				i++;
				if(xml.charAt(i) == '/'){
					endNode = true;
					i++;
				} else {
					startNode = true;
				}
			}
			if(startNode || endNode){
				String nodeName = "";
				while(xml.charAt(i) != '>'){
					nodeName += xml.charAt(i);
					i++;
				}
			
				if(startNode){
					s.push(new Node(nodeName));
				} else {
					List<Node> children = new ArrayList<Node>();
					while(!s.peek().name.equals(nodeName)){
						Node n = s.pop();
						children.add(n);
					}
					s.peek().children = children;
				}
			}
			i++;
		}
		return s.pop();
	}
	
	void parser_rex(){
		String xml = "<a><b></b></a>";
		Pattern p = Pattern.compile("<(\\w+)>(.*)</(\\w+)>");
		Matcher m = p.matcher(xml);
		
		if(m.find()){
			for(int i=0; i <= m.groupCount(); i++){
				System.out.println(m.group(i));
			}
		}
	}
	
	public static void main(String[] args) {
		String xml = "<aa><b></b><c><d></d><e></e></c></aa>";
		XmlParser parser = new XmlParser();
//		Node n = parser.parser(xml);
//		System.out.println(n.children.get(0).children.size());
		
		parser.parser_rex();
	}

}
