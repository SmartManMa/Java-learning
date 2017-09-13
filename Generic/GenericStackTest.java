import java.util.Arrays;

class GenericStack<E>{
	private int top = 0;
	//ջ��ָ��
	private int initSize = 10;
	//���ܴ�����������new E[initSize]
	private E[] stackArr = (E[])new Object[initSize];

	private void expandStack(int newLength) {
		stackArr = Arrays.copyOf(stackArr,newLength);
	};

	//��ջ
	public void push(E element) {
		if(top>stackArr.length-1) {
			expandStack(stackArr.length*2);
			//E[] temp = (E[])new Object[stackArr.length * 2];
			//System.arraycopy(stackArr, 0, temp, 0, stackArr.length);
			//stackArr = temp;
		}
		stackArr[top++] = element;
	}
	//��ջ
	public E pop() {
		if(top<0) {
			System.exit(0);
			return null;
		}
		E element = stackArr[--top];
		return element;
	}
}

public class GenericStackTest
{   public static void main(String[] args) {
		GenericStack<Integer> stack = new GenericStack<Integer>();
		for(int i=0; i<18; i++) {
			stack.push(i);
		}
		for(int i=0; i<18; i++) {
			System.out.println(stack.pop());
		}
	}
}
