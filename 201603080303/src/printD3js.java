import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class printD3js {

	static String readFile = "C:\\Users\\Tomato\\Desktop\\123\\force.csv";
	static String a;
	static ArrayList<Links> linksList = new ArrayList<Links>();
	static TreeMap<String,Integer> nodeIdMap=new TreeMap<String,Integer>();
	public static void main(String[] args) {
		try {
			BufferedReader redfile = new BufferedReader(
					new InputStreamReader(new FileInputStream(readFile)));
			a = redfile.readLine();//ignore
			while ((a = redfile.readLine()) != null) {
				Links lk = new Links();
				String s[]=a.split(",");
				lk.setSource(s[0]);
				lk.setTarget(s[1]);
				lk.setValue(s[2]);
				linksList.add(lk);
			}
			int k=0;
			for(int i=0;i<linksList.size();i++) {
				if(!nodeIdMap.containsKey(linksList.get(i).getSource())) {
					nodeIdMap.put(linksList.get(i).getSource(), k++);
				}
				if(!nodeIdMap.containsKey(linksList.get(i).getTarget())) {
					nodeIdMap.put(linksList.get(i).getTarget(), k++);
				}
			}
			printD3jsLine();
			redfile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@SuppressWarnings("unused")
//	private void printD3jsNodes() {// 输出d3js的节点
//		System.out.print("var nodes = [ ");
//		int i = 0;
//		for (Map.Entry<String, Integer> entry : userMap.entrySet()) {
//			System.out.print("{ name: " + "\"" + entry.getKey() + "\"" + " }");
//			if (i != userMap.size() - 1)
//				System.out.print(",");
//			if ((i + 1) % 4 == 0)
//				System.out.println("");
//			i++;
//		}
//		System.out.println("];");
//	}

	@SuppressWarnings("unused")
	private static void printD3jsLine() {// 输出d3js图的有向边
		System.out.print("var links = [ ");
		int i = 0;
		int len = linksList.size();
		for (i=0;i<len;i++) {
			Links lk=linksList.get(i);
			System.out.print("{ name : \"");
			System.out.print(lk.getSource()+"\", source :"+nodeIdMap.get(lk.getSource()) + ", target:" +nodeIdMap.get(lk.getTarget()) +", value:"+lk.getValue());
			System.out.print("} ");
			if (i != len - 1)
				System.out.println(",");
			i++;
		}
		System.out.println("];");
	}
}

class Links {
	private String source;
	private String target;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;
}