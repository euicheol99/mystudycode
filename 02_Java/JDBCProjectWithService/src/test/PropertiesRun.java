package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun {
	public static void main(String[] args) {
		// Properties

		/*
		 * Properties 특징 = Map 계열 컬렉션 (key-value 형식으로 저장함) setProperty (key, value)
		 * getProperty(key) : value
		 * 
		 * - 주로 외부파일 (.properties / .xml)을 사용해서 입출력할 때 보다 편하게 변환해주는 객체
		 */

		// 파일로 출력하는 것
		Properties prop = new Properties();
		prop.setProperty("C", "INSERT"); // 데이터 생성
		prop.setProperty("R", "SELECT"); // 데이터 읽기
		prop.setProperty("U", "UPDATE");
		prop.setProperty("D", "DELETE");

		try {
			prop.store(new FileOutputStream("resources/driver.properties"), "properties Test");
			prop.storeToXML(new FileOutputStream("resources/driver.properties"), "properties Test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}