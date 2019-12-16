package com.londonappbrewery.destini;

public class StoryClass {
    int storyTextID;
    int topAnswerID;
    int downAnswerID;
    int topPath=0;
    int downPath=0;
    public StoryClass(int storyTextID, int topAnswerID, int downAnswerID, int topPath, int downPath)
    {
        this.storyTextID = storyTextID;
        this.topAnswerID = topAnswerID;
        this.downAnswerID = downAnswerID;
        this.topPath=topPath;
        this.downPath=downPath;
    }
    public int getStoryTextID() {
        return storyTextID;
    }

    public void setStoryTextID(int storyTextID) {
        this.storyTextID = storyTextID;
    }

    public int getTopAnswerID() {
        return topAnswerID;
    }

    public void setTopAnswerID(int topAnswerID) {
        this.topAnswerID = topAnswerID;
    }

    public int getDownAnswerID() {
        return downAnswerID;
    }

    public void setDownAnswerID(int downAnswerID) {
        this.downAnswerID = downAnswerID;
    }

    public int getTopPath() {
        return topPath;
    }

    public void setTopPath(int topPath) {
        this.topPath = topPath;
    }

    public int getDownPath() {
        return downPath;
    }

    public void setDownPath(int downPath) {
        this.downPath = downPath;
    }
}
