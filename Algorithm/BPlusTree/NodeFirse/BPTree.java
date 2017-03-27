
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class BPTree implements Tree {
	
	private static int size = 100000;//总记录数100,000
	private static int sizePerBlock = 40;//由于磁盘上每个block大小是4KB,每条记录大小100B,所以每个block上记录条数为40
	private static int blockSize = (size%sizePerBlock)==0?(size/sizePerBlock):(size/sizePerBlock)+1; //总的块数
	private static String fileDirectory = "D:\\java\\csdn\\";
	private static String recordFile = fileDirectory+"record.txt";
	
	/** 根节点 */
	protected Node root;
	
	/** 阶数，M值 */
	protected int order;
	
	/** 叶子节点的链表头*/
	protected Node head;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public Object get(Comparable key) {
		return root.get(key);
	}

	@Override
	public boolean remove(Comparable key) {
		return root.remove(key, this);

	}

	@Override
	public void insertOrUpdate(Comparable key, Object obj) {
		root.insertOrUpdate(key, obj, this);

	}
	
	public BPTree(int order){
		if (order < 3) {
			System.out.print("order must be greater than 2");
			System.exit(0);
		}
		this.order = order;
		root = new Node(true, true);
		head = root;
	}
	
	public void creatRecords() throws Exception{
		
		File file = new File(recordFile);
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		System.out.println("Creating records...");
		for(int j = 0;j<blockSize;j++){
			for(int i =0;i<sizePerBlock;i++){
				if(!(i == 0 && j == 0)){
					out.newLine();
				}
				out.write(new Record().getRecordString());
			}
		}
		out.close();
	}
	public static void readRecords(BPTree btree) throws Exception{
		BufferedReader in = new BufferedReader( new FileReader(recordFile));
		String line;
		System.out.println("Building B+ Tree...");
		for(int j = 0;j<blockSize;j++){
			for(int i =0;i<sizePerBlock;i++){
				line = in.readLine();
				Record r = new Record(line);
				int key = r.getA();
				btree.insertOrUpdate(key, key);
			}
		}
		in.close();
	}

}
