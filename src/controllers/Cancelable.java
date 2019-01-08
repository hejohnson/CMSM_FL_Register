package controllers;

public interface Cancelable extends Runnable {
	public void run();
	public void cancel();
}
