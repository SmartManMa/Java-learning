class SortOrSearch 
{	//泛型二分查找，二分查找基于有序序列
	public static <E extends Comparable<E>> 
		int binarySearch(E[] list,E keyVaule) {
		int low = 0;
		int high = list.length-1;
		int mid = 0;
		while (low <= high) {
			mid = (low+high)/2;
			//注意这里的泛型是Comparable及其子类，
			//所以必须用list[mid].compareTo(keyVaule)>0（<0或==0）
			//不能用list[mid]>(<或==)(keyVaule)
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
