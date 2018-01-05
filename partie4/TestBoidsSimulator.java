import gui.GUISimulator;
import java.awt.Dimension;


public class TestBoidsSimulator{
  public static void main (String[] args){
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int height = (int)dimension.getHeight() - 30;
    int width  = (int)dimension.getWidth() - 20;
    BoidsSimulator boidsSimulator = new BoidsSimulator(width, height, 100);
    GUISimulator gui = boidsSimulator.getGui();
    gui.setSimulable(boidsSimulator);
  }
}
