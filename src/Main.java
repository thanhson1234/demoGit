import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Maneger maneger = new Maneger();
		while (true) {
			System.out.println("=============Menu==========");
			System.out.println("1.  Hiển thị danh sách sinh viên");
			System.out.println("2.  Thêm mới");
			System.out.println("3.  Cập nhật");
			System.out.println("4.  Xóa ");
			System.out.println("5.  Sắp xếp ");
			System.out.println("6.  Dùng map ");
			System.out.println("7.  Tìm kiếm học lực ");
			System.out.println("8.  Kết thúc trương trình");

			int next = 0;
			while (next < 1 || next > 8 ) {
				try {
					next = Integer.parseInt(scanner.nextLine());
					break;
				} catch (Exception e) {
					System.out.println(" sai định dạng mời nhập lại");

				}

			}
			switch ( next) {

			case 1: {
				maneger.show();
				break;
			}
			case 2: {
				maneger.create();
				break;
			}
			case 3: {
				maneger.updae();
				break;
			}
			case 4: {
				maneger.delete();;
				break;
			}
			case 5:{
				maneger.Arrange();
				break;
			}
			case 6:{
				maneger.dtb();
				break;
			}
			case 7:{
				maneger.search();
				break;

			}
			case 8:{
				System.out.println("kết thúc trương trình");
				return;
			}

			}

		}
	}
}




