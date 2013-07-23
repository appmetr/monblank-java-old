package com.appmetr.monblank;

import java.io.Serializable;

/**
 * Note. This class is NOT thread-safe!
 * However, most likely you will be using it as local scope variable in methods.
 */
public class StopWatch implements Serializable {

    protected static final int NOT_STARTED = 0;

    protected static final int RUNNING = 1;
    protected static final int PAUSED = 2;

    protected static final int STOPPED = 10;

    private long elapsedTime;
    private long startTime;

    private long lapTime;
    private long lapStartTime;
    private int state = NOT_STARTED;


    public StopWatch() {
    }

    /**
     * Starts timer if it wasn't started yet.
     * @return started timer
     */
    public StopWatch start() {
        if (state == NOT_STARTED) {
            state = RUNNING;
            this.startTime = System.currentTimeMillis();
            this.elapsedTime = 0L;
        }
        return this;
    }

    /**
     * Reset's all timer's counters
     * @return current timer
     */
    public StopWatch reset() {
        elapsedTime = 0;
        lapTime = 0;
        startTime = 0;
        lapStartTime = 0;
        state = NOT_STARTED;
        return this;
    }

    /**
     * Resumes paused timer and lap time. Does nothing if wasn't paused.
     */
    public void resume() {
        if (state == PAUSED) {
            startTime = lapStartTime = System.currentTimeMillis();
            state = RUNNING;
        }
    }

    /**
     * Pause whole timer including lap time. Does nothing if wasn't running.
     * @return elapsed time at pause moment.
     */
    public long pause() {
        if (state == RUNNING) {
            final long currentTimestamp = System.currentTimeMillis();
            elapsedTime += currentTimestamp - startTime;
            if (lapStartTime > 0) {
                lapTime += currentTimestamp - lapStartTime;
            }
            state = PAUSED;
        }
        return elapsedTime;
    }

    /**
     * Starts new lap timer, main timer not affected.
     * @return last lap time. If no lap were measured - returns 0.
     */
    public long lap() {
        final long currentMillis = System.currentTimeMillis();

        lapTime += lapStartTime > 0 ? currentMillis - lapStartTime : 0;
        long existedLap = lapTime;
        lapTime = 0;

        lapStartTime = currentMillis;

        return existedLap;
    }

    /**
     * Stops timer, cannot be resumed\started after.
     * @return elapsed time
     */
    public long stop() {
        if (state != STOPPED) {
            final long elapsedTime = pause();
            state = STOPPED;
            return elapsedTime;
        }
        return elapsedTime;
    }

    /**
     * @return Elapsed time
     * If stopwatch is {@link #RUNNING} - returns time elapsed from start to current moment<br/>
     * If stopwatch was {@link #PAUSED} or {@link #STOPPED} - measured time from start until was paused or stopped.
     */
    public long getElapsedTime() {
        if (state == RUNNING) {
            return System.currentTimeMillis() - startTime;
        }
        return elapsedTime;
    }

    /**
     * Available states are:<br/>
     * <code>{@link #NOT_STARTED}</code><br/>
     * <code>{@link #RUNNING}</code><br/>
     * <code>{@link #PAUSED}</code><br/>
     * <code>{@link #STOPPED}</code><br/>
     * @return current stopwatch state
     */
    protected int getState() {
        return state;
    }

    protected long getStartTime() {
        return startTime;
    }

    protected long getLapTime() {
        return lapTime;
    }

    protected long getLapStartTime() {
        return lapStartTime;
    }

    /**
     * @return elapsed time in format "00 m 00 s 000 ms"
     */
    @Override public String toString() {
        StringBuilder builder = new StringBuilder("StopWatch elapsedTime = ");
        long eTime = getElapsedTime();
        builder.append(String.format("%02d m ", eTime / (60 * 1000)));
        eTime = eTime % (1000 * 60);
        builder.append(String.format("%02d s ", eTime / 1000));
        eTime = eTime % 1000;
        builder.append(String.format("%03d ms.", eTime));
        return builder.toString();
    }

    /**
     * Thus you must use it by calling {@link #resume()} method, not {@link #start()}.
     * @return StopWatch object in paused state.
     */
    public static StopWatch paused() {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.state = PAUSED;
        return stopWatch;
    }

    /**
     * @return Started StopWatch object. Repeated call of {@link #start} wouldn't have any effects.
     */
    public static StopWatch started() {
        return new StopWatch().start();
    }
}
