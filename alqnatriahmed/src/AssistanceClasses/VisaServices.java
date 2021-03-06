package AssistanceClasses;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;

import com.x5.template.Chunk;
import com.x5.template.Theme;

import Classes.Data;
import Classes.User;
import Classes.VisaRequest;

/**
 * 
 * @author ahmed this class contains the necessary functions for this
 *         application.
 */
public class VisaServices {

	/**
	 * this function create folder for user's files
	 * 
	 * @param username
	 * @return true if creating operation was successfully done or throws run time
	 *         exception, in case we have a folder for the user it returns false
	 */

	public boolean createApplicationFolder(String username) throws VisaNewFolderApplicationException {
		Path path1 = Paths.get(System.getProperty("user.dir") + "\\" + username);
		if (!Files.exists(path1)) {
			try {
				Files.createDirectory(path1);
				return true;
			} catch (IOException e) {
				throw new RuntimeException("Unexpected Error");
			}
		} else {
			throw new VisaNewFolderApplicationException("Sorry You Have pending Appliction");
			// create new application folder for the same user ( next update )
		}
	}

	/**
	 * this function Save the prepared application to the Database
	 * 
	 * @param Username
	 * @param Country
	 * @param VisaType  (Job Visa , Study Accommodation)
	 * @param VisaFiles
	 * @return true if the the operation successfully done otherwise false.
	 */
	public boolean SaveVisaApplication(String Username, String Country, String VisaType,
			Map<String, String> visafiles) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		VisaRequest visarequest = new VisaRequest();
		visarequest.setVisaId(Data.visarequests.size());
		visarequest.setUserName(Username);
		visarequest.setToCountry(Country);
		visarequest.setVisaType(VisaType);
		visarequest.setApplyDate(dateFormat.format(date));
		visarequest.setVisaFiles(visafiles);
		if (Data.visarequests.add(visarequest))
			return true;
		else
			return false;

	}

	/**
	 * this function upload photo to a specific given path (in our case to @usernaem
	 * folder)
	 * 
	 * @param filepath  the path which the photo should upload in.
	 * @param imageType the image type.
	 * @param username
	 * @return boolean value : true in case successfully uploaded the
	 *         photo,otherwise throw run time exception
	 */
	public boolean uploadPicture(String Username, Map<String, String> VisaFilesPaths, Map<String, String> VisaFiles,
			BufferedImage bImage) {
		try {

			for (Map.Entry<String, String> entry : VisaFilesPaths.entrySet()) {
				File file = new File((String) entry.getValue());
				bImage = ImageIO.read(file);
				String extention = file.getName().substring(file.getName().lastIndexOf(".") + 1);
				String path = System.getProperty("user.dir") + "\\" + Username + "\\" + (String) entry.getKey() + "_"
						+ Username + "." + extention;
				ImageIO.write(bImage, extention, new File(path));
				VisaFiles.put((String) entry.getKey(), path);
			}
			return true;
		} catch (IOException e) {
			// throw exception when it's not possible to upload the image and delete the
			// uploaded files
			for (Map.Entry<String, String> data : VisaFilesPaths.entrySet()) {
				File dfile = new File((String) data.getValue());
				if (dfile.delete())
					;
			}
			return false;
		}
	}

	/**
	 * this function check the status of visa request using entered id
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean CheckVisaStatus(int id) {
		for (VisaRequest visarequest : Data.visarequests) {
			if (visarequest.getVisaId() == id)
				if (visarequest.getStatus() == true)
					return true;
		}
		return false;
	}

	/**
	 * this function check existence of visa request using entered id
	 * 
	 * @param id
	 * @return boolean
	 */

	public boolean CheckExistenceVisaId(int id) {
		for (VisaRequest visarequest : Data.visarequests) {
			if (visarequest.getVisaId() == id)
				return true;
		}
		return false;
	}

	/**
	 * this function get Visa Request by @username
	 * 
	 * @param username
	 * @return VisaRequest object
	 */
	public VisaRequest getVisaRequestByUserName(String username) {
		for (VisaRequest vr : Data.visarequests) {
			if (vr.getUserName().equalsIgnoreCase(username))
				return vr;
		}
		return null;
	}

	/**
	 * this function find user in arraylist of stored users
	 * 
	 * @param username
	 * @return User Object
	 */
	public User getUserByUsername(String username) {
		for (User user : Data.newusers) {
			if (user.getUserName().equalsIgnoreCase(username))
				return user;
		}
		return null;
	}

	public ArrayList<VisaFile> getvisaFilebyusername(String username) {
		ArrayList<VisaFile> visafiles = new ArrayList<VisaFile>();
		VisaFile temporaryfile = null;
		File visaFolder = new File(System.getProperty("user.dir") + "\\" + username);
		File[] listoffiles = visaFolder.listFiles();
		for (int i = 0; i < listoffiles.length; i++) {
			temporaryfile = new VisaFile(listoffiles[i]);
			visafiles.add(temporaryfile);
		}
		return visafiles;
	}

	/**
	 * this function create txt file using serialization
	 * 
	 * @param visarequset
	 * @throws IOException
	 */
	public void writeTemplatedFile(VisaRequest visarequset, String username) throws IOException {

		Theme theme = new Theme();
		Chunk chunk = theme.makeChunk("VisaTemplate", "txt");
		Path template = Paths.get(System.getProperty("user.dir") + "\\themes\\VisaTemplate.txt");

		// replace static values below with user input
		chunk.set("id", visarequset.getVisaId());
		chunk.set("name", visarequset.getFullName().getFirstName() + " " + visarequset.getFullName().getLastName());
		chunk.set("visatype", visarequset.getVisaType());
		if (visarequset.getStatus())
			chunk.set("status", "Waiting");
		else
			chunk.set("status", "Accepted");
		
		chunk.set("description", visarequset.getDescription());

		Path newfile = Paths.get(System.getProperty("user.dir") + "\\" + username + "\\" + username + ".txt");

		Files.copy(template, newfile);

		File file = new File(newfile.toString());

		FileWriter out = new FileWriter(file);

		chunk.render(out);

		out.flush();
		out.close();
	}
}
