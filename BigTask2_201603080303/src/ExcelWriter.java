import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

/**
 * Created by rajeevkumarsingh on 22/12/17.
 */

public class ExcelWriter {

	private static List<Article> articles = new ArrayList<>();

	public ExcelWriter(Object[][] rowData, String[] columnNames,int rowNumSum) throws IOException, InvalidFormatException {
		for (int i = 0; i < rowNumSum; i++) {
			articles.add(new Article(
					rowData[i][0].toString(),
					rowData[i][1].toString(),
					rowData[i][2].toString(),
					rowData[i][3].toString(),
					rowData[i][4].toString(),
					rowData[i][5].toString(),
					rowData[i][6].toString(),
					rowData[i][7].toString()));
		}
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances for various things like DataFormat,
		 * Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way
		 */
//		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Article");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short) 14);

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Creating cells
		for (int i = 0; i < columnNames.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columnNames[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (Article article : articles) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(article.getAuthor());
			row.createCell(1).setCellValue(article.getTitle());
			row.createCell(2).setCellValue(article.getJournal());
			row.createCell(3).setCellValue(article.getBooktitle());
			row.createCell(4).setCellValue(article.getVolume());
			row.createCell(5).setCellValue(article.getNumber());
			row.createCell(6).setCellValue(article.getPages());
			row.createCell(7).setCellValue(article.getYear());
		}

		// Resize all columns to fit the content size
//		for (int i = 0; i < columnNames.length; i++) {
//			sheet.autoSizeColumn(i);
//		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("bibfile.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		workbook.close();
	}
}

class  Article {

	private String author;
	private String title;
	private String journal;
	private String booktitle;
	private String volume;
	private String number;
	private String pages;
	private String year;
	
	public Article(String author, String title, String journal, String booktitle, String volume, String number,
			String pages, String year) {
		// TODO Auto-generated constructor stub
		this.author = author;
		this.title = title;
		this.journal = journal;
		this.booktitle = booktitle;
		this.volume = volume;
		this.number = number;
		this.pages = pages;
		this.year = year;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}


}
