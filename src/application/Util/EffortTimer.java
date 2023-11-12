package application.Util;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

public class EffortTimer extends AnimationTimer {

	  private Label timeText;
	  private long startTime;
	  private long pauseTime = 0;
	  private long lastTime = 0;
	  private boolean start = true;
	  private boolean pause = false;

	  private int duration;

	  public EffortTimer(Label timeText) {
	    this.timeText = timeText;	    
	  }

	  public int getDuration() { return duration; }

	  @Override
	  public void handle(long now) {
	    lastTime = now;
	    if (pause) {
	      pause = false;
	      startTime += now - pauseTime;
	    }
	    if (start) {
	      start = false;
	      startTime = now;
	    }

	    duration = (int)((now - startTime) / 1_000_000_000L);
	    
	    int minutes = duration / 60;
	    int seconds = duration % 60;
	    timeText.setText(String.format("%d:%02d", minutes, seconds));
	  }

	  public void reset() {
	    start = true;
	  }

	  public void pause() {
	    pauseTime = lastTime;
	    pause = true;
	  }

	}
