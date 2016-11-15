package guimodule;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class EarthquakeCityMap extends PApplet {

	private UnfoldingMap map;
	
	public void setup() 
	{
		size(800, 600, OPENGL); // set canvas size
		
		
		
		map = new UnfoldingMap(this, 200, 50, 550, 500, new Google.GoogleMapProvider());
		
		map.zoomToLevel(2);
		
		// chile 
		Location valLoc = new Location(-38.14f,-73.03f);
		Feature valEq = new PointFeature(valLoc);
		valEq.addProperty("title", "Valdivia, Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("data", "May 22, 1960");
		valEq.addProperty("year", 1960);
		
		// Alaska
		Location alaskaLoc = new Location(61.02f,-147.65f);
		Feature alaskaEq = new PointFeature(alaskaLoc);
		alaskaEq.addProperty("title", "1964 Great Alaska Earthquake");
		alaskaEq.addProperty("magnitude", "9.2");
		alaskaEq.addProperty("data", "March 03, 1964");
		alaskaEq.addProperty("year", 1964);
		
		// Sumatra
		Location sumatraLoc = new Location(3.30f, 95.78f);
		Feature sumatraEq = new PointFeature(sumatraLoc);
		sumatraEq.addProperty("title", "Northern Sumatra");
		sumatraEq.addProperty("magnitude", "9.1");
		sumatraEq.addProperty("data", "December 26, 2004");
		sumatraEq.addProperty("year", 2004);
		
		// Japan
		Location japanLoc = new Location(38.32f, 142.37f);
		Feature japanEq = new PointFeature(japanLoc);
		japanEq.addProperty("title", "Honshu, Japan");
		japanEq.addProperty("magnitude", "9.0");
		japanEq.addProperty("data", "March 11, 2011");
		japanEq.addProperty("year", 2011);
		
		// Kamchatka
		Location kamchatkaLoc = new Location(52.76f, 160.06f);
		Feature kamchatkaEq = new PointFeature(kamchatkaLoc);
		kamchatkaEq.addProperty("title", "Kamchatka");
		kamchatkaEq.addProperty("magnitude", "9.0");
		kamchatkaEq.addProperty("data", "November 04, 1952");
		kamchatkaEq.addProperty("year", 1952);
		
		// make a list of pointfeatures add in our quakes
	 	List<PointFeature> bigEqs = new ArrayList<PointFeature>();
		bigEqs.add((PointFeature)valEq);
		bigEqs.add((PointFeature)alaskaEq);
		bigEqs.add((PointFeature)sumatraEq);
		bigEqs.add((PointFeature)japanEq);
		bigEqs.add((PointFeature)kamchatkaEq);
		
		// actually add the marker to the map one at a time. Example used is Chile earthquake
		//SimplePointMarker valMk = new SimplePointMarker(valLoc, valEq.getProperties());
		//map.addMarker(valMk);
		
		List<Marker> markers = new ArrayList<Marker>();
		for (PointFeature eq: bigEqs) {
			markers.add(new SimplePointMarker(eq.getLocation(),
					eq.getProperties()));
		}
		map.addMarkers(markers);
		
		// define colors
		int yellow = color(255, 255, 0);
	//	int gray = color(150, 150, 150);
		int blue = color(0, 0, 255);
		
		for (Marker mk : markers) {
			if ( (int) mk.getProperty("year")  > 2000 ) {
				mk.setColor(yellow);
			 ((SimplePointMarker)   mk).setRadius((float) 10.0);
			} 
			else {
				mk.setColor(blue);
				((SimplePointMarker)   mk).setRadius((float) 5.0);
			}
		}
		
		
		MapUtils.createDefaultEventDispatcher(this,  map);
	}
	
	public void draw()
	{
		background(200);  //set canvas color
		map.draw();
		addKey();
	}

	private void addKey() {
		// TODO Auto-generated method stub
		
	}
}
