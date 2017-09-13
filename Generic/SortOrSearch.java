class SortOrSearch 
{	//���Ͷ��ֲ��ң����ֲ��һ�����������
	public static <E extends Comparable<E>> 
		int binarySearch(E[] list,E keyVaule) {
		int low = 0;
		int high = list.length-1;
		int mid = 0;
		while (low <= high) {
			mid = (low+high)/2;
			//ע������ķ�����Comparable�������࣬
			//���Ա�����list[mid].compareTo(keyVaule)>0��<0��==0��
			//������list[mid]>(<��==)(keyVaule)
			int flag = keyVaule.compareTo(list[mid]);
			if (flag>0) {
				low = mid + 1;
			} 
			if (flag<0) {
				high = mid - 1;
			}
			if (flag==0) {
				//break;
				return mid;
			}	
		}
		//if (list[mid].compareTo(keyVaule)==0) {
		//	return mid;
		//}else 
		//	return -1;
		return -1;
	}
	public static void main(String[] args) 
	{
		String[] arr= {"asd","bv","cf","der","eff","fgg","gg","hehe"};
		int index = SortOrSearch.<String>binarySearch(arr,"hehe");
		System.out.println(index+"");
	}
}
