package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //Read the Configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Create SessionFactory Object from Configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Create new Session
        Session session = sessionFactory.openSession();

        //Declare transaction Object
        Transaction tx = null;

        Employee[] employeeArray = new Employee[10];
        Skill skillArray[] = new Skill[6];


        //reading data from Exam_info.xlsx
        String filePath ="C:\Users\adhik\Downloads\HibernateExamAug1124\HibernateExamAug1124\src\main\resources\Exam_info.xlsx";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet employeeSheet = workbook.getSheetAt(0);
            Sheet employeeSkillSheet = workbook.getSheetAt(2);

            //Reading Employee data from Excel and save to employeeArray
            Iterator<Row> employeeIterator = employeeSheet.iterator();
            int empIndex = 0;
            while (employeeIterator.hasNext()) {
                Row row = employeeIterator.next();
                if (row.getRowNum() == 0) {
                    continue;//skipping header row
                }
                Employee emp = new Employee();
                emp.setEmployeeId((int) row.getCell(0).getNumericCellValue());
                emp.setEmployeeName(row.getCell(1).getStringCellValue());
                emp.setEmployeeAddress(row.getCell(2).getStringCellValue());
                emp.setEmployeeEmail(row.getCell(3).getStringCellValue());
                emp.setEmployeeExperience((int) row.getCell(4).getNumericCellValue());
                employeeArray[empIndex++] = emp;
            }

            //rading skill data from excel  and save to skillArray
            Sheet skillSheet = workbook.getSheetAt(1);
            Iterator<Row> skillIterator = skillSheet.iterator();
            int skillIndex = 0;
            while (skillIterator.hasNext()) {
                Row row = skillIterator.next();
                if (row.getRowNum() == 0) {
                    continue;//skipping header
                }
                Skill skill = new Skill();
                skill.setSkillId((int) row.getCell(0).getNumericCellValue());
                skill.setSkillName(row.getCell(1).getStringCellValue());
                skillArray[skillIndex++] = skill;
            }

            tx = session.beginTransaction();

            //save employees
            for (Employee emp : employeeArray) {
                if (emp != null) {
                    session.persist(emp);
                }
                tx.commit();

            }
            for(Skill skill:skillArray){
                if(skill!=null){
                    session.persist(skill);
                }
                tx.commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
