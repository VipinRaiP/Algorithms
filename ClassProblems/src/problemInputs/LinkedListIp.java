package problemInputs;

import classProblems.LinkList;

public class LinkedListIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList l = new LinkList(23);
		l.addBegin(12);
		l.addBegin(34);
		l.addEnd(45);
		l.addBegin(54);
		l.addEnd(108);
		l.delBegin();
		l.addBegin(100);
		l.delEnd();
		l.addAfter(90,34);
		l.print();

	}

}
