package com.pegasAgro.carPark.nmea;

import net.sf.marineapi.nmea.event.SentenceEvent;
import net.sf.marineapi.nmea.event.SentenceListener;
import net.sf.marineapi.nmea.io.SentenceReader;
import net.sf.marineapi.nmea.sentence.GGASentence;
import net.sf.marineapi.nmea.sentence.SentenceId;
import net.sf.marineapi.nmea.util.Position;

import com.pegasAgro.carPark.helpers.ICallback;

import java.io.IOException;
import java.io.InputStream;

public class NmeaParser implements SentenceListener {
	private static SentenceReader reader;
    private static Position prevPos = null;
    private static double distance = 0d;

	public NmeaParser (InputStream stream) throws IOException {
		reader = new SentenceReader(stream);

		reader.addSentenceListener(this, SentenceId.GGA);
		reader.start();
	}

    public void readingPaused() {
		System.out.println("-- Paused --");
		System.out.println(distance);
	}

	public void readingStarted() {
		System.out.println("-- Started --");
	}

	public void readingStopped() {
		System.out.println("-- Stopped --");
	}

	public void sentenceRead(SentenceEvent event) {

		GGASentence s = (GGASentence) event.getSentence();

		if (prevPos != null) {
            Position pos = s.getPosition();
            distance += pos.distanceTo(prevPos);
            prevPos = pos;
            System.out.println("S: " + distance );
        } else {
            prevPos = s.getPosition();
        }
	}

    public static double calculateDistance (InputStream stream) {
        distance = 0d;
        prevPos = null;
        reader = null;
        try {
            new NmeaParser(stream);
            return distance;
		} catch (IOException e) {
			e.printStackTrace();
            return -1d;
		} 
    } 
}