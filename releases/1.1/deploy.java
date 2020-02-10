import java.io.IOException;
import javax.swing.JOptionPane;


/**
 * Build with:
 * jar cmf deploy.mf deploy.jar deploy.class deploy.java
 * java -jar deploy.jar
 */
public class deploy
{
   /**
    * Main method that fires an external jar
    * @param args Derp :)
    */
   public static void main(String[] args)
   {
      try
      {
         Runtime.getRuntime().exec("java --module-path \"../../assets/javafx-sdk-13.0.2/lib\" --add-modules javafx.controls,javafx.fxml -jar RunnableFile.jar");
      }
      catch (IOException e)
      {
         JOptionPane.showMessageDialog(null, "Oh noes!");
      }
   }
}