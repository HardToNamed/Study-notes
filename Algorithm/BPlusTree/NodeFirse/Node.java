
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class Node {
	
	/** 是否为叶子节点 */
	protected boolean isLeaf;
	
	/** 是否为根节点*/
	protected boolean isRoot;

	/** 父节点 */
	protected Node parent;
	
	/** 叶节点的前节点*/
	protected Node previous;
	
	/** 叶节点的后节点*/
	protected Node next;	
	
	/** 节点的关键字 */
	protected List<Entry<Comparable, Object>> entries;
	
	/** 子节点 */
	protected List<Node> children;
	
	public Node(boolean isLeaf) {
		this.isLeaf = isLeaf;
		entries = new ArrayList<Entry<Comparable, Object>>();
		
		if (!isLeaf) {
			children = new ArrayList<Node>();
		}
	}

	public Node(boolean isLeaf, boolean isRoot) {
		this(isLeaf);
		this.isRoot = isRoot;
	}
	
	public Object get(Comparable key) {
		
		//如果是叶子节点
		if (isLeaf) {
			for (Entry<Comparable, Object> entry : entries) {
				if (entry.getKey().compareTo(key) == 0) {
					//返回找到的对象
					return entry.getValue();
				}
			}
			//未找到所要查询的对象
			return null;
			
		//如果不是叶子节点
		}else {
			//如果key小于等于节点最左边的key，沿第一个子节点继续搜索
			if (key.compareTo(entries.get(0).getKey()) <= 0) {
				return children.get(0).get(key);
			//如果key大于节点最右边的key，沿最后一个子节点继续搜索
			}else if (key.compareTo(entries.get(entries.size()-1).getKey()) >= 0) {
				return children.get(children.size()-1).get(key);
			//否则沿比key大的前一个子节点继续搜索
			}else {
				for (int i = 0; i < entries.size(); i++) {
					if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i+1).getKey().compareTo(key) > 0) {
						return children.get(i).get(key);
					}
				}	
			}
		}
		
		return null;
	}
	
	public void insertOrUpdate(Comparable key, Object obj, BPTree tree){
		//如果是叶子节点
		if (isLeaf){
			//不需要分裂，直接插入或更新
			if (contains(key) || entries.size() < tree.getOrder()){
				insertOrUpdate(key, obj);
				if (parent != null) {
					//更新父节点
					parent.updateInsert(tree);
				}

			//需要分裂	
			}else {
				//分裂成左右两个节点
				Node left = new Node(true);
				Node right = new Node(true);
				//设置链接
				if (previous != null){
					previous.setNext(left);
					left.setPrevious(previous);
				}
				if (next != null) {
					next.setPrevious(right);
					right.setNext(next);
				}
				if (previous == null){
					tree.setHead(left);
				}

				left.setNext(right);
				right.setPrevious(left);
				previous = null;
				next = null;
				
				//左右两个节点关键字长度
				int leftSize = (tree.getOrder() + 1) / 2 + (tree.getOrder() + 1) % 2; 
				int rightSize = (tree.getOrder() + 1) / 2;
				//复制原节点关键字到分裂出来的新节点
				insertOrUpdate(key, obj);
				for (int i = 0; i < leftSize; i++){
					left.getEntries().add(entries.get(i));
				}
				for (int i = 0; i < rightSize; i++){
					right.getEntries().add(entries.get(leftSize + i));
				}
				
				//如果不是根节点
				if (parent != null) {
					//调整父子节点关系
					int index = parent.getChildren().indexOf(this);
					parent.getChildren().remove(this);
					left.setParent(parent);
					right.setParent(parent);
					parent.getChildren().add(index,left);
					parent.getChildren().add(index + 1, right);
					setEntries(null);
					setChildren(null);
					
					//父节点插入或更新关键字
					parent.updateInsert(tree);
					setParent(null);
				//如果是根节点	
				}else {
					isRoot = false;
					Node parent = new Node(false, true);
					tree.setRoot(parent);
					left.setParent(parent);
					right.setParent(parent);
					parent.getChildren().add(left);
					parent.getChildren().add(right);
					setEntries(null);
					setChildren(null);
					
					//更新根节点
					parent.updateInsert(tree);
				}

			}
			
		//如果不是叶子节点
		}else {
			//如果key小于等于节点最左边的key，沿第一个子节点继续搜索
			if (key.compareTo(entries.get(0).getKey()) <= 0) {
				children.get(0).insertOrUpdate(key, obj, tree);
			//如果key大于节点最右边的key，沿最后一个子节点继续搜索
			}else if (key.compareTo(entries.get(entries.size()-1).getKey()) >= 0) {
				children.get(children.size()-1).insertOrUpdate(key, obj, tree);
			//否则沿比key大的前一个子节点继续搜索
			}else {
				for (int i = 0; i < entries.size(); i++) {
					if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i+1).getKey().compareTo(key) > 0) {
						children.get(i).insertOrUpdate(key, obj, tree);
						break;
					}
				}	
			}
		}
	}
	
	/** 插入节点后中间节点的更新 */
	protected void updateInsert(BPTree tree){

		validate(this, tree);
		
		//如果子节点数超出阶数，则需要分裂该节点	
		if (children.size() > tree.getOrder()) {
			//分裂成左右两个节点
			Node left = new Node(false);
			Node right = new Node(false);
			//左右两个节点关键字长度
			int leftSize = (tree.getOrder() + 1) / 2 + (tree.getOrder() + 1) % 2;
			int rightSize = (tree.getOrder() + 1) / 2;
			//复制子节点到分裂出来的新节点，并更新关键字
			for (int i = 0; i < leftSize; i++){
				left.getChildren().add(children.get(i));
				left.getEntries().add(new SimpleEntry(children.get(i).getEntries().get(0).getKey(), null));
				children.get(i).setParent(left);
			}
			for (int i = 0; i < rightSize; i++){
				right.getChildren().add(children.get(leftSize + i));
				right.getEntries().add(new SimpleEntry(children.get(leftSize + i).getEntries().get(0).getKey(), null));
				children.get(leftSize + i).setParent(right);
			}
			
			//如果不是根节点
			if (parent != null) {
				//调整父子节点关系
				int index = parent.getChildren().indexOf(this);
				parent.getChildren().remove(this);
				left.setParent(parent);
				right.setParent(parent);
				parent.getChildren().add(index,left);
				parent.getChildren().add(index + 1, right);
				setEntries(null);
				setChildren(null);
				
				//父节点更新关键字
				parent.updateInsert(tree);
				setParent(null);
			//如果是根节点	
			}else {
				isRoot = false;
				Node parent = new Node(false, true);
				tree.setRoot(parent);
				left.setParent(parent);
				right.setParent(parent);
				parent.getChildren().add(left);
				parent.getChildren().add(right);
				setEntries(null);
				setChildren(null);
				
				//更新根节点
				parent.updateInsert(tree);
			}
		}
	}
	
	/** 调整节点关键字*/
	protected static void validate(Node node, BPTree tree) {
		
		// 如果关键字个数与子节点个数相同
		if (node.getEntries().size() == node.getChildren().size()) {
			for (int i = 0; i < node.getEntries().size(); i++) {
				Comparable key = node.getChildren().get(i).getEntries().get(0).getKey();
				if (node.getEntries().get(i).getKey().compareTo(key) != 0) {
					node.getEntries().remove(i);
					node.getEntries().add(i, new SimpleEntry(key, null));
					if(!node.isRoot()){
						validate(node.getParent(), tree);
					}
				}
			}
			// 如果子节点数不等于关键字个数但仍大于M / 2并且小于M，并且大于2
		} else if (node.isRoot() && node.getChildren().size() >= 2 
				||node.getChildren().size() >= tree.getOrder() / 2 
				&& node.getChildren().size() <= tree.getOrder()
				&& node.getChildren().size() >= 2) {
			node.getEntries().clear();
			for (int i = 0; i < node.getChildren().size(); i++) {
				Comparable key = node.getChildren().get(i).getEntries().get(0).getKey();
				node.getEntries().add(new SimpleEntry(key, null));
				if (!node.isRoot()) {
					validate(node.getParent(), tree);
				}
			}
		}
	}
	
	/** 删除节点后中间节点的更新*/
	protected void updateRemove(BPTree tree) {
		
		validate(this, tree);

		// 如果子节点数小于M / 2或者小于2，则需要合并节点
		if (children.size() < tree.getOrder() / 2 || children.size() < 2) {
			if (isRoot) {
				// 如果是根节点并且子节点数大于等于2，OK
				if (children.size() >= 2) {
					return;
				// 否则与子节点合并
				} else {
					Node root = children.get(0);
					tree.setRoot(root);
					root.setParent(null);
					root.setRoot(true);
					setEntries(null);
					setChildren(null);
				}
			} else {
				//计算前后节点 
				int currIdx = parent.getChildren().indexOf(this);
				int prevIdx = currIdx - 1;
				int nextIdx = currIdx + 1;
				Node previous = null, next = null;
				if (prevIdx >= 0) {
					previous = parent.getChildren().get(prevIdx);
				}
				if (nextIdx < parent.getChildren().size()) {
					next = parent.getChildren().get(nextIdx);
				}
				
				// 如果前节点子节点数大于M / 2并且大于2，则从其处借补
				if (previous != null 
						&& previous.getChildren().size() > tree.getOrder() / 2
						&& previous.getChildren().size() > 2) {
					//前叶子节点末尾节点添加到首位
					int idx = previous.getChildren().size() - 1;
					Node borrow = previous.getChildren().get(idx);
					previous.getChildren().remove(idx);
					borrow.setParent(this);
					children.add(0, borrow);
					validate(previous, tree);
					validate(this, tree);
					parent.updateRemove(tree);
					
				// 如果后节点子节点数大于M / 2并且大于2，则从其处借补
				} else if (next != null	
						&& next.getChildren().size() > tree.getOrder() / 2
						&& next.getChildren().size() > 2) {
					//后叶子节点首位添加到末尾
					Node borrow = next.getChildren().get(0);
					next.getChildren().remove(0);
					borrow.setParent(this);
					children.add(borrow);
					validate(next, tree);
					validate(this, tree);
					parent.updateRemove(tree);
					
				// 否则需要合并节点
				} else {
					// 同前面节点合并
					if (previous != null 
							&& (previous.getChildren().size() <= tree.getOrder() / 2 || previous.getChildren().size() <= 2)) {
						
						for (int i = previous.getChildren().size() - 1; i >= 0; i--) {
							Node child = previous.getChildren().get(i);
							children.add(0, child);
							child.setParent(this);
						}
						previous.setChildren(null);
						previous.setEntries(null);
						previous.setParent(null);
						parent.getChildren().remove(previous);
						validate(this, tree);
						parent.updateRemove(tree);
						
					// 同后面节点合并
					} else if (next != null	
							&& (next.getChildren().size() <= tree.getOrder() / 2 || next.getChildren().size() <= 2)) {

						for (int i = 0; i < next.getChildren().size(); i++) {
							Node child = next.getChildren().get(i);
							children.add(child);
							child.setParent(this);
						}
						next.setChildren(null);
						next.setEntries(null);
						next.setParent(null);
						parent.getChildren().remove(next);
						validate(this, tree);
						parent.updateRemove(tree);
					}
				}
			}
		}
	}
