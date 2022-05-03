package com.dg3.forum.forum.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dg3.forum.forum.entity.Users;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "email", "password", "username", "role", "phone_number", "address", "date_of_birth",
			  "description", "expire"};

	public static boolean hasCSVFormat(MultipartFile file) {
		System.out.println(file.getContentType());
		if (TYPE.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel")) {
			return true;
		}

		return false;
	}

	public static List<Users> csvToTutorials(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Users> listUsers = new ArrayList<>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				@SuppressWarnings("deprecation")
				Users rowUser = new Users(csvRecord.get("email"),
						csvRecord.get("password"), 
						csvRecord.get("username"),
						csvRecord.get("role"), 
						csvRecord.get("phone_number"),
						csvRecord.get("address"),
						ConvertStringToDate.convertStringtoDate(csvRecord.get("date_of_birth")),
						false,
						"",
						csvRecord.get("description"),
						DateCurrent.getDateCurrent(),
						ConvertStringToDate.convertStringtoDate(csvRecord.get("expire")),
						true);

				listUsers.add(rowUser);
			}

			return listUsers;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	public static ByteArrayInputStream tutorialsToCSV(List<Users> listUsers) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			for (Users user : listUsers) {
				List<String> data = Arrays.asList(user.getEmail(), user.getPassword(), user.getUsername(),
						user.getRole(), user.getPhone_number(), user.getAddress(),
						String.valueOf(user.getDate_of_birth()), user.getDescription(),
						String.valueOf(user.getExpire()));

				csvPrinter.printRecord(data);
			}

			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}
}
