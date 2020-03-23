package org.kpu.IHPARK_maven;

import java.util.Scanner;

import org.kpu.study.domain.StudentVO;
import org.kpu.study.persistence.MemberDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String name;
    	StudentVO student;
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println( "정 보 조 회" );
        System.out.println( "계정을 입력하세요. >> " );
        name = scan.next();
        
    	MemberDAO memDAO = new MemberDAO();
		student = memDAO.read(name);
		System.out.println( student );
		scan.close();
    }
}
