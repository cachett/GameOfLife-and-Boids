import gui.GUISimulator;

public class TestMultiSimulator{
  public static void main (String[] args){

    MultiSimulator boidsSimulator = new MultiSimulator(1490, 850, 100, 50);
    GUISimulator gui = boidsSimulator.getGui();
    gui.setSimulable(boidsSimulator);
  }
}
