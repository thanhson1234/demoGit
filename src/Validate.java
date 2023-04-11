

import java.lang.reflect.Array;
import java.net.UnixDomainSocketAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

public class Validate {


	public static final String NUMBER = "\\d+";
	public static String studentCode = "^(?=([a-z0-9])(?!.*\\1)){10}$";
	public static String dateFormart = "dd/MM/yyyy";



	public static boolean validateName(String name) {
		return name.length()<100 && !name.equals("");
	}

	public static boolean validateDate(String date) {
		DateFormat df = new SimpleDateFormat(dateFormart);
		df.setLenient(false);
		try {
			df.parse(date);
		} catch (Exception e) {
			return false;
		}
		int year = Integer.parseInt(date.substring(date.length() - 4));
		return year > 1900;
	}

	public static boolean validatAdress(String adress) {
		return adress.length()<100 ;
	}


	public static boolean validate( String data , String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);
		return matcher.matches();
	}	

	public static boolean validateHeight(String data) {

		if(validate(data, NUMBER)) {
			int number =Integer.parseInt(data);
			return number >= 50 && number <= 300;
		}

		return false;
	}

	public static boolean validateWeight(String data) {
		if(validate(data, NUMBER)) {
			Double number =Double.parseDouble(data);
			return number >= 5.0 && number <= 1000.0;
		}

		return false;
	}


	public static boolean valideateStudentCode(String data) {
		Maneger maneger = new Maneger();
		List<Student> students = maneger.students;
		boolean isduplicate = false;
		for (Student sv : students) {
			if(sv.getStudentCode().equals(data)) {
				isduplicate = true;
				break;
			}
		}
		return (data.length() == 10) && (!isduplicate);
	}
	public static boolean validateSchool(String data) {
		return data.length()<200 && !data.equals("");
	}

	public static boolean validateYeahToSchool(String data) {
		boolean check = false;
		if (validate(data, NUMBER)) {
			if(data == null && data.length() != 4) {
				check = true;
			}
			int number = Integer.parseInt(data);
			return number > 1990;
		}
		return false;

	}

	public static boolean validateAvg(String data) {

		if(validate(data, NUMBER)) {
			Double number =Double.parseDouble(data);
			return number >= 0.0 && number <= 10.0;
		}

		return false;
	}
}






