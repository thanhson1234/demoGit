import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person{
	private String studentCode;
	private String school	;
	private int yearToSchool;
	private double avg;
	private Rank rank;



	public Student() {

	}
	

	public Student(String name, Date birday, String address, int height, double weight,String studentCode, String school, int yearToSchool, double avg) {
		super(name, birday, address, height, weight);
		this.studentCode = studentCode;
		this.school = school;
		this.yearToSchool = yearToSchool;
		this.avg = avg;
		setGpa();
	
	}
	



	public String getStudentCode() {
		return studentCode;
	}


	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public int getYearToSchool() {
		return yearToSchool;
	}


	public void setYearToSchool(int yearToSchool) {
		this.yearToSchool = yearToSchool;
	}


	public double getAvg() {
		return avg;
	}


	public void setAvg(double avg) {
		this.avg = avg;
	}



	public Rank getRank() {
		return rank;
	}


	public void setRank(Rank rank) {
		this.rank = rank;
	}


	private void setGpa() {
		if (avg < 3) {
			rank = rank.Kem;
		} else if (avg < 5) {
			rank = rank.Yeu;
		} else if (avg < 6.5) {
			rank = rank.Trung_Binh;
		} else if (avg < 7.5) {
			rank = rank.Kha;
		} else if (avg < 9) {
			rank = rank.Gioi;
		} else {
			rank = rank.Xuat_Sac;
		}
	}
	

	
	public String conVerDateToString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(getBirday());
	}
	


	@Override
	public String toString() {
		return ", getId()=" + getId() + ", getName()="
				+ getName() + ", getBirday()=" + conVerDateToString() + ", getAddress()=" + getAddress() + ", getHeight()="
				+ getHeight() + ", getKg()=" + getWeight()  + "MaSinhVien=" + studentCode+ ", School=" + school + ", YeahToSchool=" + yearToSchool
				+ ", diemTrungBinh=" + avg + ", hocLuc=" + rank ;
	}





	}








