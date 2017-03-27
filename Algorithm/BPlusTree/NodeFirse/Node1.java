
	public boolean remove(Comparable key, BPTree tree){
		//如果是叶子节点
		boolean foud = false;
		if (isLeaf){
			
			//如果不包含该关键字，则直接返回
			if (!contains(key)){
				return false;
			}
			
			//如果既是叶子节点又是跟节点，直接删除
			if (isRoot) {
				if(remove(key)){
					foud = true;
				}
			}else {
				//如果关键字数大于M / 2，直接删除
				if (entries.size() > tree.getOrder() / 2 && entries.size() > 2) {
					if(remove(key)){
						foud = true;
					}
				}else {
					//如果自身关键字数小于M / 2，并且前节点关键字数大于M / 2，则从其处借补
					if (previous != null 
							&& previous.getEntries().size() > tree.getOrder() / 2
							&& previous.getEntries().size() > 2
							&& previous.getParent() == parent) {
						int size = previous.getEntries().size();
						Entry<Comparable, Object> entry = previous.getEntries().get(size - 1);
						previous.getEntries().remove(entry);
						//添加到首位
						entries.add(0, entry);
						if(remove(key)){
							foud = true;
						}
					//如果自身关键字数小于M / 2，并且后节点关键字数大于M / 2，则从其处借补	
					}else if (next != null 
							&& next.getEntries().size() > tree.getOrder() / 2
							&& next.getEntries().size() > 2
							&& next.getParent() == parent) {
						Entry<Comparable, Object> entry = next.getEntries().get(0);
						next.getEntries().remove(entry);
						//添加到末尾
						entries.add(entry);
						if(remove(key)){
							foud = true;
						}
					//否则需要合并叶子节点	
					}else {
						//同前面节点合并
						if (previous != null 
								&& (previous.getEntries().size() <= tree.getOrder() / 2 || previous.getEntries().size() <= 2)
								&& previous.getParent() == parent) {
							for (int i = previous.getEntries().size() - 1; i >=0; i--) {
								//从末尾开始添加到首位
								entries.add(0, previous.getEntries().get(i));
							}
							if(remove(key)){
								foud = true;
							}
							previous.setParent(null);
							previous.setEntries(null);
							parent.getChildren().remove(previous);
							//更新链表
							if (previous.getPrevious() != null) {
								Node temp = previous;
								temp.getPrevious().setNext(this);
								previous = temp.getPrevious();
								temp.setPrevious(null);
								temp.setNext(null);							
							}else {
								tree.setHead(this);
								previous.setNext(null);
								previous = null;
							}
						//同后面节点合并	
						}else if(next != null 
								&& (next.getEntries().size() <= tree.getOrder() / 2 || next.getEntries().size() <= 2)
								&& next.getParent() == parent){
							for (int i = 0; i < next.getEntries().size(); i++) {
								//从首位开始添加到末尾
								entries.add(next.getEntries().get(i));
							}
							if(remove(key)){
								foud = true;
							}
							next.setParent(null);
							next.setEntries(null);
							parent.getChildren().remove(next);
							//更新链表
							if (next.getNext() != null) {
								Node temp = next;
								temp.getNext().setPrevious(this);
								next = temp.getNext();
								temp.setPrevious(null);
								temp.setNext(null);
							}else {
								next.setPrevious(null);
								next = null;
							}
						}
					}
				}
				parent.updateRemove(tree);
			}
		//如果不是叶子节点	
		}else {
			//如果key小于等于节点最左边的key，沿第一个子节点继续搜索
			if (key.compareTo(entries.get(0).getKey()) <= 0) {
				if(children.get(0).remove(key, tree)){
					foud = true;
				}
			//如果key大于节点最右边的key，沿最后一个子节点继续搜索
			}else if (key.compareTo(entries.get(entries.size()-1).getKey()) >= 0) {
				if(children.get(children.size()-1).remove(key, tree)){
					foud = true;
				}
			//否则沿比key大的前一个子节点继续搜索
			}else {
				for (int i = 0; i < entries.size(); i++) {
					if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i+1).getKey().compareTo(key) > 0) {
						if(children.get(i).remove(key, tree)){
							foud = true;
						}
					}
				}
			}
		}
		if(foud){
			return true;
		}else{
			return false;
		}
	}
	
	/** 判断当前节点是否包含该关键字*/
	protected boolean contains(Comparable key) {
		for (Entry<Comparable, Object> entry : entries) {
			if (entry.getKey().compareTo(key) == 0) {
				return true;
			}
		}
		return false;
	}
	
	/** 插入到当前节点的关键字中*/
	protected void insertOrUpdate(Comparable key, Object obj){
		Entry<Comparable, Object> entry = new SimpleEntry<Comparable, Object>(key, obj);
		//如果关键字列表长度为0，则直接插入
		if (entries.size() == 0) {
			entries.add(entry);
			return;
		}
		//否则遍历列表
		for (int i = 0; i < entries.size(); i++) {
			//如果该关键字键值已存在，则更新
			if (entries.get(i).getKey().compareTo(key) == 0) {
				entries.get(i).setValue(obj);
				return;
			//否则插入	
			}else if (entries.get(i).getKey().compareTo(key) > 0){
				//插入到链首
				if (i == 0) {
					entries.add(0, entry);
					return;
				//插入到中间
				}else {
					entries.add(i, entry);
					return;
				}
			}
		}
		//插入到末尾
		entries.add(entries.size(), entry);
	}
	
	/** 删除节点*/
	protected boolean remove(Comparable key){
		int index = -1;
		boolean foud = false;
		for (int i = 0; i < entries.size(); i++) {
			if (entries.get(i).getKey().compareTo(key) == 0) {
				index = i;
				foud = true;
				break;
			}
		}
		if (index != -1) {
			entries.remove(index);
		}
		if(foud){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Entry<Comparable, Object>> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry<Comparable, Object>> entries) {
		this.entries = entries;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("isRoot: ");
		sb.append(isRoot);
		sb.append(", ");
		sb.append("isLeaf: ");
		sb.append(isLeaf);
		sb.append(", ");
		sb.append("keys: ");
		for (Entry entry : entries){
			sb.append(entry.getKey());
			sb.append(", ");
		}
		sb.append(", ");
		return sb.toString();
		
	}

}
