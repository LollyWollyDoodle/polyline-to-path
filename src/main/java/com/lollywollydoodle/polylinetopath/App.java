package com.lollywollydoodle.polylinetopath;

import org.apache.batik.parser.PointsParser;

import com.lollywollydoodle.polylinetopath.PathGeneratingPointsHandler;

public class App {
    public static void main(String[] args) {
    	PointsParser p = new PointsParser();
        PathGeneratingPointsHandler h = new PathGeneratingPointsHandler();
        p.setPointsHandler(h);
        
        p.parse(System.in, "UTF-8");
        System.out.println(h.getPathData());
    }
}
