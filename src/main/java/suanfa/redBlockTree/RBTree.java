package suanfa.redBlockTree;

/**
 * ͼ��
 * https://note.youdao.com/ynoteshare1/index.html?id=9b50b184f00f75af266fd53e334bb819&type=note
 *  * �����ԭ����
 |---�����������
 |---������м��ֱ仯���ԣ���Ϊ�����������ʣ�
 |---�ı���ɫ
 |---����
 |---����
 |---������Ĳ���
 |---������Ĳ���
 |---�龰1�������Ϊ����
 |---�龰2������ڵ��key�Ѿ�����
 |---�龰3������ڵ�ĸ��ڵ�Ϊ��ɫ
 |---�龰4������ڵ�ĸ��ڵ�Ϊ��ɫ
 |---�龰4.1������ڵ���ڣ�����Ϊ��ɫ����-�� ˫�죩
 |---�龰4.2������ڵ㲻���ڣ�����Ϊ��ɫ�����ڵ�Ϊүү�ڵ��������
 |---�龰4.2.1������ڵ�Ϊ�丸�ڵ�����ӽڵ㣨LL�����
 |---�龰4.2.2������ڵ�Ϊ�丸�ڵ�����ӽڵ㣨LR�����
 |---�龰4.3������ڵ㲻���ڣ�����Ϊ��ɫ�����ڵ�Ϊүү�ڵ��������
 |---�龰4.3.1������ڵ�Ϊ�丸�ڵ�����ӽڵ㣨RR�����
 |---�龰4.3.2������ڵ�Ϊ�丸�ڵ�����ӽڵ㣨RL�����

 �ٴ���RBTree��������ɫ
 �ڴ���RBNode
 �۸����������壺parentOf(node)��isRed(node)��setRed(node)��setBlack(node)��inOrderPrint()
 �������������壺leftRotate(node)
 �������������壺rightRotate(node)
 �޹�������ӿڷ������壺insert(K key, V value);
 ���ڲ�����ӿڷ������壺insert(RBNode node);
 ���������뵼�º����ʧ��ķ������壺insertFIxUp(RBNode node);
 ����Ժ������ȷ��
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
	 * ��ȡ��ǰ�ڵ�ĸ��ڵ�
	 * @param node
	 * @return
	 */
	private RBNode parentOf(RBNode node){
		if(node != null)
			return node.parent;
		return null;
	}

	/**
	 * �ڵ��Ƿ�Ϊ��ɫ
	 * @param node
	 * @return
	 */
	private boolean isBlack(RBNode node){
		if(node != null)
			return node.color == BLACK;
		return false;
	}

	/**
	 * �ڵ��Ƿ�Ϊ��ɫ
	 * @param node
	 * @return
	 */
	private boolean isRed(RBNode node){
		if(node != null)
			return node.color == RED;
		return false;
	}

	/**
	 * ���ýڵ�Ϊ��ɫ
	 * @param node
	 */
	private void setRed(RBNode node){
		if(node != null)
			node.color = RED;
	}

	/**
	 * ���ýڵ�Ϊ ��ɫ
	 * @param node
	 */
	private void setBlack(RBNode node){
		if(node != null)
			node.color = BLACK;
	}

	/**
	 * �����ӡ������
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
	 * ���뷽��
	 * @param key
	 * @param value
	 */
	public void insert(K key,V value){
		RBNode node = new RBNode();
		node.setKey(key);
		node.setValue(value);
		//�½ڵ�һ���Ǻ�ɫ��
		node.setColor(RED);
		insert(node);
	}

	private void insert(RBNode node){
		//���ҵ�ǰnode�ĸ��ڵ�
		RBNode parent = null;
		RBNode nodeParent = this.root;
		//ѭ��root�ڵ��ҵ���ײ�ڵ�͵�ǰnode�ڵ�Ա�
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
			//�ж�node��parent��key˭��
			int cmp = node.key.compareTo(parent.key);
			//���node��key����parent��key����node����parent�����ӽڵ�
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
	 |---������Ĳ�����޸������ƽ��ķ���
	 |---�龰1�������Ϊ�����������ڵ�ȾɫΪ��ɫ
	 |---�龰2������ڵ��key�Ѿ����ڣ�����Ҫ����
	 |---�龰3������ڵ�ĸ��ڵ�Ϊ��ɫ����Ϊ�������·������ɫ�ڵ�û�б仯�����Ժ������Ȼƽ�⣬����Ҫ����
	 |---�龰4������ڵ�ĸ��ڵ�Ϊ��ɫ
	 |---�龰4.1������ڵ���ڣ�����Ϊ��ɫ����-�� ˫�죩
	 |---�龰4.2������ڵ㲻���ڣ�����Ϊ��ɫ�����ڵ�Ϊүү�ڵ��������
	 |---�龰4.2.1������ڵ�Ϊ�丸�ڵ�����ӽڵ㣨LL�����
	 |---�龰4.2.2������ڵ�Ϊ�丸�ڵ�����ӽڵ㣨LR�����
	 |---�龰4.3������ڵ㲻���ڣ�����Ϊ��ɫ�����ڵ�Ϊүү�ڵ��������
	 |---�龰4.3.1������ڵ�Ϊ�丸�ڵ�����ӽڵ㣨RR�����
	 |---�龰4.3.2������ڵ�Ϊ�丸�ڵ�����ӽڵ㣨RL�����
	 * @param node
	 */
	private void insertFlxUp(RBNode node){
//		this.root.setColor(BLACK);

		RBNode parent = parentOf(node);
		RBNode gparent = parentOf(parent);

		//����ڵ�ĸ��ڵ�Ϊ��ɫ
		if(parent !=null && isRed(parent)){
			//������ڵ��Ǻ�ɫ��һ�����ڸ����ڵ㣬���ڵ㲻���Ǻ�ɫ��
			if(parent == gparent.left){
				RBNode uncle = gparent.right;
				//4.1 ����ڵ�����ڣ���Ϊ��ɫ  1.�����ڵ������ڵ�����Ϊ��ɫ��2.�������ڵ�����Ϊ��ɫ 3.���½����޸�
				if(uncle != null && isRed(uncle)){
					setBlack(parent);
					setBlack(uncle);
					setRed(gparent);
					insertFlxUp(gparent);
					return;
				}

				if(uncle ==null || isBlack(uncle)){
					if(node == parent.left){
						//4.2.1 ����ڵ�Ϊ���ڵ�����ӽڵ�LL˫��,1.�����ڵ�ȾΪ��ɫ��2.�������ڵ�ȾΪ��ɫ��3.Ȼ���Ը����ڵ�����
						setBlack(parent);
						setRed(gparent);
						rightRotate(gparent);
					}

					if(node == parent.right){
						//4.2.1 ����ڵ�Ϊ���ڵ�����ӽڵ�LR˫��,1.�Ը��ڵ�������� 2.��ԭ���ڵ�����Ϊ��ǰ�ڵ㣬�õ�LL��ɫ������������洦��
						leftRotate(parent);
						insertFlxUp(parent);
						return;
					}
				}
			}else{
				RBNode uncle = gparent.left;
				//4.1 ����ڵ�����ڣ���Ϊ��ɫ  1.�����ڵ������ڵ�����Ϊ��ɫ��2.�������ڵ�����Ϊ��ɫ 3.���½����޸�
				if(uncle != null && isRed(uncle)){
					setBlack(parent);
					setBlack(uncle);
					setRed(gparent);
					insertFlxUp(gparent);
					return;
				}
				if(uncle ==null || isBlack(uncle)){
					if(node == parent.right){
						//4.2.1 ����ڵ�Ϊ���ڵ�����ӽڵ�RR˫��,1.�����ڵ�ȾΪ��ɫ��2.�������ڵ�ȾΪ��ɫ��3.Ȼ���Ը����ڵ�����
						setBlack(parent);
						setRed(gparent);
						leftRotate(gparent);
					}

					if(node == parent.left){
						//4.2.1 ����ڵ�Ϊ���ڵ�����ӽڵ�RL˫��,1.�Ը��ڵ�������� 2.��ԭ���ڵ�����Ϊ��ǰ�ڵ㣬�õ�RR��ɫ������������洦��
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
	 * �����ڵ�
	 * @param node
	 */
	public void leftRotate(RBNode node){
		if(node != null){
			//����ǰ�ڵ�����ӽڵ�ȡ��
			RBNode right = node.right;
			//����ǰ�ڵ�� ���ӽڵ� ��Ϊ ԭ���ӽڵ����ڵ�
			node.right = right.left;
			if(right.left != null){
				//��ԭ���ӽڵ����ڵ� �ĸ��ڵ��Ϊ��ǰ�ڵ�
				right.left.parent = node;
			}
			//��ǰ�ڵ㸸�ڵ㲻Ϊ�գ����µ�ǰnode�ĸ��ڵ�Ϊright�ĸ��ڵ㣬����ǰ�ڵ�ĸ��ڵ�ָ��Ϊright
			if(node.parent != null){
				if(node == node.parent.left){
					node.parent.left = right;
				}
				else{
					node.parent.right = right;
				}
				//����ǰ�ڵ�ĸ��ڵ��Ϊ ԭ���ӽڵ�ĸ��ڵ�
				right.parent = node.parent;
			}else{
				this.root = right;
				this.root.parent = null;
			}

			//����ǰ�ڵ�ĸ��ڵ��Ϊԭ���ӽڵ�
			node.parent = right;
			//����ǰ�ڵ�����ӽڵ��Ϊ ԭ���ӽڵ�� ���ӽڵ�
			right.left = node;
		}
	}
	/**
	 * �����ڵ�
	 * @param node
	 */
	public void rightRotate(RBNode node){
		if(node != null){
			//����ǰ�ڵ�����ӽڵ�ȡ��
			RBNode left = node.left;
			//����ǰ�ڵ�� ���ӽڵ� ��Ϊ ԭ���ӽڵ���ҽڵ�
			node.left = left.right;
			if(left.right != null){
				//��ԭ���ӽڵ���ҽڵ� �ĸ��ڵ��Ϊ��ǰ�ڵ�
				left.left.parent = node;
			}
			//����ǰ�ڵ�ĸ��ڵ��Ϊ ԭ���ӽڵ�ĸ��ڵ�
			left.parent = node.parent;

			//��ǰ�ڵ㸸�ڵ㲻Ϊ�գ����µ�ǰnode�ĸ��ڵ��Ϊleft�ĸ��ڵ㣬����ǰ�ڵ�ĸ��ڵ�ָ��Ϊleft
			if(node.parent != null){
				if(node == node.parent.left)
					node.parent.left = left;
				else
					node.parent.right = left;
			}else{
				this.root = left;
				this.root.parent = null;
			}

			//����ǰ�ڵ�ĸ��ڵ��Ϊԭ���ӽڵ�
			node.parent = left;
			//����ǰ�ڵ�����ӽڵ��Ϊ ԭ���ӽڵ�������ӽڵ�
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
//			System.out.println("������key");
//			String key = sc.next();
//			rbt.insert(key, null);
//			TreeOperation.show(rbt.getRoot());
//		}
	}


}