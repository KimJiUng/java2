package Day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Day10_5_��������_����Ʈ���� { // c s

	
	public static void main(String[] args) { // m s
		
		// 1. ����Ʈ[��ü] ����
		ArrayList<Book> booklist = new ArrayList<>();
	// ����ƮŬ����<����Ʈ�ȿ� ������ Ŭ����>
		// <Ŭ����> : �ش� Ŭ������ ���� ��ü�� ����Ʈ�� ����
		// ���̴� ����[�⺻ : 10]
		
		while(true) { // ���ѷ��� [����x]
			Scanner scanner = new Scanner(System.in);
			System.out.println("1.��� 2.��� 3.���� 4.����");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				// 1. ���� �Է¹ޱ�
				System.out.println("������ : "); String ������ = scanner.next();
				System.out.println("���� : "); String ���� = scanner.next();
				
				// 2. ��üȭ [������ ������ ��� ����]
				Book book = new Book(������, ����);
				
				// 3. �迭����[������ ã�Ƽ�]
				booklist.add(book); // ����Ʈ�� ����
				// .add(��ü��) : ������ �ε����� �ڵ������� ��ü�� �߰�
				
				
				
			}
			else if(ch==2) {
				// 1.�迭[null ����] vs ����Ʈ
				System.out.println("������\t����");
				for(Book book : booklist) {
					System.out.println(book.get������()+"\t"+book.get����());
				}
			}
			else if(ch==3) {
				// 1.�迭[���� �Ŀ� �� �ε��� ����] vs ����Ʈ[�ڵ�]
				System.out.println("������ ���� : "); String ������ = scanner.next();
				for(Book temp : booklist) {
					if(temp.get������().equals(������)) {
						booklist.remove(temp);
						break; // ���� ���������� �ݺ��� Ż��
					}
				}
			}
			else if(ch==4) {
				System.out.println("������ ������ : "); String ������ = scanner.next();
				for(Book book : booklist) {
					if(book.get������().equals(������)) {
						System.out.println("���� �����̸� : "); String ���� = scanner.next();
						book.set����(����);
						break;
					}
				}
			}
			
		} // while end
		
		
		
		
		
	} // m e
	
	
	
} // c e
