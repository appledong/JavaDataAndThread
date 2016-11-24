package com.dong.thread.deadLock;

import java.util.HashSet;
import java.util.Set;

/**
 * 协作对象之间造成的死锁
 * 
 * @author dong
 *
 */
public class TwoObjectLock {

	class Taxi {
		private final Dispatcher dispatcher;

		private Point location;
		private Point destination;

		public Taxi(Dispatcher dispatcher) {
			this.dispatcher = dispatcher;
		}

		public synchronized Point getLocation() {
			return location;
		}

		public synchronized void setLocation(Point locaPoint) {
			this.location = locaPoint;
			if (destination.compare(locaPoint)) {
				dispatcher.addToAvailable(this);
			}
		}
	}

	class Dispatcher {
		// private final Set<Taxi> taxis;
		private final Set<Taxi> availabletaxis;

		public Dispatcher() {
			// taxis = new HashSet<>();
			availabletaxis = new HashSet<>();
		}

		public synchronized void addToAvailable(Taxi taxi) {
			availabletaxis.add(taxi);
		}

		public synchronized Taxi gettaxi(Point des) {
			for (Taxi taxi : availabletaxis) {
				int distance = des.distance(taxi.getLocation());
				if (distance < 2) {
					return taxi;
				}
			}
			return null;
		}
	}

	class Point {

		public int distance(Point point) {
			return 0;
		}

		public boolean compare(Point point) {
			return false;
		}
	}
}
