package suanfa.redBlockTree;

/**
 * 图解
 * https://note.youdao.com/ynoteshare1/index.html?id=9b50b184f00f75af266fd53e334bb819&type=note
 *  * 红黑树原理讲解
 |---红黑树的性质
 |---红黑树有几种变化策略？（为满足红黑树性质）
 |---改变颜色
 |---左旋
 |---右旋
 |---红黑树的查找
 |---红黑树的插入
 |---情景1：红黑树为空树
 |---情景2：插入节点的key已经存在
 |---情景3：插入节点的父节点为黑色
 |---情景4：插入节点的父节点为红色
 |---情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
 |---情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
 |---情景4.2.1：插入节点为其父节点的左子节点（LL情况）
 |---情景4.2.2：插入节点为其父节点的右子节点（LR情况）
 |---情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
 |---情景4.3.1：插入节点为其父节点的右子节点（RR情况）
 |---情景4.3.2：插入节点为其父节点的左子节点（RL情况）

 ①创建RBTree，定义颜色
 ②创建RBNode
 ③辅助方法定义：parentOf(node)，isRed(node)，setRed(node)，setBlack(node)，inOrderPrint()
 ④左旋方法定义：leftRotate(node)
 ⑤右旋方法定义：rightRotate(node)
 ⑥公开插入接口方法定义：insert(K key, V value);
 ⑦内部插入接口方法定义：insert(RBNode node);
 ⑧修正插入导致红黑树失衡的方法定义：insertFIxUp(RBNode node);
 ⑨测试红黑树正确性
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable<K>,V> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private RBNode root;

	public RBNode getRoot() {
		return root;
	}

	public void setRoot(RBNode root) {
		this.root = root;
	}

	/**
	 * 获取当前节点的父节点
	 * @param node
	 * @return
	 */
	private RBNode parentOf(RBNode node){
		if(node != null)
			return node.parent;
		return null;
	}

	/**
	 * 节点是否为黑色
	 * @param node
	 * @return
	 */
	private boolean isBlack(RBNode node){
		if(node != null)
			return node.color == BLACK;
		return false;
	}

	/**
	 * 节点是否为红色
	 * @param node
	 * @return
	 */
	private boolean isRed(RBNode node){
		if(node != null)
			return node.color == RED;
		return false;
	}

	/**
	 * 设置节点为红色
	 * @param node
	 */
	private void setRed(RBNode node){
		if(node != null)
			node.color = RED;
	}

	/**
	 * 设置节点为 黑色
	 * @param node
	 */
	private void setBlack(RBNode node){
		if(node != null)
			node.color = BLACK;
	}

	/**
	 * 中序打印二叉树
	 */
	public void inOrderPrint(){
		inOrderPrint(this.root);
	}

	private void inOrderPrint(RBNode root){
		if(root != null){
			inOrderPrint(root.left);
			System.out.println("key:"+root.key+" value:"+root.value);
			inOrderPrint(root.right);
		}
	}

	/**
	 * 插入方法
	 * @param key
	 * @param value
	 */
	public void insert(K key,V value){
		RBNode node = new RBNode();
		node.setKey(key);
		node.setValue(value);
		//新节点一定是红色的
		node.setColor(RED);
		insert(node);
	}

	private void insert(RBNode node){
		//查找当前node的父节点
		RBNode parent = null;
		RBNode nodeParent = this.root;
		//循环root节点找到最底层节点和当前node节点对比
		while(nodeParent != null){
			parent = nodeParent;
			int cmp = node.key.compareTo(parent.key);
			if(cmp > 0){
				nodeParent = nodeParent.right;
			}else if(cmp == 0){
				nodeParent.setValue(node.value);
				return;
			}else{
				nodeParent = nodeParent.left;
			}
		}

		node.parent = parent;

		if(parent != null){
			//判断node与parent的key谁大
			int cmp = node.key.compareTo(parent.key);
			//如果node的key大于parent的key，把node放入parent的右子节点
			if(cmp > 0){
				parent.right = node;
			}else {
				parent.left = node;
			}
		}else{
			this.root = node;
		}

		insertFlxUp(node);
	}
	/**
	 |---红黑树的插入后修复红黑树平衡的方法
	 |---情景1：红黑树为空树，将根节点染色为黑色
	 |---情景2：插入节点的key已经存在，不需要处理
	 |---情景3：插入节点的父节点为黑色，因为所插入的路径，黑色节点没有变化，所以红黑树依然平衡，不需要处理
	 |---情景4：插入节点的父节点为红色
	 |---情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
	 |---情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
	 |---情景4.2.1：插入节点为其父节点的左子节点（LL情况）
	 |---情景4.2.2：插入节点为其父节点的右子节点（LR情况）
	 |---情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
	 |---情景4.3.1：插入节点为其父节点的右子节点（RR情况）
	 |---情景4.3.2：插入节点为其父节点的左子节点（RL情况）
	 * @param node
	 */
	private void insertFlxUp(RBNode node){
//		this.root.setColor(BLACK);

		RBNode parent = parentOf(node);
		RBNode gparent = parentOf(parent);

		//插入节点的父节点为红色
		if(parent !=null && isRed(parent)){
			//如果父节点是红色，一定存在父父节点，根节点不能是红色的
			if(parent == gparent.left){
				RBNode uncle = gparent.right;
				//4.1 叔叔节点存在在，且为红色  1.将父节点和叔叔节点设置为黑色，2.将父父节点设置为红色 3.重新进行修复
				if(uncle != null && isRed(uncle)){
					setBlack(parent);
					setBlack(uncle);
					setRed(gparent);
					insertFlxUp(gparent);
					return;
				}

				if(uncle ==null || isBlack(uncle)){
					if(node == parent.left){
						//4.2.1 插入节点为父节点的左子节点LL双红,1.将父节点染为黑色，2.将父父节点染为红色，3.然后以父父节点右旋
						setBlack(parent);
						setRed(gparent);
						rightRotate(gparent);
					}

					if(node == parent.right){
						//4.2.1 插入节点为父节点的右子节点LR双红,1.对父节点进行左旋 2.将原父节点设置为当前节点，得到LL红色情况，按照上面处理
						leftRotate(parent);
						insertFlxUp(parent);
						return;
					}
				}
			}else{
				RBNode uncle = gparent.left;
				//4.1 叔叔节点存在在，且为红色  1.将父节点和叔叔节点设置为黑色，2.将父父节点设置为红色 3.重新进行修复
				if(uncle != null && isRed(uncle)){
					setBlack(parent);
					setBlack(uncle);
					setRed(gparent);
					insertFlxUp(gparent);
					return;
				}
				if(uncle ==null || isBlack(uncle)){
					if(node == parent.right){
						//4.2.1 插入节点为父节点的右子节点RR双红,1.将父节点染为黑色，2.将父父节点染为红色，3.然后以父父节点左旋
						setBlack(parent);
						setRed(gparent);
						leftRotate(gparent);
					}

					if(node == parent.left){
						//4.2.1 插入节点为父节点的左子节点RL双红,1.对父节点进行右旋 2.将原父节点设置为当前节点，得到RR红色情况，按照上面处理
						rightRotate(parent);
						insertFlxUp(parent);
						return;
					}
				}
			}
		}
		setBlack(this.root);
	}

	/**
	 * 左旋节点
	 * @param node
	 */
	public void leftRotate(RBNode node){
		if(node != null){
			//将当前节点的右子节点取出
			RBNode right = node.right;
			//将当前节点的 右子节点 改为 原右子节点的左节点
			node.right = right.left;
			if(right.left != null){
				//将原右子节点的左节点 的父节点改为当前节点
				right.left.parent = node;
			}
			//当前节点父节点不为空，更新当前node的父节点为right的父节点，将当前节点的父节点指定为right
			if(node.parent != null){
				if(node == node.parent.left){
					node.parent.left = right;
				}
				else{
					node.parent.right = right;
				}
				//将当前节点的父节点改为 原右子节点的父节点
				right.parent = node.parent;
			}else{
				this.root = right;
				this.root.parent = null;
			}

			//将当前节点的父节点改为原右子节点
			node.parent = right;
			//将当前节点的右子节点改为 原右子节点的 左子节点
			right.left = node;
		}
	}
	/**
	 * 右旋节点
	 * @param node
	 */
	public void rightRotate(RBNode node){
		if(node != null){
			//将当前节点的左子节点取出
			RBNode left = node.left;
			//将当前节点的 左子节点 改为 原左子节点的右节点
			node.left = left.right;
			if(left.right != null){
				//将原左子节点的右节点 的父节点改为当前节点
				left.left.parent = node;
			}
			//将当前节点的父节点改为 原右子节点的父节点
			left.parent = node.parent;

			//当前节点父节点不为空，更新当前node的父节点改为left的父节点，将当前节点的父节点指定为left
			if(node.parent != null){
				if(node == node.parent.left)
					node.parent.left = left;
				else
					node.parent.right = left;
			}else{
				this.root = left;
				this.root.parent = null;
			}

			//将当前节点的父节点改为原左子节点
			node.parent = left;
			//将当前节点的左子节点改为 原左子节点的右左子节点
			left.right = node;
		}
	}

	static class RBNode<K extends Comparable<K>,V>{
		private RBNode parent;
		private RBNode left;
		private RBNode right;
		private boolean color;
		private K key;
		private V value;

		public RBNode(RBNode parent, RBNode left, RBNode right, boolean color,
					  K key, V value) {
			super();
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.color = color;
			this.key = key;
			this.value = value;
		}
		public RBNode(){}
		public RBNode getParent() {
			return parent;
		}
		public void setParent(RBNode parent) {
			this.parent = parent;
		}
		public RBNode getLeft() {
			return left;
		}
		public void setLeft(RBNode left) {
			this.left = left;
		}
		public RBNode getRight() {
			return right;
		}
		public void setRight(RBNode right) {
			this.right = right;
		}
		public boolean isColor() {
			return color;
		}
		public void setColor(boolean color) {
			this.color = color;
		}
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}

	}

	public static void main(String[] agrs){

		String s1 = "3";
		String s2 = "11";
		System.out.println(s1.compareTo(s2));

//		Scanner sc = new Scanner(System.in);
//		RBTree<String,Object> rbt = new RBTree();
//		while(true){
//			System.out.println("请输入key");
//			String key = sc.next();
//			rbt.insert(key, null);
//			TreeOperation.show(rbt.getRoot());
//		}
	}


}