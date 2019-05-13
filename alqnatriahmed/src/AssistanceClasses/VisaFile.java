package AssistanceClasses;

import java.io.File;

import interfaces.VisaFilesInterface;

public class VisaFile implements VisaFilesInterface {

	File visaFile;

	public VisaFile(File file) {
		this.visaFile = file;
	}

	@Override
	public long getSize() {
		return visaFile.length();
	}

}
