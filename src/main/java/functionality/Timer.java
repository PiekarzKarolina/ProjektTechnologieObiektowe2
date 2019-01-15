package functionality;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Timer {

    private Timeline timeline;
    private long startTime;
    private DateFormat timeFormat = new SimpleDateFormat( "mm:ss" );


    public Timer(Label time){
        startTime = System.currentTimeMillis();
        timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(1),
                        event -> {
                            final long diff = System.currentTimeMillis() - startTime;
                            time.setText( timeFormat.format( diff ) );
                        }
                )
        );
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.playFromStart();
    }

    public long stop(){
        long result = System.currentTimeMillis() - startTime;
        timeline.stop();

        return result;
    }


}
