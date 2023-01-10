package DestinyBack;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LevelProgression {
    @Id
    private long progressionHash;
    private int dailyProgress;
    private int dailyLimit;

    private int weeklyProgress;

    public long getProgressionHash() {
        return progressionHash;
    }

    public void setProgressionHash(long progressionHash) {
        this.progressionHash = progressionHash;
    }

    public int getDailyProgress() {
        return dailyProgress;
    }

    public void setDailyProgress(int dailyProgress) {
        this.dailyProgress = dailyProgress;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(int dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public int getWeeklyProgress() {
        return weeklyProgress;
    }

    public void setWeeklyProgress(int weeklyProgress) {
        this.weeklyProgress = weeklyProgress;
    }

    public int getWeeklyLimit() {
        return weeklyLimit;
    }

    public void setWeeklyLimit(int weeklyLimit) {
        this.weeklyLimit = weeklyLimit;
    }

    public int getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(int currentProgress) {
        this.currentProgress = currentProgress;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevelCap() {
        return levelCap;
    }

    public void setLevelCap(int levelCap) {
        this.levelCap = levelCap;
    }

    public int getStepIndex() {
        return stepIndex;
    }

    public void setStepIndex(int stepIndex) {
        this.stepIndex = stepIndex;
    }

    public int getProgressToNextLevel() {
        return progressToNextLevel;
    }

    public void setProgressToNextLevel(int progressToNextLevel) {
        this.progressToNextLevel = progressToNextLevel;
    }

    public int getNextLevelAt() {
        return nextLevelAt;
    }

    public void setNextLevelAt(int nextLevelAt) {
        this.nextLevelAt = nextLevelAt;
    }

    private int weeklyLimit;
    private int currentProgress;
    private int level;
    private int levelCap;
    private int stepIndex;
    private int progressToNextLevel;
    private int nextLevelAt;
}
