package com.pegasAgro.carPark.nmea;

import net.sf.marineapi.nmea.event.AbstractSentenceListener;
import net.sf.marineapi.nmea.sentence.GGASentence;
import net.sf.marineapi.nmea.util.Position;

public class GGAListener extends AbstractSentenceListener<GGASentence> {
    private Position prevPos = null;
    private double distance = 0d;

    public GGAListener (double d, Position pos) {
        this.distance = d;
        this.prevPos = pos;
    }

    public void sentenceRead(GGASentence gga) {
        Position pos = gga.getPosition();
        if (prevPos != null) {
            distance += pos.distanceTo(prevPos);
            prevPos = pos;
            System.out.println("S: " + distance );
        } else {
            prevPos = pos;
        }
    }
}