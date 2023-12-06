package sudoku;

import javax.swing.JMenuItem;

public class Timer extends Thread {

    private final JMenuItem timerMenuItem;
    private int seconds;
    private boolean isRunning;
    private static Timer instance;

    private Timer(JMenuItem timerMenuItem) {
        this.timerMenuItem = timerMenuItem;
        this.isRunning = false;  // Inicializa como false
    }
    
    public static Timer getInstance(JMenuItem timerMenuItem) {
    	if(instance == null)
    		instance = new Timer(timerMenuItem);
    	return instance;
    }

    public void startTimer() {
        isRunning = true;
        start();  // Inicia a thread
    }
    
//    public void restartTimer() {
//    	isRunning = true;
//    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                sleep(1000);  // Aguardta 1 segundo
                seconds++;
                updateTimer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateTimer() {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        String formattedTime = String.format("Tempo: %02d:%02d", minutes, remainingSeconds);
        timerMenuItem.setText(formattedTime);
    }

    public void reset() {
    	isRunning = true;
        seconds = 0;
        updateTimer();
    }

//    @SuppressWarnings("deprecation")
	public void customStop() {
        isRunning = false;
//    	stop();
        interrupt();
    }
}
