package solution.oj_341_flatten_nest_list_iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

	/*
public class NestedIterator implements Iterator<Integer> {
	private List<Integer> elements = null;
	private int idx;
	
	public NestedIterator(List<NestedInteger> nestedList) {
		elements = new LinkedList<Integer>();
		idx = 0;
		traverse(nestedList, elements);
    }
	
	private void traverse(List<NestedInteger> nestedList, List<Integer> ele){
		if(null != nestedList && nestedList.size() > 0){
			for(NestedInteger ni: nestedList){
				if(ni.isInteger()){
					ele.add(ni.getInteger());
				} else{
					traverse(ni.getList(), ele);
				}
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		if(null != elements && idx < (elements.size()-1)) return true;
		return false;
	}

	@Override
	public Integer next() {
		return elements.get(idx);
	}
}
	 * 
	 * 上面代码是我一开始写的代码，用额外的一个List来保存所有的元素，测试时
	 * 报Memory Limit Exceeded，因为我是将所有元素全部展开，这样确实会占用
	 * 大量内存。discuss上给出了借用一个栈来保存当前临时变量，等到需要的时候
	 * 才进行展开操作，如下面代码。
	 * ——其实这种思路很常见，也就是我们经常说的“延迟加载”
	 * 
	 * 下面代码其实也可以用链表作为临时储存容器，可能会更简洁。
	 * 
	 */
	
	private Stack<NestedInteger> stack = new Stack();
	
	public NestedIterator(List<NestedInteger> nestedList) {
		if(null != nestedList){
			for(int i = nestedList.size() - 1; i >= 0; i--){
				stack.push(nestedList.get(i));
			}
		}
	}

	@Override
	public boolean hasNext() {
		while(!stack.isEmpty()){
			NestedInteger cur = stack.peek();
			if(cur.isInteger()){
				return true;
			}
			stack.pop();
			for(int i = cur.getList().size() - 1; i >= 0; i--){
				stack.push(cur.getList().get(i));
			}
		}
		return false;
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}
	
}
