import gui.GUISimulator;
import java.awt.Dimension;



/**
*<b> This class TestBallsSimulator is used to test our previous classes. <\b>

*/

public class TestBallsSimulator{
  public static void main (String[] args){
    Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int height = (int)dimension.getHeight() - 90;
    int width  = (int)dimension.getWidth() - 20;
    BallsSimulator ballsSimulator = new BallsSimulator(20, width, height);
    GUISimulator gui = ballsSimulator.getGui();
    gui.setSimulable(ballsSimulator);
  }
}
