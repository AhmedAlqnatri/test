package AssistanceClasses;

import java.util.ArrayList;

import interfaces.VisaFilesInterface;

public class VisaFolder implements VisaFilesInterface {

	ArrayList<VisaFile> visafiles = new ArrayList<VisaFile>();

	public VisaFolder(ArrayList<VisaFile> visafiles) {
		this.visafiles = visafiles;
	}

	@Override
	public long getSize() {
		long size = 0;
		for (VisaFile visaFile : visafiles) {
			size += visaFile.getSize();
		}
		return size;
	}

}
