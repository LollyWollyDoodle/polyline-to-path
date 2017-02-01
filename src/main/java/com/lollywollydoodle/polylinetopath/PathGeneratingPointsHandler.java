package com.lollywollydoodle.polylinetopath;

import org.apache.batik.parser.DefaultPointsHandler;
import org.apache.batik.parser.ParseException;

public class PathGeneratingPointsHandler extends DefaultPointsHandler {
	private StringBuilder pathD;

	public PathGeneratingPointsHandler() {
		super();
		this.pathD = null;
	}
	
	@Override
	public void startPoints() throws ParseException {
		this.pathD = new StringBuilder();
	}
	
	@Override
	public void point(float x, float y) throws ParseException {
		if (this.pathD.length() == 0) {
			this.pathD.append("M ").append(x).append(" ").append(y).append(" ");
		}
		else {
			this.pathD.append("L ").append(x).append(" ").append(y).append(" ");
		}
	}
	
	@Override
	public void endPoints() throws ParseException {
		this.pathD.append("Z");
    }
	
	public CharSequence getPathData() {
		if (this.pathD == null) {
			throw new IllegalStateException("No path data present");
		}
		
		return this.pathD;
	}
}
