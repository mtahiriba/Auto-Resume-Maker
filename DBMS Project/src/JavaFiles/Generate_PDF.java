package JavaFiles;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Generate_PDF {

	String path;
	String accountEmail;
	String jobTitle;
	String perEmail;
	Statement stmt;
	String date;
	
	Generate_PDF(String path,String accountEmail, String jobTitle, String perEmail, String date)
	{
		this.path = path;
		this.accountEmail = accountEmail;
		this.jobTitle = jobTitle;
		this.perEmail = perEmail;
		this.date = date;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resumebuilder", "root", "root");
			stmt= con.createStatement();
			System.out.println("Connection Seccessfully");
		}
		catch(Exception e)
		{
			System.out.println("Connection error");
		}
		
	}
	
	public static void main(String[] args) throws IOException, DocumentException {
		// TODO Auto-generated method stub

		Generate_PDF file = new Generate_PDF("E:\\file.pdf","mtm75474@gmail.com", "Computer Scientist", "mtm75474@gmail.com", "03/02/2019");
		file.createPdf();
	}

	
	public void createPdf() throws IOException, DocumentException {
		
		String[] personalinfo = new String[10];
		
		String select = "select * from personalinfo where accountEmail = '"+ accountEmail +"' and Email = '"+ perEmail +"'";
		ResultSet rs;
		try 
		{
			rs = stmt.executeQuery(select);
			while(rs.next())
			{
				personalinfo[0] = rs.getString(1);
				personalinfo[1] = rs.getString(2);
				personalinfo[2] = rs.getString(3);
				personalinfo[3] = rs.getString(4);
				personalinfo[4] = rs.getString(5);
				personalinfo[5] = rs.getString(6);
				personalinfo[6] = rs.getString(7);
				personalinfo[7] = rs.getString(8);
				personalinfo[8] = rs.getString(9);
				personalinfo[9] = rs.getString(10);
				//System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String selectskills = "select skills from skills where accountEmail = '"+ accountEmail +"' and Email = '"+ perEmail +"'";
		String[] skillsdata = new String[4];
		try 
		{
			rs = stmt.executeQuery(selectskills);
			while(rs.next())
			{
				skillsdata = rs.getString(1).split(" ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String[] workdata = new String[5];
		
		String selectwork = "select * from exprience where Email = '"+ accountEmail +"' and JobTitle = '"+ jobTitle +"'";
		try 
		{
			rs = stmt.executeQuery(selectwork);
			while(rs.next())
			{
				workdata[0] = rs.getString(1);
				workdata[1] = rs.getString(2);
				workdata[2] = rs.getString(3);
				workdata[3] = rs.getString(4);
				workdata[4] = rs.getString(8);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String selecteducation = "select * from education where Email = '"+ accountEmail +"' and StartDate = '"+ date +"'";
		String[] educationdata = new String[4];
		try 
		{
			rs = stmt.executeQuery(selecteducation);
			while(rs.next())
			{
				educationdata[0] = rs.getString(1);
				educationdata[1] = rs.getString(2);
				educationdata[2] = rs.getString(3);
				educationdata[3] = rs.getString(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        
        Font black = new Font(FontFamily.HELVETICA, 30, Font.BOLD, BaseColor.BLACK);
        Chunk blackText = new Chunk(personalinfo[0] + " " + personalinfo[1], black);
        Paragraph title = new Paragraph(blackText);
        title.setIndentationLeft(95);
        document.add(title);
        
        
        
        PdfContentByte canvas = writer.getDirectContent();
        Rectangle rect = new Rectangle(0, 0, 110, 900);
        rect.setBackgroundColor(BaseColor.BLACK);
        rect.setBorder(Rectangle.BOX);
        rect.setBorderWidth(2);
        canvas.rectangle(rect);
        	
        
        
        Font white = new Font(FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.BLACK);
        Chunk whiteText = new Chunk(personalinfo[2], white);
        Paragraph profession = new Paragraph(whiteText);
        profession.setIndentationLeft(95);
        document.add(profession);
        
        Image emailpic = Image.getInstance("email.png");
        emailpic.setIndentationLeft(95);
        emailpic.setAbsolutePosition(130,620);
        document.add(emailpic);
        
        Image phonepic = Image.getInstance("phone.png");
        phonepic.setIndentationLeft(95);
        phonepic.setAbsolutePosition(130,658);
        document.add(phonepic);
        
        Image locationpic = Image.getInstance("location.png");
        locationpic.setIndentationLeft(95);
        locationpic.setAbsolutePosition(130,695);
        document.add(locationpic);
        
        Font location = new Font(FontFamily.HELVETICA, 12, Font.ITALIC, BaseColor.BLACK);
        Chunk locationText = new Chunk("\n"+ personalinfo[3] +", "+ personalinfo[4] +", "+ personalinfo[8], location);
        Paragraph locationpara = new Paragraph(locationText);
        locationpara.setIndentationLeft(130);
        document.add(locationpara);
        
        
        Font phone = new Font(FontFamily.HELVETICA, 12, Font.ITALIC, BaseColor.BLACK);
        Chunk phoneText = new Chunk("\n" + personalinfo[5], phone);
        Paragraph phonepara = new Paragraph(phoneText);
        phonepara.setIndentationLeft(130);
        document.add(phonepara);
        
        
        Font email = new Font(FontFamily.HELVETICA, 12, Font.ITALIC, BaseColor.BLACK);
        Chunk emailText = new Chunk("\n" + personalinfo[6], email);
        Paragraph emailpara = new Paragraph(emailText);
        emailpara.setIndentationLeft(130);
        document.add(emailpara);
        
        
        Font summary = new Font(FontFamily.HELVETICA, 12, Font.ITALIC, BaseColor.BLACK);
        Chunk summaryText = new Chunk("\n" + personalinfo[9], summary);
        Paragraph summarypara = new Paragraph(summaryText);
        summarypara.setIndentationLeft(95);
        document.add(summarypara);
        
        Image skillspic = Image.getInstance("skills.png");
        skillspic.setIndentationLeft(95);
        skillspic.setAbsolutePosition(130,480);
        document.add(skillspic);
        
        Font skills = new Font(FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
        Chunk skillsText = new Chunk("\nSKILLS", skills);
        Paragraph skillspara = new Paragraph(skillsText);
        skillspara.setIndentationLeft(145);
        document.add(skillspara);
        
        Font skill1 = new Font(FontFamily.HELVETICA, 11, Font.ITALIC, BaseColor.BLACK);
        Chunk skill1Text = new Chunk(skillsdata[0], skill1);
        Paragraph skill1para = new Paragraph(skill1Text);
        skill1para.setIndentationLeft(145);
        document.add(skill1para);

        Font skill2 = new Font(FontFamily.HELVETICA, 11, Font.ITALIC, BaseColor.BLACK);
        Chunk skill2Text = new Chunk(skillsdata[1], skill2);
        Paragraph skill2para = new Paragraph(skill2Text);
        skill2para.setIndentationLeft(145);
        document.add(skill2para);

        Font skill3 = new Font(FontFamily.HELVETICA, 11, Font.ITALIC, BaseColor.BLACK);
        Chunk skill3Text = new Chunk(skillsdata[2], skill3);
        Paragraph skill3para = new Paragraph(skill3Text);
        skill3para.setIndentationLeft(145);
        document.add(skill3para);

        Font skill4 = new Font(FontFamily.HELVETICA, 11, Font.ITALIC, BaseColor.BLACK);
        Chunk skill4Text = new Chunk(skillsdata[3], skill4);
        Paragraph skill4para = new Paragraph(skill4Text);
        skill4para.setIndentationLeft(145);
        document.add(skill4para);

        
        Image workpic = Image.getInstance("work.png");
        workpic.setIndentationLeft(95);
        workpic.setAbsolutePosition(130,366);
        document.add(workpic);
        
        Font work = new Font(FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
        Chunk workText = new Chunk("\nWORK HISTORY", work);
        Paragraph workpara = new Paragraph(workText);
        workpara.setIndentationLeft(145);
        document.add(workpara);
        
        Font job = new Font(FontFamily.HELVETICA, 14, Font.ITALIC, BaseColor.BLACK);
        Chunk jobText = new Chunk("\n" + workdata[0], job);
        Paragraph jobpara = new Paragraph(jobText);
        jobpara.setIndentationLeft(145);
        document.add(jobpara);
        
        Font jobaddress = new Font(FontFamily.HELVETICA, 11, Font.ITALIC, BaseColor.BLACK);
        Chunk jobaddressText = new Chunk(workdata[1]+", "+ workdata[2] +", " + workdata[3], jobaddress);
        Paragraph jobaddresspara = new Paragraph(jobaddressText);
        jobaddresspara.setIndentationLeft(145);
        document.add(jobaddresspara);
        
        Font workdis = new Font(FontFamily.HELVETICA, 12, Font.ITALIC, BaseColor.BLACK);
        Chunk workdisText = new Chunk("\n" + workdata[4], workdis);
        Paragraph workdispara = new Paragraph(workdisText);
        workdispara.setIndentationLeft(145);
        document.add(workdispara);
        
        
        Image educationpic = Image.getInstance("education.png");
        educationpic.setIndentationLeft(95);
        educationpic.setAbsolutePosition(130,150);
        document.add(educationpic);
        
        Font education = new Font(FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
        Chunk educationText = new Chunk("\nEDUCATION", education);
        Paragraph educationpara = new Paragraph(educationText);
        educationpara.setIndentationLeft(145);
        document.add(educationpara);
        
        Font degree = new Font(FontFamily.HELVETICA, 14, Font.ITALIC, BaseColor.BLACK);
        Chunk degreeText = new Chunk("\n"+ educationdata[2] +": "+ educationdata[3], degree);
        Paragraph degreepara = new Paragraph(degreeText);
        degreepara.setIndentationLeft(145);
        document.add(degreepara);
        
        Font degreeaddress = new Font(FontFamily.HELVETICA, 11, Font.ITALIC, BaseColor.BLACK);
        Chunk degreeaddressText = new Chunk(educationdata[0] + " - " + educationdata[2], degreeaddress);
        Paragraph degreeaddresspara = new Paragraph(degreeaddressText);
        degreeaddresspara.setIndentationLeft(145);
        document.add(degreeaddresspara);
        
        
        document.close();
        
        File file = new File(path);
        Desktop.getDesktop().open(file);
    }
	
	
	
}
