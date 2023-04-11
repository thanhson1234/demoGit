import java.security.PublicKey;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.naming.spi.DirObjectFactory;
import javax.sound.midi.Soundbank;




public class Maneger {

	Student student = new Student();
	Scanner scanner = new Scanner(System.in);
	ArrayList<Student> students =  IOWirteVsRead.read();


	public String inputName(Scanner scanner) {
		boolean check = true;
		String result = null;
		while(check) {
			System.out.println("Nhập tên ");
			String name = scanner.nextLine();
			if (Validate.validateName(name)) {
				check = false;
				result = name;
			} else {
				System.out.println("nhập sai điều kiện");
			}
		}
		return result;
	}

	public Date inputDate(Scanner scanner) {
		boolean check = true;
		String result = null;
		Date date = null;
		while (check) {
			System.out.println("nhập ngày sinh ");
			String birday = scanner.nextLine();
			if (Validate.validateDate(birday)) {
				check = false;
				result = birday;
			} else {
				System.out.println("sai định dạng");
			}
		}
		if (!check) {
			DateFormat df = new SimpleDateFormat(Validate.dateFormart);
			try {
				date = df.parse(result);

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("lỗi");
			}
		}

		return date;
	}


	public String inputAdress(Scanner scanner) {
		boolean check1 = true;
		String result = null;
		while(check1) {
			System.out.println("Nhập đia chỉ ");
			String adress = scanner.nextLine();
			if (Validate.validateName(adress)) {
				check1 = false;
				result = adress;
			} else {
				System.out.println("nhập sai điều kiện");
			}

		}return result;

	}



	public int inputHeight( Scanner scanner) {
		boolean check = true;
		int result = 0;
		while (check) {
			System.out.println(" nhập chiều cao");
			String str = scanner.nextLine();
			if(Validate.validateHeight(str)) {
				check = false;
				result = Integer.parseInt(str);
			}
		}

		return result;

	}

	public Double inputWeight( Scanner scanner) {
		boolean check = true;
		Double result = 0.0;
		while (check) {
			System.out.println(" nhập cân nặng");
			String str = scanner.nextLine();
			if(Validate.validateHeight(str)) {
				check = false;
				result = Double.parseDouble(str);
			}
		}

		return result;

	}
	public String inputStudentCode(Scanner scanner) {
		boolean check = true;
		String result = null; 
		while (check) {
			System.out.println("nhập mã sinh viên");
			String studentCode = scanner.nextLine();
			if (Validate.valideateStudentCode(studentCode)) {
				check = false;
				result = studentCode;
			}else {
				System.out.println("sai định dạng mời nhập lại");
			}
		}
		return result;
	}
	public String inputSchool(Scanner scanner) {
		boolean check = true;
		String result = null;
		while(check) {
			System.out.println("nhập trường");
			String school = scanner.nextLine();
			if (Validate.validateName(school)) {
				check = false;
				result = school;
			} else {
				System.out.println("nhập sai điều kiện");
			}
		}
		return result;
	}
	public int inputYeahToScool ( Scanner scanner) {
		boolean check = true;
		int result = 0;
		while (check) {
			System.out.println(" nhập năm đi học");
			String str = scanner.nextLine();
			if(Validate.validateYeahToSchool(str)) {
				check = false;
				result = Integer.parseInt(str);
			}
		}
		return result;

	}

	public Double inputAvg( Scanner scanner) {
		boolean check = true;
		Double result = 0.0;
		while (check) {
			System.out.println(" nhập điểm trung bình");
			String str = scanner.nextLine();
			if(Validate.validateAvg(str)) {
				check = false;
				result = Double.parseDouble(str);
			}
		}

		return result;

	}

	public Student funtion() {


		String name = inputName(scanner);

		Date birday = inputDate(scanner);

		String adress = inputAdress(scanner);

		int height =inputHeight(scanner);

		Double weight =inputWeight(scanner);

		String studentCode = inputStudentCode(scanner);

		String school = inputSchool(scanner);

		int yeahToSchool = inputYeahToScool(scanner);

		Double avg = inputAvg(scanner);


		Object st = new Student(name,birday,adress,height,weight,studentCode,school,yeahToSchool,avg);
		return (Student) st;

	}
	public void show() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).toString());
		}
	}

	public void create() {
		Student student = funtion();
		int lastId = students.get(students.size() - 1).getId();
		student.setId(lastId+1);
		students.add(student);
		IOWirteVsRead.write(students);

	}
	public void delete() {
		System.out.println(" nhập id cần xóa");
		int id1 = scanner.nextInt();
		boolean check = false;
		for (int i = 0; i < students.size(); i++) {
			if(id1 == students.get(i).getId() ) {
				System.out.println("nhập Y để xóa sinh viên");
				String y = scanner.nextLine();
				if(y.equals("Y")) {
					students.remove(i);
					check = true;	
					break;
				}else {
					System.out.println();
				}
			}

		}
		if(!check) {
			System.out.println("id sinh viên không tồn tại");
		}else {
			System.out.println("đã xóa sinh viên có id " + id1);
			for (Student student : students) {
				if(student.getId()> id1) {
					student.setId(student.getId()-1);
					IOWirteVsRead.write(students);
				}
			}
		}

	}
	public void updae() {
		System.out.println("nhập id muốn sửa");
		int id2 = scanner.nextInt();
		for (int i = 0; i < students.size(); i++) {
			if(id2 == students.get(i).getId() ) {
				students.set(i, funtion());
				IOWirteVsRead.write(students);
			}

		}

	}

	public void Arrange() {
		Map<Enum<Rank>, Integer> countMap = new HashMap<Enum<Rank>, Integer>();
		for (Student student1 : students) {
			if(countMap.containsKey(student1.getAvg())== true) {
				countMap.put(student1.getRank(), countMap.get(student1.getRank())+1);
			}else {
				countMap.put(student1.getRank(), 1);
			}
		}
		List<Map.Entry<Enum<Rank>,Integer>> newMap = new ArrayList<>(countMap.entrySet()) ;
		Collections.sort(newMap, new Comparator<Map.Entry<Enum<Rank>, Integer>>() {

			@Override
			public int compare(Entry<Enum<Rank>, Integer> o1, Entry<Enum<Rank>, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}
		});
		for (Map.Entry<Enum<Rank>, Integer> entry : newMap) {
			Enum<Rank> key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println("key " + key + "-------" + "value "  + 100*(double)val/(double)students.size() );

		}

	}


	public void dtb() {	

		Map< Double, Integer > countmap = new HashMap<Double, Integer>();
		for (Student sv : students) {
			if(countmap.containsKey(sv.getAvg())==true) {
				countmap.put(sv.getAvg(), countmap.get(sv.getAvg())+1);
			}else {
				countmap.put(sv.getAvg(),1);
			}

		}

		for (Map.Entry<Double, Integer> entry : countmap.entrySet()) {
			Double key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println("key  " + key + " ==== "  + "val  " + (100* (double)val/(double)students.size())+ " %");

		}

	}

	public void search() {
		System.out.println("nhập học lực bạn muốn tìm");
		String hl = scanner.nextLine();
		for (int i = 0; i < students.size(); i++) {
			if(hl.equals(students.get(i).getRank())) {
				System.out.println(students.get(i).getRank().toString());
			}
		}
	}

	public void DocFine(){
		students = IOWirteVsRead.read();
		System.out.println("đã dọc thành công");
	}


	public void Vietfine(){
		IOWirteVsRead.write(students);
		System.out.println("đã viết thành công");
	}


}
